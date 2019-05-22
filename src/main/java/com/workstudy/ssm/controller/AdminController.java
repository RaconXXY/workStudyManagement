package com.workstudy.ssm.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.workstudy.ssm.model.*;
import com.workstudy.ssm.service.*;
import com.workstudy.ssm.utils.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alander on 2017/8/17.
 */

@Controller
public class AdminController {
    private Logger log = Logger.getLogger(TodoController.class);
    @Resource
    ClassInfoService classInfoService;
    @Resource
    UserService userService;
    @Resource
    AdmitapplyService admitapplyService;
    @Resource
    StipendService stipendService;
    @Resource
    EncouragementService encouragementService;
    @Resource
    ScholarshipService scholarshipService;
    @Resource
    DiscountFeeService discountFeeService;
    @Resource
    StudentLibService studentLibService;
    @Resource
    QuestionaryService questionaryService;
    @Resource
    TimeControlService timeControlService;

    private String getCurrentYear () {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }


    private Map generateChangeRes(Map map, String type) {
        String studentId = (String) map.get("studentId");
        String tableYear = (String) map.get("createdYear");
        Integer result = Integer.parseInt((String)map.get("result"));
        ResponseData responseData = ResponseData.ok();
        String message;
        if (type.equals("admitapply")) {
            message = admitapplyService.changeAdminRes(studentId, tableYear, result);
        }
        else if (type.equals("stipend")) {
            message = stipendService.changeAdminRes(studentId, tableYear, result);
        }
        else if (type.equals("encouragement")) {
            message = encouragementService.changeAdminRes(studentId, tableYear, result);
        }
        else if (type.equals("scholarship")) {
            message = scholarshipService.changeAdminRes(studentId, tableYear, result);
        }
        else {
            message = discountFeeService.changeAdminRes(studentId, tableYear, result);
        }

        if(!message.equals("申请表修改成功！")) {
            responseData = ResponseData.customerError();
        }
        return responseData.toMap();
    }

    private  Map generateDelTable(Map map, String type) {
        ResponseData responseData;
        String studentId = "";
        if (map.get("studentId") != null) {
            studentId = (String) map.get("studentId");
        }
        else {
            studentId = (String) map.get("idNumber");
        }
        String createdYear = "";
        if (map.get("createdYear") != null) {
            createdYear = (String) map.get("createdYear");
        }
        log.info(studentId);
        String message = "";

        if (type.equals("admitapply")) {
            message = admitapplyService.deleteTableByInfo(studentId, createdYear);
            studentLibService.delItemById(studentId, createdYear);
        }
        else if (type.equals("stipend")) {
            message = stipendService.deleteTableByInfo(studentId, createdYear);
        }
        else if (type.equals("encouragement")) {
            message = encouragementService.deleteTableByInfo(studentId, createdYear);
        }
        else if (type.equals("scholarship")) {
            message = scholarshipService.deleteTableByInfo(studentId, createdYear);
        }
        else if (type.equals("discountfee")) {
            message = discountFeeService.deleteTableByInfo(studentId, createdYear);
        }
        else if (type.equals("user")) {
            message = userService.delById(studentId);
        }

        if (message.equals("申请表删除成功！") || message.equals("删除成功！")) {
            responseData = ResponseData.ok();
        }
        else {
            responseData = ResponseData.customerError();
        }
        responseData.putDataValue("message", message);
        return responseData.toMap();
    }


    @PostMapping("/getAdminClasses")
    @ResponseBody
    public Map<String, Object> getAdminClasses () {
        Map<String, Object> responseMap = new HashMap<>();

        List<Map> classInfos = new ArrayList<Map>();
        List<ClassInfo> classInfoList = classInfoService.getAllAcademy();
        for (ClassInfo classInfo : classInfoList) {
            String finalName = classInfo.getMajor() + classInfo.getClassName();
            Map<String, String> item = new HashMap<>();
            item.put("name", finalName);
            classInfos.add(item);
        }
        responseMap.put("code", 200);
        responseMap.put("classInfoList", classInfos);
        return responseMap;
    }


