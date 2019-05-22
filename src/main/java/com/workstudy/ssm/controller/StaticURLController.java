package com.workstudy.ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StaticURLController {

    private Logger log = Logger.getLogger(StaticURLController.class);

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/student")
    public String student() {
        return "student";
    }

    @GetMapping("/teacher")
    public String teacher() {
        return "teacher";
    }

    @GetMapping("/admin")
    public String manger() {
        return "manager";
    }

    @GetMapping("/register")
    public String register() {
        return "form/sign_up";
    }

    @GetMapping("/forgetPwd")
    public String forgetPwd() {
        return "form/forget_password";
    }

    @GetMapping("/resetpwd")
    public String reStpwd() {
        return "form/reset_password";
    }

    @GetMapping("/admitapply")
    public String admitApply() {
        return "form/admit_apply_form";
    }

    @GetMapping("/encouragement")
    public String encouragement() {
        return "form/encouragement_form";
    }

    @GetMapping("/questionary")
    public String questionary() {
        return "form/questionary_form";
    }

    @GetMapping("/scholarship")
    public String scholarship() {
        return "form/scholarship_form";
    }

    @GetMapping("/stipend")
    public String stipend() {
        return "form/stipend_form";
    }

    @GetMapping("/discountfee")
    public String discountfree() {
        return "form/discountfee_form";
    }

    @GetMapping("/encourageinfo")
    public String encourageinfo() {
        return "form/encouragestu_info";
    }

    @GetMapping("/accountmanage")
    public String accountmanage() {
        return "form/account_manage";
    }


    @GetMapping("/saveWordTest")
    public String saveWord() {
        return "saveWordTest";
    }

    @GetMapping("/exportExcelTest")
    public String exportExcel() {
        return "exportExcelTest";
    }

    @GetMapping("/sha512")
    public String sha256() {
        return "sha512";
    }
}
