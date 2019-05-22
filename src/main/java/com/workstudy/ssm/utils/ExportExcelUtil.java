package com.workstudy.ssm.utils;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.workstudy.ssm.vo.InfoVo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;

public class ExportExcelUtil {

    private final static String excel2003L = ".xls";    //2003- 版本的excel
    private final static String excel2007U = ".xlsx";   //2007+ 版本的excel
    private static CellStyle globalcs = null;

    /**
     * 根据模板的名字获取项目中的文件
     */
    private static File getExcelFile(String tmpName) throws Exception {
        String classDir = null;
        File file = null;
        URL url = Thread.currentThread().getContextClassLoader().getResource("/");
        if (url != null) {
            classDir = url.getPath();
        } else {
            throw new Exception("出大事啦！Thread.currentThread().getContextClassLoader().getResource(\"/\")变成null了！！！");
        }

        //处理文件路径有空格的问题
        String dir = classDir + "template/" + tmpName;
        dir = java.net.URLDecoder.decode(dir, "utf-8");
        System.out.println(dir);

        file = new File(dir);
        if (!file.exists()) {
            throw new Exception("模板文件不存在！");
        }
        return file;
    }

    /**
     * 解析文件
     */
    private static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(inStr);  //2003-
        } else if (excel2007U.equals(fileType)) {
            wb = new XSSFWorkbook(inStr);  //2007+
        } else {
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 获取原先的Cell样式
     */

    private static CellStyle getCellStyle(Sheet sheet, int rowIndex, int columnIndex) {
//        System.out.println(rowIndex + " , " + columnIndex);
        if (globalcs == null) {
            globalcs = sheet.getWorkbook().createCellStyle();
        }
        CellStyle cs = globalcs;

        Row row = sheet.getRow(rowIndex);
        if (row == null)
            return cs;
        Cell cell = row.getCell(columnIndex);
        if (cell == null)
            return cs;
        cs = cell.getCellStyle();
        return cs;
    }

    private static Workbook writeNewExcel(File file, List<InfoVo> list, int lastRow) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = getWorkbook(fis, file.getName());    //获取工作薄
        globalcs = null;  //清除全局的样式，不然就是上一个的样式了
        Sheet sheet = wb.getSheetAt(0);

        //注意getLastRowNum是从0开始计数的，lastRow是Excel从1开始计数的
        //所以一行都没有的话应该是lastRow = getLastRowNum - 1
        //这个if表示至少有一个空行才移动，不然就报错了。。。
        if (sheet.getLastRowNum() >= lastRow)
            sheet.shiftRows(lastRow, sheet.getLastRowNum(), list.size(), true, false);

        //循环插入数据
        for (int i = 0; i < list.size(); i++) {
            //先用shift把要插入的行到最后一行往下移1，再在要插入的行的位置新建行
            //因为直接createRow的话会吧当前行覆盖的
            //当然为了格式问题现在已经重构成了上面的if，一次性移动全部的 (0.0)
//            sheet.shiftRows(lastRow + i, sheet.getLastRowNum(), 1, true, false);
            Row row = sheet.createRow(lastRow + i); //创建新的ROW，用于数据插入

            //按项目实际需求，在该处将对象数据插入到Excel中
            InfoVo vo = list.get(i);
            if (null == vo) {
                break;
            }

            for (int j = 0; j < vo.getFieldLenth(); j++) {
                CellStyle cs = getCellStyle(sheet, lastRow + list.size(), j);
                CellStyle newcs = globalcs;
                newcs.cloneStyleFrom(cs);
                Cell cell = row.createCell(j);
                cell.setCellValue(vo.getDataField(j));
                cell.setCellStyle(newcs);
            }

        }
        return wb;
    }


    /**
     * @param response res对象
     * @param lastRow  excel期望插入的上一行（就是有数据的最后一行）
     * @param lo       数据列表
     * @param tmpName  模板文件名
     * @param fileName 下载文件文件名
     */
    public static void save(HttpServletResponse response, int lastRow, List<InfoVo> lo, String tmpName, String fileName) {
        OutputStream os = null;
        Workbook wb = null;    //工作薄

        try {
            //导出Excel文件数据
            File file = getExcelFile(tmpName);
            wb = writeNewExcel(file, lo, lastRow);

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
            os = response.getOutputStream();
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (wb != null) {
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
