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
    <title>学生勤工助学管理系统-忘记密码</title>
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/sweetalert2/dist/sweetalert2.css"/>
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="/css/form/sign_up.css">

</head>
<body>
<center>
    <div class="ui-main">
        <br>
        <br>
        <h1><strong>忘记密码</strong></h1>
        <form>

            <div class="ui-form-container">
                <div class="ui-form-title">工号（学号）：</div>
                <input type="text" class="ui-form id">
            </div>
            <div class="ui-form-container">
                <div class="ui-form-title">电子邮箱：</div>
                <input type="email" class="ui-form e-mail">
            </div>
            <div class="ui-form-container">
                <div class="ui-form-title">联系电话：</div>
                <input type="tel" class="ui-form phone">
            </div>
            <%--<div class="ui-form-container">--%>
                <%--<div class="ui-form-title">所在学院：</div>--%>
                <%--<input type="text" class="ui-form">--%>
            <%--</div>--%>
            <%--<div class="ui-form-container" id="class-belonging">--%>
                <%--<div class="ui-form-title">专业：</div>--%>
                <%--<input type="text" class="ui-form">--%>
            <%--</div>--%>
            <%--<div class="ui-form-container">--%>
                <%--<div class="ui-form-title">班级：</div>--%>
                <%--<input type="text" class="ui-form">--%>
            <%--</div>--%>
            <div class="ui-form-container">
                <div class="ui-form-title">所在学院：</div>
                <select name="class-select" id="academy-select" class="ui-form">
                    <option value="none">请选择学院</option>
                </select>
            </div>
            <div class="ui-form-container" id="class-belonging">
                <div class="ui-form-title">专业：</div>
                <select name="major-select" id="major-select" class="ui-form-s">
                    <option value="none">请选择专业</option>
                </select>
                <div class="ui-form-title-s">班级：</div>
                <select name="class-select" id="class-select" class="ui-form-s">
                    <option value="none">请选择班级</option>
                </select>
            </div>
            <input type="button" value="重置密码" class="btn btn-default submit-button">
            <br><br>
        </form>
    </div>
</center>
<!-- script depart line -->

<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="/lib/bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/lib/bower_components/sweetalert2/dist/sweetalert2.js"></script>
<script type="text/javascript" src="/js/form/forget_password.js"></script>
</body>
</html>