    /**
     *
     *  管理员端查看路由
     *
     * */

    // 励志生认定
    @PostMapping("/getAdminAdmitApplySts")
    @ResponseBody
    public Map<String, Object> getAdminAdmitApplySts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData responseData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<Admitapply> admitapplies = admitapplyService.getAllTables();
        // 封装返回数据
        for (Admitapply admitapply : admitapplies) {
            if (admitapply.getTableYear().equals(createdYear)) {
                String studentId = admitapply.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("teacherRes", admitapply.getTeacherResult());
                m.put("adminRes", admitapply.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                userInfos.add(m);
            }
        }
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }

    // 国家助学金
    @PostMapping("/getAdminStipendSts")
    @ResponseBody
    public Map<String, Object> getAdminStipendSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData responseData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<Stipend> stipends = stipendService.getAllTables();
        // 封装返回数据
        for (Stipend stipend : stipends) {
            if (stipend.getTableYear().equals(createdYear)) {
                String studentId = stipend.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("teacherRes", stipend.getTeacherResult());
                m.put("adminRes", stipend.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                userInfos.add(m);
            }
        }
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }

    // 国家励志奖学金
    @PostMapping("/getAdminEncouragementSts")
    @ResponseBody
    public Map<String, Object> getAdminEncouragementSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData responseData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<Encouragement> encouragements = encouragementService.getAllTables();
        // 封装返回数据
        for (Encouragement encouragement : encouragements) {
            if (encouragement.getTableYear().equals(createdYear)) {
                String studentId = encouragement.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("teacherRes", encouragement.getTeacherResult());
                m.put("adminRes", encouragement.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                userInfos.add(m);
            }
        }
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }

    // 国家奖学金
    @PostMapping("/getAdminScholarshipSts")
    @ResponseBody
    public Map<String, Object> getAdminScholarshipSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData responseData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<Scholarship> scholarships = scholarshipService.getAllTables();
        // 封装返回数据
        for (Scholarship scholarship : scholarships) {
            if (scholarship.getTableYear().equals(createdYear)) {
                String studentId = scholarship.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("teacherRes", scholarship.getTeacherResult());
                m.put("adminRes", scholarship.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                userInfos.add(m);
            }
        }
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }

    // 学费减免
    @PostMapping("/getAdminDiscountFeeSts")
    @ResponseBody
    public Map<String, Object> getAdminDiscountFeeSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData responseData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<DiscountFee> discountFees = discountFeeService.getAllTables();
        // 封装返回数据
        for (DiscountFee discountFee : discountFees) {
            if (discountFee.getTableYear().equals(createdYear)) {
                String studentId = discountFee.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("teacherRes", discountFee.getTeacherResult());
                m.put("adminRes", discountFee.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                userInfos.add(m);
            }
        }
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }



    /**
     *
     *  管理员端评定路由
     *
     * */

    // 励志生
    @PostMapping("/changeAdminAdmitApplySt")
    @ResponseBody
    public Map<String, Object> changeAdminAdmitApplySt (@RequestBody Map map) {
        String studentId = (String) map.get("studentId");
        String tableYear = (String) map.get("createdYear");
        Integer result = Integer.parseInt((String)map.get("result"));
        log.info(result);
        if (result != 0 && !studentLibService.getItemById(studentId, tableYear)) {     // 写入励志生库
            StudentLib studentLib = new StudentLib();
            studentLib.setStudentId(studentId);
            studentLib.setTableYear(tableYear);
            studentLib.setIsLoan(0);
            studentLib.setIsWorkAndStudy(0);
            studentLib.setAwardsName("none");
            studentLib.setAwardsNumber("none");
            studentLib.setHelpsName("none");
            studentLib.setHelpsNumber("none");
            studentLib.setOther("none");
            studentLib.setIsCheckin(0);
            String message = studentLibService.createItem(studentLib);
            log.info(message);
        }
        else if (result == 0) {
            log.info("删除");
            String message = studentLibService.delItemById(studentId, tableYear);
            log.info(message);
        }
        return generateChangeRes(map, "admitapply");
    }

