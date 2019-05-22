<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>学生勤工助学管理系统-注册</title>
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="/css/form/sign_up.css">
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/sweetalert2/dist/sweetalert2.css"/>

</head>
<body>
<center>
    <div class="ui-main">
        <br>
        <br>
        <h1><strong>账号信息</strong></h1>
        <form>

            <div class="ui-form-container">
                <div class="ui-form-title">工号（学号）：</div>
                <input type="text" class="ui-form id" disabled value="${user.userId}">
            </div>
            <div class="ui-form-container">
                <div class="ui-form-title">姓名：</div>
                <input type="text" class="ui-form name" disabled value="${user.name}">
            </div>
            <div class="ui-form-container">
                <div class="ui-form-title">电子邮箱：</div>
                <input type="email" class="ui-form e-mail" disabled value="${user.email}">
            </div>
            <div class="ui-form-container">
                <div class="ui-form-title">联系电话：</div>
                <input type="tel" class="ui-form phone" disabled value="${user.phone}">
            </div>

            <div class="ui-form-container">
                <div class="ui-form-title">身份：</div>
                <c:if test="${user.type == 0}">学生</c:if>
                <c:if test="${user.type == 1}">教师</c:if>
            </div>

            <div class="ui-form-container">
                <div class="ui-form-title">所在学院：</div>
                <input type="tel" class="ui-form academy" disabled value="${user.academy}">
            </div>
            <div class="ui-form-container" id="class-belonging">
                <div class="ui-form-title">专业：</div>
                <input type="tel" class="ui-form major" disabled value="${user.major}">
                <div class="ui-form-title-s">班级：</div>
                <input type="tel" class="ui-form className" disabled value="${user.className}">
            </div>
            <%--<input type="button" value="确认修改" class="btn btn-default submit-button">--%>

        </form>
    </div>
</center>
<!-- script depart line -->

<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="/lib/bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/lib/bower_components/sweetalert2/dist/sweetalert2.js"></script>
<%--<script type="text/javascript" src="/js/form/account_manage.js"></script>--%>

</body>
</html>