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
    <title>学生勤工助学管理系统-修改密码</title>
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
        <h1><strong>修改密码</strong></h1>
        <form>

            <div class="ui-form-container">
                <div class="ui-form-title">工号（学号）：</div>
                <input type="text" class="ui-form id">
            </div>
            <div class="ui-form-container">
                <div class="ui-form-title">输入原密码：</div>
                <input type="password" class="ui-form pwd">
            </div>
            <div class="ui-form-container">
                <div class="ui-form-title">输入新密码：</div>
                <input type="password" class="ui-form npwd">
            </div>
            <div class="ui-form-container">
                <div class="ui-form-title">再次输入新密码：</div>
                <input type="password" class="ui-form check-pwd checkNpwd">
            </div>
            <input type="button" value="修改密码" class="btn btn-default submit-button">
        </form>
    </div>
</center>
<!-- script depart line -->

<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="/lib/bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/lib/bower_components/sweetalert2/dist/sweetalert2.js"></script>
<script type="text/javascript" src="/lib/jsSHA/sha512.js"></script>
<script type="text/javascript" src="/js/form/reset_password.js"></script>
</body>
</html>