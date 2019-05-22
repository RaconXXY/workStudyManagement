package com.workstudy.ssm.controller;

import com.workstudy.ssm.model.*;
import com.workstudy.ssm.service.*;
import com.workstudy.ssm.utils.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alander on 2017/8/14.
 */
@Controller
public class StudentController {
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
    @Resource
    private FamilyMemberService familyMemberService;
    @Resource
    private PrizeService prizeService;
    @Resource
    private AwardService awardService;
    @Resource
    private HelpService helpService;
    @Resource
    private UserService userService;
    @Resource
    private StudentLibService studentLibService;

    private Map getDelStuResponseMap(String message) {
        ResponseData resdata = ResponseData.ok();
        if (!message.equals("申请表删除成功！")) {
            resdata = ResponseData.customerError();
        }
        resdata.putDataValue("result", message);
        return resdata.toMap();
    }


    /**
     *
     * 学生端查询数据路由
     *
     * */
    //家庭情况调查表
    @PostMapping("/getStNavFamilyTables")
    @ResponseBody
    public Map<String, Object> getStNavFamilyTables (@RequestBody Map map) {
        ResponseData responseData = ResponseData.ok();
        String studentId = (String) map.get("studentId");
        List<Questionary> responseDate = questionaryService.getTableByStId(studentId);
        List<FamilyMember> members = familyMemberService.getMembersByStId(studentId);

        for (Questionary questionary : responseDate) {
            questionary.setFamilyMember(members);
        }
        responseData.putDataValue("date", responseDate);
        return responseData.toMap();
    }

    // 励志生认定申请表
    @PostMapping("/getNavInspirationalTables")
    @ResponseBody
    public Map<String, Object> getNavInspirationalTables (@RequestBody Map map) {
        ResponseData responseData = ResponseData.ok();
        String studentId = (String) map.get("studentId");
        List<Admitapply> responseDate = admitapplyService.getTableByStId(studentId);
        responseData.putDataValue("date", responseDate);
        return responseData.toMap();
    }

    // 国家助学金申请表
    @PostMapping("/getNavGrantTables")
    @ResponseBody
    public Map<String, Object> getNavGrantTables (@RequestBody Map map) {
        ResponseData responseData = ResponseData.ok();
        String studentId = (String) map.get("studentId");
        List<Stipend> responseDate = stipendService.getTableByStId(studentId);
        List<FamilyMember> members = familyMemberService.getMembersByStId(studentId);

        for (Stipend stipend : responseDate) {
            stipend.setFamilyMembers(members);
        }
        responseData.putDataValue("date", responseDate);
        return responseData.toMap();
    }

    // 励志奖学金申请表
    @PostMapping("/getNavInsScholarshipTables")
    @ResponseBody
    public Map<String, Object> getNavInsScholarshipTables (@RequestBody Map map) {
        String studentId = (String) map.get("studentId");
        List<Encouragement> responseDate = encouragementService.getTableByStId(studentId);
        List<Prize> prizes = prizeService.getPrizesByStId(studentId);
        for (Encouragement encouragement : responseDate) {
            encouragement.setPrizes(prizes);
        }
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("date", responseDate);
        return responseData.toMap();
    }

    // 国家奖学金申请表
    @PostMapping("/getNavScholarshipTables")
    @ResponseBody
    public Map<String, Object> getNavScholarshipTables (@RequestBody Map map) {
        String studentId = (String) map.get("studentId");
        List<Scholarship> responseDate = scholarshipService.getTableByStId(studentId);
        List<Prize> prizes = prizeService.getPrizesByStId(studentId);
        for (Scholarship scholarship : responseDate) {
            scholarship.setPrizes(prizes);
        }
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("date", responseDate);
        return responseData.toMap();
    }

    // 学费减免申请表
    @PostMapping("/getNavTuitionTables")
    @ResponseBody
    public Map<String, Object> getNavTuitionTables (@RequestBody Map map) {
        String studentId = (String) map.get("studentId");
        List<DiscountFee> responseDate = discountFeeService.getTableByStId(studentId);
        List<Award> awards = awardService.getAwardsByStId(studentId);
        for (DiscountFee discountFee : responseDate) {
            discountFee.setAwards(awards);
        }

        List<Help> helps = helpService.getHelpsByStId(studentId);
        for (DiscountFee discountFee : responseDate) {
            discountFee.setHelps(helps);
        }

        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("date", responseDate);
        return responseData.toMap();
    }

    /**
     *
     * 学生端删除数据路由
     *
     * */

    // 励志生申请表
    @PostMapping("/delNavInspirationTable")
    @ResponseBody
    public Map delNavInspirationTable(@RequestBody Admitapply table) {
        String message = admitapplyService.deleteTable(table);
        return getDelStuResponseMap(message);
    }

    // 家庭情况调查表
    @PostMapping("/delStNavFamilyTable")
    @ResponseBody
    public Map delStNavFamilyTable(@RequestBody Questionary table) {
        String message = questionaryService.deleteTable(table);
        return getDelStuResponseMap(message);
    }

    // 国家助学金
    @PostMapping("/delNavGrantTable")
    @ResponseBody
    public Map delNavGrantTable(@RequestBody Stipend table) {
        String message = stipendService.deleteTable(table);
        return getDelStuResponseMap(message);
    }

    // 励志奖学金
    @PostMapping("/delNavInsScholarshipTable")
    @ResponseBody
    public Map delNavInsScholarshipTable(@RequestBody Encouragement table) {
        String message = encouragementService.deleteTable(table);
        return getDelStuResponseMap(message);
    }