    // 国家助学金
    @PostMapping("/changeAdminStipendSt")
    @ResponseBody
    public Map<String, Object> changeAdminStipendSt (@RequestBody Map map) {
        return generateChangeRes(map, "stipend");
    }

    // 国家励志奖学金
    @PostMapping("/changeAdminEncouragementSt")
    @ResponseBody
    public Map<String, Object> changeAdminEncouragementSt (@RequestBody Map map) {
        return generateChangeRes(map, "encouragement");
    }

    // 国家奖学金
    @PostMapping("/changeAdminScholarshipSt")
    @ResponseBody
    public Map<String, Object> changeAdminScholarshipSt (@RequestBody Map map) {
        return generateChangeRes(map, "scholarship");
    }

    @PostMapping("/changeAdminDiscountFeeSt")
    @ResponseBody
    public Map<String, Object> changeAdminDiscountFeeSt (@RequestBody Map map) {
        return generateChangeRes(map, "discountfee");
    }


    // 励志生信息录入
    @GetMapping("/stuLibOperate")
    public String stuLibOperate (String studentId, String tableYear, Model model) {
        log.info(studentId+tableYear);
        User user = userService.getUserInfoById(studentId);
        Questionary questionary = questionaryService.getTable(studentId, tableYear);
        Admitapply admitapply = admitapplyService.getTable(studentId, tableYear);
        StudentLib studentLib = studentLibService.getItem(studentId, tableYear);
        log.info(admitapply.getAdminResult()+admitapply.getReason());
        model.addAttribute("user", user);
        model.addAttribute("questionary", questionary);
        model.addAttribute("studentLib", studentLib);
        model.addAttribute("reason", admitapply.getReason());
        model.addAttribute("isDiff", admitapply.getAdminResult());
        return "form/encouragestu_info";
    }




    /**
     *
     *  管理员端汇总查看路由
     *
     * */

    // 励志生
    @PostMapping("/getAdminAdmitApplyHZSts")
    @ResponseBody
    public Map<String, Object> getAdminAdmitApplyHZSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        List<Map> userInfos = new ArrayList<Map>();
        List<Admitapply> admitapplies = admitapplyService.getAllTables();
        ResponseData resData = ResponseData.ok();
        // 封装返回数据
        for (Admitapply admitapply : admitapplies) {
            if (admitapply.getTableYear().equals(createdYear)) {
                String studentId = admitapply.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("result", admitapply.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                m.put("institute", user.getAcademy());
                m.put("sex", admitapply.getSex());
                userInfos.add(m);
            }
        }
        resData.putDataValue("userInfos", userInfos);
        return resData.toMap();
    }

    // 国家助学金
    @PostMapping("/getStipendHZSts")
    @ResponseBody
    public Map<String, Object> getStipendHZSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData resData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<Stipend> stipends = stipendService.getAllTables();
        // 封装返回数据
        for (Stipend stipend : stipends) {
            if (stipend.getTableYear().equals(createdYear)) {
                String studentId = stipend.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("result", stipend.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                m.put("institute", user.getAcademy());
                m.put("sex", stipend.getSex());
                userInfos.add(m);
            }
        }
        resData.putDataValue("userInfos", userInfos);
        return resData.toMap();
    }

