package com.workstudy.ssm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.workstudy.ssm.utils.WordGenerator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Servlet implementation class MyServlet
 */
@Controller
public class SaveWordController {

    private Logger log = Logger.getLogger(SaveWordController.class);

    @PostMapping("/saveWordTest")
    public void saveWord(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<>();
        Enumeration<String> paramNames = req.getParameterNames();
        // 通过循环将表单参数放入键值对映射中
        while (paramNames.hasMoreElements()) {
            String key = paramNames.nextElement();
            String value = req.getParameter(key);
            map.put(key, value);
        }

        // TODO 检查字段完整性
        // 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
        // 否则Freemarker的模板在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了

        WordGenerator.save(res, map, "resume", "resume");
    }

}