    // 国家奖学金
    @PostMapping("/delNavNationalScholarshipTable")
    @ResponseBody
    public Map delNavNationalScholarshipTable(@RequestBody Scholarship table) {
        String message = scholarshipService.deleteTable(table);
        return getDelStuResponseMap(message);
    }

    // 学费减免
    @PostMapping("/delNavTuitionTable")
    @ResponseBody
    public Map delNavTuitionTable(@RequestBody DiscountFee table) {
        String message = discountFeeService.deleteTable(table);
        return getDelStuResponseMap(message);
    }

    /**
     *
     * 学生端查看表单路由
     *
     * */

    // 家庭情况调查表
    @GetMapping("/stNavFamilyTableDetail")
    public String stNavFamilyTableDetail(String studentId, String tableYear, Model model) {
        log.info(studentId + tableYear);
        List<Questionary> questionaries = questionaryService.getTableByStId(studentId);
          Questionary table = null;
          for (Questionary questionary : questionaries) {
              if (tableYear.equals(questionary.getTableYear())) {
                  table = questionary;
                  break;
              }
          }
        List<FamilyMember> members = familyMemberService.getMembersByStId(studentId);
        User userInfo = userService.getUserInfoById(studentId);
        model.addAttribute("user", table);
        model.addAttribute("members", members);
        model.addAttribute("userInfo", userInfo);
        return "form/check_questionary_form";
    }

    // 励志生认定
    @GetMapping("/stNavInspirationTableDetail")
    public String stNavInspirationTableDetail(String studentId, String tableYear, Model model) {
        log.info(studentId + tableYear);
        List<Admitapply> admitapplies = admitapplyService.getTableByStId(studentId);
        Admitapply table = null;
        for (Admitapply admitapply : admitapplies) {
            if (tableYear.equals(admitapply.getTableYear())) {
                table = admitapply;
                break;
            }
        }
        User userInfo = userService.getUserInfoById(studentId);
        model.addAttribute("user", table);
        model.addAttribute("userInfo", userInfo);
        return "form/check_admit_apply_form";
    }

    // 国家助学金申请表
    @GetMapping("/stNavGrantTableDetail")
    public String stNavGrantTableDetail(String studentId, String tableYear, Model model) {
        log.info(studentId + tableYear);
        List<Stipend> stipends = stipendService.getTableByStId(studentId);
        Stipend table = null;
        for (Stipend stipend : stipends) {
            if (tableYear.equals(stipend.getTableYear())) {
                table = stipend;
                break;
            }
        }
        List<FamilyMember> members = familyMemberService.getMembersByStId(studentId);
        User userInfo = userService.getUserInfoById(studentId);
        model.addAttribute("user", table);
        model.addAttribute("members", members);
        model.addAttribute("userInfo", userInfo);
        return "form/check_stipend_form";
    }

    // 励志奖学金
    @GetMapping("/stNavInsScholarshipTableDetail")
    public String stNavInsScholarshipTableDetail(String studentId, String tableYear, Model model) {
        log.info(studentId + tableYear);
        List<Encouragement> encouragements = encouragementService.getTableByStId(studentId);
        Encouragement table = null;
        for (Encouragement encouragement : encouragements) {
            if (tableYear.equals(encouragement.getTableYear())) {
                table = encouragement;
                break;
            }
        }
        List<Prize> prizes = prizeService.getPrizesByStId(studentId);
        User userInfo = userService.getUserInfoById(studentId);
        model.addAttribute("user", table);
        model.addAttribute("prizes", prizes);
        model.addAttribute("userInfo", userInfo);
        return "form/check_encouragement_form";
    }

    // 国家奖学金
    @GetMapping("/stNavNationalScholarshipTableDetail")
    public String stNavNationalScholarshipTableDetail(String studentId, String tableYear, Model model) {
        log.info(studentId + tableYear);
        List<Scholarship> scholarships = scholarshipService.getTableByStId(studentId);
        Scholarship table = null;
        for (Scholarship scholarship : scholarships) {
            if (tableYear.equals(scholarship.getTableYear())) {
                table = scholarship;
                break;
            }
        }
        List<Prize> prizes = prizeService.getPrizesByStId(studentId);
        User userInfo = userService.getUserInfoById(studentId);
        model.addAttribute("user", table);
        model.addAttribute("prizes", prizes);
        model.addAttribute("userInfo", userInfo);
        return "form/check_scholarship_form";
    }

    // 学费减免表
    @GetMapping("/stNavTuitionTableDetail")
    public String stNavTuitionTableDetail(String studentId, String tableYear, Model model) {
        log.info(studentId + tableYear);
        List<DiscountFee> discountFees = discountFeeService.getTableByStId(studentId);
        DiscountFee table = null;
        for (DiscountFee discountFee : discountFees) {
            if (tableYear.equals(discountFee.getTableYear())) {
                table = discountFee;
                break;
            }
        }
        List<Help> helps = helpService.getHelpsByStId(studentId);
        List<Award> awards = awardService.getAwardsByStId(studentId);
        User userInfo = userService.getUserInfoById(studentId);
        model.addAttribute("user", table);
        model.addAttribute("helps", helps);
        model.addAttribute("awards", awards);
        model.addAttribute("userInfo", userInfo);
        return "form/check_discountfee_form";
    }

    // 励志生库
    @GetMapping("/stLibDetail")
    public String stLibDetail(String studentId, String tableYear, Model model) {
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
        return "form/check_encouragestu_info";
    }
}
