package com.workstudy.ssm.interceptor;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/7/31 0031
 * Time: 8:46
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.workstudy.ssm.model.TimeControl;
import com.workstudy.ssm.model.User;
import com.workstudy.ssm.service.TimeControlService;
import com.workstudy.ssm.utils.CookieUtil;
import com.workstudy.ssm.utils.JWT;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.workstudy.ssm.utils.ResponseData;

public class TokenInterceptor implements HandlerInterceptor {

    private Logger log = Logger.getLogger(TokenInterceptor.class);
    private static URLStateMap reqMap;
    private static URLStateMap timeReqMap;
    private static int interceptorCount = 0;

    private boolean isStudentQuestionaryTime;
    private boolean isStudentAdmitapplyTime;
    private boolean isStudentStipendTime;
    private boolean isStudentEncouragementTime;
    private boolean isStudentScholarshipTime;
    private boolean isStudentDiscountfeeTime;

    private boolean isTeacherAdmitapplyTime;
    private boolean isTeacherStipendTime;
    private boolean isTeacherEncouragementTime;
    private boolean isTeacherScholarshipTime;
    private boolean isTeacherDiscountfeeTime;
    @Resource
    private TimeControlService timeControlService;

    static {
        initReqMap();
    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView model) throws Exception {
    }

    //拦截每个请求
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        setReqState(); //设置可访问状态
        interceptorCount++;
        log.info("-----------------" + interceptorCount + "-----------------------");
        log.info("TokenInterceptor: " + request.getRequestURL());
        log.info("URI: " + request.getRequestURI());

        int authType = reqMap.get(request.getRequestURI());
        log.info("authType: " + authType);

        String token = null;
        String userId = null;

        response.setCharacterEncoding("utf-8");
        ResponseData responseData = ResponseData.ok();

        // 先获取session里面的token
        String sessiontoken = (String) request.getSession().getAttribute("token");
        String sessionuserId = (String) request.getSession().getAttribute("userId");
        log.info("session");
        log.info(sessiontoken);
        log.info(sessionuserId);

