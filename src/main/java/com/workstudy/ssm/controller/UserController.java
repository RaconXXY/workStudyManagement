package com.workstudy.ssm.controller;

import com.workstudy.ssm.dao.UserDao;
import com.workstudy.ssm.model.User;
import com.workstudy.ssm.service.UserService;
import com.workstudy.ssm.utils.JWT;
import com.workstudy.ssm.utils.ResponseData;
import com.workstudy.ssm.utils.CookieUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alander on 2017/7/30.
 */

@Controller
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Map login(@RequestBody Map map, HttpSession session, HttpServletResponse response, HttpSession httpSession) {
        log.info("得到前端数据");
        //获取验证码
        String ValidateCode = (String) map.get("ValidateCode");
        String validateCode = (String) session.getAttribute("validateCode");
        log.info(ValidateCode);
        log.info(validateCode);

        //初始化type的string和int的映射
        String[] intType = {"student", "teacher", "manager"};
        Map<String, Integer> typeInt = new HashMap<>();
        typeInt.put("student", 0);
        typeInt.put("teacher", 1);
        typeInt.put("manager", 2);

        ResponseData resdata = ResponseData.ok();
        //验证码正确才进行下一步
        if (validateCode.equals(ValidateCode)) {

            User user = new User();
            user.setUserId((String) map.get("accountId"));
            user.setPassword((String) map.get("password"));
            user.setType((Integer) map.get("type"));
            log.info(user);

            Map<String, Object> checkLoginRes = userService.checkLogin(user);
            if ((Boolean) checkLoginRes.get("isLogin")) {
                log.info("登陆成功！");
                //一天有效期
                String token = JWT.sign(user, 60L * 60L * 24L);
                User unUser = JWT.unsign(token, User.class);
                log.info(unUser);

                String userId = user.getUserId();
                //set cookie
                CookieUtil.setTokenCookie(response, token, userId, 60 * 60 * 24);
                //set session 保证一次已经登录情况下的操作不会因为超时而突然登出。。。
                httpSession.setAttribute("token", token);
                httpSession.setAttribute("userId", userId);

                resdata.putDataValue("token", token);
                resdata.putDataValue("loginId", userId);
                resdata.putDataValue("user", checkLoginRes.get("user"));
            } else {
                log.info("登陆失败!");
                resdata = ResponseData.customerError("登陆失败!");
            }
        } else {
            log.info("验证码错误!");
            resdata = ResponseData.customerError("验证码错误!");
        }

        return resdata.toMap();
    }

    @PostMapping("/register")
    @ResponseBody
    public Map register(@RequestBody Map map) {
        for (Object key : map.keySet()) {
            log.info(key);
            log.info(map.get(key));
        }
        User user = new User();
        user.setUserId((String) map.get("userId"));
        user.setName((String) map.get("name"));
        user.setPassword((String) map.get("password"));
        user.setAcademy((String) map.get("academy"));
        user.setMajor((String) map.get("major"));
        user.setClassName((String) map.get("class"));
        user.setEmail((String) map.get("email"));
        user.setPhone((String) map.get("phone"));
        user.setType((Integer) map.get("type"));

        ResponseData resdata = ResponseData.ok();
        String message = userService.createUser(user);
        if (!message.equals("注册成功！")) {
            resdata = ResponseData.customerError();
        }
        resdata.putDataValue("user", user);
        resdata.putDataValue("result", message);
        return resdata.toMap();
    }

    @PostMapping("/logout")
    @ResponseBody
    public Map logout(HttpSession httpSession) {

        httpSession.removeAttribute("token");
        httpSession.removeAttribute("userId");

        ResponseData resdata = ResponseData.ok();
        return resdata.toMap();
    }

    @PostMapping("/forgetPwd")
    @ResponseBody
    public Map forgetPwd(HttpSession httpSession, @RequestBody User user) {
        Map<String, Object> responseMap = new HashMap<>();
        String userId = user.getUserId();
        User dbuser = userService.getUserInfoById(userId);

        if (dbuser == null||dbuser.getType()!=user.getType()) {
            return ResponseData.customerError("用户不存在!").toMap();
        }
        if (!dbuser.getEmail().equals(user.getEmail())) {
            return ResponseData.customerError("邮箱错误!").toMap();
        }
        if (!dbuser.getPhone().equals(user.getPhone())) {
            return ResponseData.customerError("联系电话错误!").toMap();
        }
        // 那一串sha512的明文为123456
        String message = userService.resetPwdById(userId, "ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413");
        if (message.equals("修改成功！")) {
            return ResponseData.ok("修改成功!").toMap();
        } else {
            return ResponseData.serverInternalError("服务器错误，请稍后再试!").toMap();
        }
    }

    @PostMapping("/resetpwd")
    @ResponseBody
    public Map resetpwd(HttpSession httpSession, @RequestBody Map map) {
        String userId = (String) map.get("userId");
        String oldpwd = (String) map.get("oldpwd");
        String newpwd = (String) map.get("newpwd");
        ResponseData resdata = userService.resetPwd(userId, oldpwd, newpwd);
        return resdata.toMap();
    }
}
