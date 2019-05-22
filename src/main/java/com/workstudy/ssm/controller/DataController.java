package com.workstudy.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.workstudy.ssm.model.*;
import com.workstudy.ssm.service.*;
import com.workstudy.ssm.utils.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alander on 2017/8/1.
 */

@Controller
public class DataController {
    private Logger log = Logger.getLogger(TodoController.class);
    @Resource
    private ClassInfoService classInfoService;
    @Resource
    private QuestionaryService questionaryService;
    @Resource
    private EncouragementService encouragementService;
    @Resource
    private AdmitapplyService admitapplyService;
    @Resource
    private StipendService stipendService;
    @Resource
    private ScholarshipService scholarshipService;
    @Resource
    private DiscountFeeService discountFeeService;

    @GetMapping("/getClassInfo")
    @ResponseBody
    public Map<String, Object> getClassInfo() {
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("data", classInfoService.getAllAcademy());
        return responseData.toMap();
    }
}
