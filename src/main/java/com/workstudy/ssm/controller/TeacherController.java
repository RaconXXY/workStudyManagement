package com.workstudy.ssm.controller;

import com.workstudy.ssm.model.*;
import com.workstudy.ssm.service.*;
import com.workstudy.ssm.utils.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alander on 2017/8/16.
 */
@Controller
public class TeacherController {
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

    private String getCurrentYear () {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }


    @PostMapping("/getTeacherClasses")
    @ResponseBody
    public Map<String, Object> getTeacherClasses (@RequestBody Map map) {
        List<Map> classInfos = new ArrayList<Map>();

        String teacherId = (String)map.get("userId");
        List<ClassInfo> classInfoList = classInfoService.getClassById(teacherId);
        for (ClassInfo classInfo : classInfoList) {
            String finalName = classInfo.getMajor() + classInfo.getClassName();
            Map<String, String> item = new HashMap<>();
            item.put("name", finalName);
            classInfos.add(item);
        }
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("classInfoList", classInfos);
        return responseData.toMap();
    }

    /**
     *
     *  教师端查看路由
     *
     * */

    // 励志生认定
    @PostMapping("/getTeacherAdmitApplySts")
    @ResponseBody
    public Map<String, Object> getTeacherAdmitApplySts (@RequestBody Map map) {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        List<Map> userInfos = new ArrayList<Map>();
        List<User> users = new ArrayList<User>();

        String teacherId = (String)map.get("userId");
        List<ClassInfo> classInfoList = classInfoService.getClassById(teacherId);
        for (ClassInfo classInfo : classInfoList) {
            users.addAll(userService.getUsersByClass(classInfo));
        }
        // 封装返回数据
        for(User user : users) {
            Map<String, String> m = new HashMap<>();
            Admitapply table = null;
            List<Admitapply> admitapplies = admitapplyService.getTableByStId(user.getUserId());
            for (Admitapply admitapply : admitapplies) {
                if (admitapply.getTableYear().equals(createdYear)) {
                    table = admitapply;
                }
            }
            if (null != table) {
                m.put("className", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                String assessStatus = table.getTeacherResult() == -1 ? "false" : "true";
                m.put("assessStatus", assessStatus);
                m.put("result", String.valueOf(table.getTeacherResult()));
                m.put("createdYear", createdYear);
                m.put("studentId", table.getStudentId());
                userInfos.add(m);
            }

        }
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }

    // 国家助学金
    @PostMapping("/getTeacherStipendSts")
    @ResponseBody
    public Map<String, Object> getTeacherStipendSts (@RequestBody Map map) {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        List<Map> userInfos = new ArrayList<Map>();
        List<User> users = new ArrayList<User>();

        String teacherId = (String)map.get("userId");
        List<ClassInfo> classInfoList = classInfoService.getClassById(teacherId);
        for (ClassInfo classInfo : classInfoList) {
            users.addAll(userService.getUsersByClass(classInfo));
        }
        for(User user : users) {
            Map<String, String> m = new HashMap<>();
            Stipend table = null;
            List<Stipend> stipends = stipendService.getTableByStId(user.getUserId());
            for (Stipend stipend : stipends) {
                if (stipend.getTableYear().equals(createdYear)) {
                    table = stipend;
                }
            }
            if (null != table) {
                m.put("className", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                String assessStatus = table.getTeacherResult() == -1 ? "false" : "true";
                m.put("assessStatus", assessStatus);
                m.put("result", String.valueOf(table.getTeacherResult()));
                m.put("createdYear", createdYear);
                m.put("studentId", table.getStudentId());
                userInfos.add(m);
            }
        }
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }

    // 励志奖学金
    @PostMapping("/getTeacherEncouragementSts")
    @ResponseBody
    public Map<String, Object> getTeacherEncouragementSts (@RequestBody Map map) {

        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        List<Map> userInfos = new ArrayList<Map>();
        List<User> users = new ArrayList<User>();

        String teacherId = (String)map.get("userId");
        List<ClassInfo> classInfoList = classInfoService.getClassById(teacherId);
        for (ClassInfo classInfo : classInfoList) {
            users.addAll(userService.getUsersByClass(classInfo));
        }
        for(User user : users) {
            Map<String, String> m = new HashMap<>();
            Encouragement table = null;
            List<Encouragement> encouragements = encouragementService.getTableByStId(user.getUserId());
            for (Encouragement encouragement : encouragements) {
                if (encouragement.getTableYear().equals(createdYear)) {
                    table = encouragement;
                }
            }
            if (null != table) {
                m.put("className", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                String assessStatus = table.getTeacherResult() == -1 ? "false" : "true";
                m.put("assessStatus", assessStatus);
                m.put("result", String.valueOf(table.getTeacherResult()));
                m.put("createdYear", createdYear);
                m.put("studentId", table.getStudentId());
                userInfos.add(m);
            }
        }
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }

    // 国家奖学金
    @PostMapping("/getTeacherScholarshipSts")
    @ResponseBody
    public Map<String, Object> getTeacherScholarshipSts (@RequestBody Map map) {

        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        List<Map> userInfos = new ArrayList<Map>();
        List<User> users = new ArrayList<User>();

        String teacherId = (String)map.get("userId");
        List<ClassInfo> classInfoList = classInfoService.getClassById(teacherId);
        for (ClassInfo classInfo : classInfoList) {
            users.addAll(userService.getUsersByClass(classInfo));
        }
        for(User user : users) {
            Map<String, String> m = new HashMap<>();
            Scholarship table = null;
            List<Scholarship> scholarships = scholarshipService.getTableByStId(user.getUserId());
            for (Scholarship scholarship : scholarships) {
                if (scholarship.getTableYear().equals(createdYear)) {
                    table = scholarship;
                }
            }
            if (null != table) {
                m.put("className", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                String assessStatus = table.getTeacherResult() == -1 ? "false" : "true";
                m.put("assessStatus", assessStatus);
                m.put("result", String.valueOf(table.getTeacherResult()));
                m.put("createdYear", createdYear);
                m.put("studentId", table.getStudentId());
                userInfos.add(m);
            }
        }
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }

    // 学费减免表
    @PostMapping("/getTeacherDiscountFeeSts")
    @ResponseBody
    public Map<String, Object> getTeacherDiscountFeeSts (@RequestBody Map map) {

        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        List<Map> userInfos = new ArrayList<Map>();
        List<User> users = new ArrayList<User>();

        String teacherId = (String)map.get("userId");
        List<ClassInfo> classInfoList = classInfoService.getClassById(teacherId);
        for (ClassInfo classInfo : classInfoList) {
            users.addAll(userService.getUsersByClass(classInfo));
        }
        for(User user : users) {
            Map<String, String> m = new HashMap<>();
            DiscountFee table = null;
            List<DiscountFee> discountFees = discountFeeService.getTableByStId(user.getUserId());
            for (DiscountFee discountFee : discountFees) {
                if (discountFee.getTableYear().equals(createdYear)) {
                    table = discountFee;
                }
            }
            if (null != table) {
                m.put("className", user.getMajor()+user.getClassName());
                m.put("name", user.getName());
                String assessStatus = table.getTeacherResult() == -1 ? "false" : "true";
                m.put("assessStatus", assessStatus);
                m.put("result", String.valueOf(table.getTeacherResult()));
                m.put("createdYear", createdYear);
                m.put("studentId", table.getStudentId());
                userInfos.add(m);
            }
        }
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }

    // 励志生库
    @PostMapping("/getTeacherLibSts")
    @ResponseBody
    public Map<String, Object> getTeacherLibSts (@RequestBody Map map) {
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        List<Map> userInfos = new ArrayList<Map>();
        List<User> users = new ArrayList<User>();

        String teacherId = (String)map.get("userId");
        List<ClassInfo> classInfoList = classInfoService.getClassById(teacherId);
        for (ClassInfo classInfo : classInfoList) {
            users.addAll(userService.getUsersByClass(classInfo));
        }
        // 封装返回数据
        for(User user : users) {
            Map<String, String> m = new HashMap<>();
            Admitapply table = null;
            List<Admitapply> admitapplies = admitapplyService.getTableByStId(user.getUserId());
            for (Admitapply admitapply : admitapplies) {
                if (admitapply.getTableYear().equals(createdYear) && admitapply.getAdminResult() > 0) {
                    table = admitapply;
                }
            }
            if (null != table) {
                m.put("className", user.getMajor()+user.getClassName());
                m.put("institute", user.getAcademy());
                m.put("name", user.getName());
                m.put("createdYear", createdYear);
                m.put("studentId", table.getStudentId());
                m.put("gender", table.getSex());
                userInfos.add(m);
            }

        }
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("userInfos", userInfos);
        return responseData.toMap();
    }


    /**
     *
     *  教师端评定路由
     *
     * */

    // 励志生认定
    @PostMapping("/changeTeacherAdmitApplySt")
    @ResponseBody
    public Map<String, Object> changeTeacherAdmitApplySt (@RequestBody Map map) {
        String studentId = (String) map.get("studentId");
        String tableYear = (String) map.get("createdYear");
        Integer result = Integer.parseInt((String)map.get("result"));
        Admitapply form = admitapplyService.getTable(studentId, tableYear);
        ResponseData responseData;
        String message = admitapplyService.changeTable(studentId, tableYear, result);
        log.info(message);
        if(message.equals("申请表修改成功！")) {
            if (form.getAdminResult() > 0 && result > 0 && !studentLibService.getItemById(studentId, tableYear)) {
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
                studentLibService.createItem(studentLib);
            }
            responseData = ResponseData.ok();
        }
        else {
            responseData = ResponseData.customerError();
        }
        responseData.putDataValue("message", message);
        return responseData.toMap();
    }

    // 国家助学金
    @PostMapping("/changeTeacherStipendSt")
    @ResponseBody
    public Map<String, Object> changeTeacherStipendSt (@RequestBody Map map) {
        String studentId = (String) map.get("studentId");
        String tableYear = (String) map.get("createdYear");
        Integer result = Integer.parseInt((String)map.get("result"));
        ResponseData responseData;
        String message = stipendService.changeTable(studentId, tableYear, result);
        log.info(message);
        if(message.equals("申请表修改成功！")) {
            responseData = ResponseData.ok();
        }
        else {
            responseData = ResponseData.customerError();
        }
        responseData.putDataValue("message", message);
        return responseData.toMap();
    }

    // 励志奖学金
    @PostMapping("/changeTeacherEncouragementSt")
    @ResponseBody
    public Map<String, Object> changeTeacherEncouragementSt (@RequestBody Map map) {
        String studentId = (String) map.get("studentId");
        String tableYear = (String) map.get("createdYear");
        Integer result = Integer.parseInt((String)map.get("result"));
        ResponseData responseData;
        String message = encouragementService.changeTable(studentId, tableYear, result);
        log.warn(message);
        if(message.equals("申请表修改成功！")) {
            responseData = ResponseData.ok();
        }
        else {
            responseData = ResponseData.customerError();
        }
        responseData.putDataValue("message", message);
        return responseData.toMap();
    }

    // 国家奖学金
    @PostMapping("/changeTeacherScholarshipSt")
    @ResponseBody
    public Map<String, Object> changeTeacherScholarshipSt (@RequestBody Map map) {
        String studentId = (String) map.get("studentId");
        String tableYear = (String) map.get("createdYear");
        Integer result = Integer.parseInt((String)map.get("result"));
        ResponseData responseData;
        String message = scholarshipService.changeTable(studentId, tableYear, result);

        if(message.equals("申请表修改成功！")) {
            responseData = ResponseData.ok();
        }
        else {
            responseData = ResponseData.customerError();
        }
        responseData.putDataValue("message", message);
        return responseData.toMap();
    }

    // 学费减免
    @PostMapping("/changeTeacherDiscountFeeSt")
    @ResponseBody
    public Map<String, Object> changeTeacherDiscountFeeSt (@RequestBody Map map) {
        String studentId = (String) map.get("studentId");
        String tableYear = (String) map.get("createdYear");
        Integer result = Integer.parseInt((String)map.get("result"));
       ResponseData responseData;
        String message = discountFeeService.changeTable(studentId, tableYear, result);
        if(message.equals("申请表修改成功！")) {
            responseData = ResponseData.ok();
        }
        else {
            responseData = ResponseData.customerError();
        }
        responseData.putDataValue("message", message);
        return responseData.toMap();
    }

}
