package com.workstudy.ssm.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.workstudy.ssm.vo.TestVo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.workstudy.ssm.utils.ExportExcelUtil;
import com.workstudy.ssm.vo.InfoVo;

@Controller
@RequestMapping("/ExportExcel/*")
public class ExportExcelController {

    @RequestMapping(value = "ajaxExport.do", method = {RequestMethod.GET, RequestMethod.POST})
    public void saveExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("通过poi导出excel文件！");

        //模拟数据库取值
        List<InfoVo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestVo vo = new TestVo();
            vo.setCode("110" + i);
            vo.setDate("2015-11-0" + i);
            vo.setMoney("1000" + i + ".00");
            vo.setName("北京中支0" + i);
            list.add(vo);
        }

        ExportExcelUtil.save(response, TestVo.lastRow, list, "测试模板.xlsx", "测试.xlsx");
    }
}
