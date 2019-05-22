package com.workstudy.ssm.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.log4j.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import static freemarker.template.Configuration.VERSION_2_3_26;

public class WordGenerator {
    private static Logger log = Logger.getLogger(WordGenerator.class);
    private static Configuration configuration = null;
    private static Map<String, Template> allTemplates = null;

    static {
        configuration = new Configuration(VERSION_2_3_26);
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(WordGenerator.class, "/template");
        allTemplates = new HashMap<>();    // Java 7 钻石语法
        try {
            allTemplates.put("resume", configuration.getTemplate("resume.ftl"));
            allTemplates.put("Admitapply", configuration.getTemplate("Admitapply.ftl"));
            allTemplates.put("Encouragement", configuration.getTemplate("Encouragement.ftl"));
            allTemplates.put("Stipend", configuration.getTemplate("Stipend.ftl"));
            allTemplates.put("DiscountFee", configuration.getTemplate("DiscountFee.ftl"));
            allTemplates.put("Scholarship", configuration.getTemplate("Scholarship.ftl"));
            allTemplates.put("Questionary", configuration.getTemplate("Questionary.ftl"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private WordGenerator() {
        throw new AssertionError();
    }

    private static File createDoc(Map<?, ?> dataMap, String type) {
        String name = "temp" + (int) (Math.random() * 100000) + ".doc";
        File f = new File(name);
        Template t = allTemplates.get(type);
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
             Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            System.out.println(dataMap);
            System.out.println(w);
            t.process(dataMap, w);
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }

    public static void save(HttpServletResponse res, Map<String, Object> map, String tmpName, String fileName) {
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            // 调用工具类WordGenerator的createDoc方法生成Word文档
            file = WordGenerator.createDoc(map, tmpName);
            fin = new FileInputStream(file);

            res.setCharacterEncoding("utf-8");
            res.setContentType("application/msword");
            // 设置浏览器以下载的方式处理该文件默认名为wordName.doc,但是中文会乱码
//            res.addHeader("Content-Disposition", "attachment;filename=" + fileName + ".doc");
            //文字超过17个字就会无法下载
//            res.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName + ".doc", "UTF-8"));
            // 文件名必须全部为简体中文
            res.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".doc").getBytes("gb2312"), "ISO8859-1"));
            out = res.getOutputStream();
            byte[] buffer = new byte[512];    // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (out != null) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            boolean deleted;
            if (file != null) {
                deleted = file.delete();    // 删除临时文件
                if (!deleted) {
                    log.info("temp file is not deleted!");
                }
            }
        }
    }
}