    // 国家励志奖学金
    @PostMapping("/getEncouragementHZSts")
    @ResponseBody
    public Map<String, Object> getEncouragementHZSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData resData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<Encouragement> encouragements = encouragementService.getAllTables();
        // 封装返回数据
        for (Encouragement encouragement : encouragements) {
            if (encouragement.getTableYear().equals(createdYear)) {
                String studentId = encouragement.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("result", encouragement.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                m.put("institute", user.getAcademy());
                m.put("sex", encouragement.getSex());
                userInfos.add(m);
            }
        }
        resData.putDataValue("userInfos", userInfos);
        return resData.toMap();
    }

    // 国家奖学金
    @PostMapping("/getScholarshipHZSts")
    @ResponseBody
    public Map<String, Object> getScholarshipHZSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData resData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<Scholarship> scholarships = scholarshipService.getAllTables();
        // 封装返回数据
        for (Scholarship scholarship : scholarships) {
            if (scholarship.getTableYear().equals(createdYear)) {
                String studentId = scholarship.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("result", scholarship.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                m.put("institute", user.getAcademy());
                m.put("sex", scholarship.getSex());
                userInfos.add(m);
            }
        }
        resData.putDataValue("userInfos", userInfos);
        return resData.toMap();
    }

    // 学费减免
    @PostMapping("/getDiscountFeeHZSts")
    @ResponseBody
    public Map<String, Object> getDiscountFeeHZSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData resData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<DiscountFee> discountFees = discountFeeService.getAllTables();
        // 封装返回数据
        for (DiscountFee discountFee : discountFees) {
            if (discountFee.getTableYear().equals(createdYear)) {
                String studentId = discountFee.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("result", discountFee.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                m.put("institute", user.getAcademy());
                m.put("sex", discountFee.getSex());
                userInfos.add(m);
            }
        }
        resData.putDataValue("userInfos", userInfos);
        return resData.toMap();
    }



