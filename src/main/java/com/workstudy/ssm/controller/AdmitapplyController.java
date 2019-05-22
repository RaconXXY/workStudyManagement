package com.workstudy.ssm.controller;

import com.workstudy.ssm.model.Admitapply;
import com.workstudy.ssm.service.AdmitapplyService;
import com.workstudy.ssm.utils.ResponseData;
import com.workstudy.ssm.utils.WordGenerator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alander on 2017/8/2.
 */
//励志生申请表
@Controller
public class AdmitapplyController {
    private Logger log = Logger.getLogger(AdmitapplyController.class);

    @Resource
    private AdmitapplyService admitapplyService;

    @PostMapping("/admitapplytable")
    @ResponseBody
    public Map admitapplytable(@RequestBody Admitapply table) {
        String message = admitapplyService.createTable(table);
        ResponseData resdata = ResponseData.ok();
        if (!message.equals("申请表登记成功！")) {
            resdata = ResponseData.customerError();
        }
        resdata.putDataValue("result", message);
        return resdata.toMap();
    }

    @PostMapping("/admitapplytablesave")
    public void save(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<>();

        Enumeration<String> paramNames = req.getParameterNames();
        // 通过循环将表单参数放入键值对映射中
        while (paramNames.hasMoreElements()) {
            String key = paramNames.nextElement();
            String value = req.getParameter(key);
            map.put(key, value);
        }
        // 发现每个字段的值末尾莫名其妙多了/所以去掉它
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
////            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//            String str = entry.getValue().toString();
//            entry.setValue(str.substring(0, str.length() - 1));
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }
        // TODO 检查字段完整性
        // 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
        // 否则Freemarker的模板在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了

//        WordGenerator.save(res, map, "Admitapply", "Admitapply");
        WordGenerator.save(res, map, "Admitapply", "杭州师范大学家庭经济困难学生认定申请表");

    }
}