        // 如果存在就使用session里面的token
        if (sessiontoken != null && sessionuserId != null) {
            token = sessiontoken;
            userId = sessionuserId;
        } else { //如果不存在就获取cookie里面的token
            Cookie tokenCookie = CookieUtil.getCookieByName(request, "token");
            Cookie userIdCookie = CookieUtil.getCookieByName(request, "userId");

            // 如果存在就是用
            if (null != tokenCookie && null != userIdCookie) {
                log.info("cookie");
                log.info(tokenCookie.getValue());
                log.info(userIdCookie.getValue());

                token = tokenCookie.getValue();
                userId = userIdCookie.getValue();
            } else { //如果还是不存在就说明没登录 直接返回
                try {
                    response.sendRedirect("/403.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
        }

        boolean state = isTime(request.getRequestURI());
        if (!state) {
            responseData = ResponseData.customerError("现在不是操作的时间！");
            responseMessage(request, response, responseData);
            return false;
        }

        User user = JWT.unsign(token, User.class);
        //解密token后的loginId与用户传来的loginId不一致，一般都是token过期
        if (null != userId && null != user
                && userId.equals(user.getUserId())
                && (authType == -1 || user.getType() == authType)) {

            return true;
        } else {
            try {
                response.sendRedirect("/403.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletRequest request, HttpServletResponse response, ResponseData responseData) {
        String uri = request.getRequestURI();
        switch (uri) {
            // 获取新页面的请求则重定向，ajax的请求则返回错误信息
            case "/questionary":
            case "/admitapply":
            case "/stipend":
            case "/encouragement":
            case "/scholarship":
            case "/discountfee": {
                try {
                    response.sendRedirect("/403.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            default: {
                response.setContentType("application/json; charset=utf-8");
                String json = JSONObject.toJSONString(responseData);
                try (PrintWriter out = response.getWriter()) {
                    out.print(json);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void initReqMap() {
        // 访问请求权限控制 用于区分不同的用户
        reqMap = new URLStateMap();
        // 0学生 1教师 2管理员
        reqMap.put("/student", 0);
        reqMap.put("/encouragement", 0);
        reqMap.put("/questionary", 0);
        reqMap.put("/scholarship", 0);
        reqMap.put("/stipend", 0);
        reqMap.put("/discountfee", 0);
        reqMap.put("/admitapply", 0);

        reqMap.put("/teacher", 1);

        reqMap.put("/admin", 2);
        reqMap.put("/discountfeetablesaveExcel", 2);
        reqMap.put("/encouragementtablesaveExcel", 2);
        reqMap.put("/scholarshiptablesaveExcel", 2);
        reqMap.put("/stipendtablesaveExcel", 2);
        reqMap.put("/studentlibtablesaveExcel", 2);
        reqMap.put("/stuLibOperate", 2);
        reqMap.put("/userDetail", 2);

        // 发送请求时的权限控制 用于区分当前时段是否可以执行相应请求（填表，修改什么的）
        timeReqMap = new URLStateMap();
        // 学生
        // 1 家庭情况调查
        // 2 励志生认定
        // 3 国家助学金
        // 4 励志奖学金
        // 5 国家奖学金
        // 6 学费减免
        // 教师
        // 7 励志生认定
        // 8 国家助学金评定
        // 9 励志奖学金评定
        // 10 国家奖学金评定
        // 11 学费减免评定
        // 学生获取填表的请求
        timeReqMap.put("/questionary", 1);
        timeReqMap.put("/admitapply", 2);
        timeReqMap.put("/stipend", 3);
        timeReqMap.put("/encouragement", 4);
        timeReqMap.put("/scholarship", 5);
        timeReqMap.put("/discountfee", 6);

        // 学生表单提交的请求
        timeReqMap.put("/questionarytable", 1);
        timeReqMap.put("/admitapplytable", 2);
        timeReqMap.put("/stipendtable", 3);
        timeReqMap.put("/encouragementtable", 4);
        timeReqMap.put("/scholarshiptable", 5);
        timeReqMap.put("/discountfeetable", 6);

        // 学生表单删除的请求
        timeReqMap.put("/delStNavFamilyTable", 1);
        timeReqMap.put("/delNavInspirationTable", 2);
        timeReqMap.put("/delNavGrantTable", 3);
        timeReqMap.put("/delNavInsScholarshipTable", 4);
        timeReqMap.put("/delNavNationalScholarshipTable", 5);
        timeReqMap.put("/delNavTuitionTable", 6);

        // 教师信息修改的请求
        timeReqMap.put("/changeTeacherAdmitApplySt", 7);
        timeReqMap.put("/changeTeacherStipendSt", 8);
        timeReqMap.put("/changeTeacherEncouragementSt", 9);
        timeReqMap.put("/changeTeacherScholarshipSt", 10);
        timeReqMap.put("/changeTeacherDiscountFeeSt", 11);
    }

    private void setReqState() {
        TimeControl timeControl = timeControlService.getTime();
        // 设置登录的状态
        this.isStudentQuestionaryTime = timeControl.getQuestionarySt() == 1;
        this.isStudentAdmitapplyTime = timeControl.getAdmitApplySt() == 1;
        this.isStudentStipendTime = timeControl.getStipendSt() == 1;
        this.isStudentEncouragementTime = timeControl.getEncouragementSt() == 1;
        this.isStudentScholarshipTime = timeControl.getScholarshipSt() == 1;
        this.isStudentDiscountfeeTime = timeControl.getDiscountFeeSt() == 1;

        this.isTeacherAdmitapplyTime = timeControl.getAdmitApplyTeacher() == 1;
        this.isTeacherStipendTime = timeControl.getStipendTeacher() == 1;
        this.isTeacherEncouragementTime = timeControl.getEncouragementTeacher() == 1;
        this.isTeacherScholarshipTime = timeControl.getScholarshipTeacher() == 1;
        this.isTeacherDiscountfeeTime = timeControl.getDiscountFeeTeacher() == 1;
//        this.isStudentQuestionaryTime = true;
//        this.isStudentAdmitapplyTime = true;
//        this.isStudentStipendTime = true;
//        this.isStudentEncouragementTime = true;
//        this.isStudentScholarshipTime = true;
//        this.isStudentDiscountfeeTime = true;
//
//        this.isTeacherAdmitapplyTime = true;
//        this.isTeacherStipendTime = true;
//        this.isTeacherEncouragementTime = true;
//        this.isTeacherScholarshipTime = true;
//        this.isTeacherDiscountfeeTime = true;
    }


    private boolean isTime(String url) {
        int state = timeReqMap.get(url);
        switch (state) {
            // 学生
            case 1:
                return isStudentQuestionaryTime;
            case 2:
                return isStudentAdmitapplyTime;
            case 3:
                return isStudentStipendTime;
            case 4:
                return isStudentEncouragementTime;
            case 5:
                return isStudentScholarshipTime;
            case 6:
                return isStudentDiscountfeeTime;

            //教师
            case 7:
                return isTeacherAdmitapplyTime;
            case 8:
                return isTeacherStipendTime;
            case 9:
                return isTeacherEncouragementTime;
            case 10:
                return isTeacherScholarshipTime;
            case 11:
                return isTeacherDiscountfeeTime;
            default: // -1 不在map里面即放行
                return true;
        }
    }

    // 空指针安全
    // 约定value必须>=0 所以-1即为null
    private static class URLStateMap extends HashMap<String, Integer> {
        @Override
        public Integer get(Object key) {
            Object obj = super.get(key);
            return obj == null ? -1 : (int) obj;
        }
    }
}