    // 励志生库
    @PostMapping("/getAdmitApplyHZSts")
    @ResponseBody
    public Map<String, Object> getAdmitApplyHZSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData resData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<Admitapply> admitapplies = admitapplyService.getAllTables();
        // 封装返回数据
        for (Admitapply admitapply : admitapplies) {
            if (admitapply.getTableYear().equals(createdYear) && admitapply.getAdminResult() > 0) {
                String studentId = admitapply.getStudentId();
                User user = userService.getUserInfoById(studentId);
                Map<String, Object> m = new HashMap<>();
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("result", admitapply.getAdminResult());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                m.put("institute", user.getAcademy());
                m.put("sex", admitapply.getSex());
                userInfos.add(m);
            }
        }
        resData.putDataValue("userInfos", userInfos);
        return resData.toMap();
    }


    // 励志生信息管理
    @PostMapping("/getStuLibSts")
    @ResponseBody
    public Map<String, Object> getStuLibSts () {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        ResponseData resData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<Admitapply> admitapplies = admitapplyService.getAllTables();
        // 封装返回数据
        for (Admitapply admitapply : admitapplies) {
            if (admitapply.getTableYear().equals(createdYear) && admitapply.getAdminResult() > 0) {
                String studentId = admitapply.getStudentId();
                User user = userService.getUserInfoById(studentId);
                StudentLib studentLib = studentLibService.getItem(studentId, createdYear);
                Questionary questionary = questionaryService.getTable(studentId, createdYear);
                Map<String, Object> m = new HashMap<>();
                m.put("institute", user.getAcademy());
                m.put("class", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                m.put("sex", admitapply.getSex());
                m.put("studentId", user.getUserId());
                m.put("createdYear", createdYear);
                m.put("sex", admitapply.getSex());
                m.put("identifyId", questionary.getIdentityCardId());
                m.put("result", studentLib.getIsCheckin());
                userInfos.add(m);
            }
        }
        resData.putDataValue("userInfos", userInfos);
        return resData.toMap();
    }

    // 励志生信息录入
    @PostMapping("/saveEncourageLib")
    @ResponseBody
    public Map<String, Object> saveEncourageLib (@RequestBody StudentLib table) {
        ResponseData responseData = ResponseData.ok();
        if (studentLibService.getItemById(table.getStudentId(), table.getTableYear())) {
            studentLibService.delItemById(table.getStudentId(), table.getTableYear());
        }
        String message = studentLibService.createItem(table);
        if (message.equals("插入失败！")) {
            responseData = ResponseData.customerError();
        }
        return responseData.toMap();
    }

    // 账号管理
    @PostMapping("/getAdmitAccountSts")
    @ResponseBody
    public Map<String, Object> getAdmitAccountSts () {
        ResponseData responseData = ResponseData.ok();
        List<Map> userInfos = new ArrayList<Map>();
        List<User> users = userService.getAll();
        // 封装返回数据
        for (User user : users) {
                String studentId = user.getUserId();
                Map<String, Object> m = new HashMap<>();
                m.put("name", user.getName());
                m.put("idNumber", studentId);
                userInfos.add(m);
        }
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }

    // 账号查看
    @GetMapping("/userDetail")
    public String userDetail(String userId, Model model) {

        User user = userService.getUserInfoById(userId);
        model.addAttribute("user", user);
        return "form/account_manage";
    }



    /**
     *
     *  管理员端汇总删除路由
     *
     * */

    // 励志生认定
    @PostMapping("/delAdminAdmitApply")
    @ResponseBody
    public Map<String, Object> delAdminAdmitApply (@RequestBody Map map) {
        return generateDelTable(map, "admitapply");
    }

    // 国家助学金
    @PostMapping("/delAdminStipend")
    @ResponseBody
    public Map<String, Object> delAdminStipend (@RequestBody Map map) {
        return generateDelTable(map, "stipend");
    }

    // 国家励志奖学金
    @PostMapping("/delAdminEncouragement")
    @ResponseBody
    public Map<String, Object> delAdminEncouragement (@RequestBody Map map) {
        return generateDelTable(map, "encouragement");
    }

    // 国家奖学金
    @PostMapping("/delAdminScholarship")
    @ResponseBody
    public Map<String, Object> delAdminScholarship (@RequestBody Map map) {
        return generateDelTable(map, "scholarship");
    }

    // 学费减免
    @PostMapping("/delAdminDiscountFee")
    @ResponseBody
    public Map<String, Object> delAdminDiscountFee (@RequestBody Map map) {
        return generateDelTable(map, "discountfee");
    }

    // 账号
    @PostMapping("/delAdminUser")
    @ResponseBody
    public Map<String, Object> delAdminUser (@RequestBody Map map) {
        return generateDelTable(map, "user");
    }

    @PostMapping("/resetUserPwd")
    @ResponseBody
    public Map<String, Object> resetUserPwd  (@RequestBody Map map) {
        ResponseData responseData;
        String userId = (String) map.get("idNumber");
        // 那一串sha512的明文为123456
        String message = userService.resetPwdById(userId, "ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413");
        if ( message.equals("修改成功！")) {
            responseData = ResponseData.ok();
        }
        else {
            responseData = ResponseData.customerError();
        }
        responseData.putDataValue("message", message);
        return responseData.toMap();
    }


    // 修改时间控制
    @PostMapping("/timeControl")
    @ResponseBody
    public Map<String, Object> timeControl (@RequestBody TimeControl table) {
        log.info(table);
       ResponseData responseData;
       if (timeControlService.dealTime() && timeControlService.createTime(table)) {
           responseData = ResponseData.ok();
       }
       else {
           responseData = ResponseData.customerError();
       }
       return responseData.toMap();
    }

    // 获取时间
    @PostMapping("/getTimeControlInfo")
    @ResponseBody
    public Map<String, Object> getTimeControlInfo () {
        ResponseData responseData;
        TimeControl time = timeControlService.getTime();
        if (time != null) {
            responseData = ResponseData.ok();
            responseData.putDataValue("timeInfo", time);
        }
        else {
            responseData = ResponseData.customerError();
        }
        return responseData.toMap();
    }
}
