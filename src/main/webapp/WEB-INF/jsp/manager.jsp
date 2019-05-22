<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>Manager</title>
    <link rel="stylesheet" href="/lib/bower_components/normalize-css/normalize.css">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/manager/manager.css">
    <link href="/lib/bootstrap.css" rel="stylesheet">
    <link href="/lib/bootstrap.min.css" rel="stylesheet">
    <link href="/lib/bootstrap-switch/bootstrap-switch.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/sweetalert2/dist/sweetalert2.css"/>
</head>
<body>
<div class="header">
    <img src="/img/banner2.jpg" class="bgpic">
    <div class="web-name">
        <img src="/img/LOGO.png" class="logo">
        <div class="text">
            <span class="title-ch">学生助学管理系统</span><br>
            <span class="title-en">IMBURSE MANAGEMENT SYSTEM</span>
        </div>
    </div>
    <div class="login"></div>
    <div class="user">
        <ul>
            <li><a class="username">你好！</a></li>
            <li><a href="/resetpwd" class="change-password">修改密码</a></li>
            <li><a href="/index" class="exit">退出</a></li>
        </ul>
    </div>
</div>
<div class="wrap">
    <div class="sidebar">
        <ul class="nav-list">
            <li class="nav-item nav-item-first selected" id="navGuide">管理导航</li>

            <li class="nav-item" id="navTimeset">时间管理</li>
            <li class="nav-item nav-item-first selected">管理员评定>></li>
            <li class="nav-item" id="navDifficultStudent">励志生认定</li>
            <li class="nav-item" id="navNationalGrant">国家助学金</li>
            <li class="nav-item" id="navInspirationalScholarship">国家励志奖学金</li>
            <li class="nav-item" id="navNationalScholarship">国家奖学金</li>
            <li class="nav-item" id="navTuitionWaive">学费减免</li>

            <li class="nav-item nav-item-first selected">汇总与管理>></li>
            <li class="nav-item" id="navDifficultStudentHz">励志生认定申请汇总</li>
            <li class="nav-item" id="navNationalGrantHz">国家助学金申请汇总</li>
            <li class="nav-item" id="navInspirationalScholarshipHz">国家励志奖学金申请汇总</li>
            <li class="nav-item" id="navNationalScholarshipHz">国家奖学金申请汇总</li>
            <li class="nav-item" id="navTuitionWaiveHz">学费减免申请汇总</li>
            <li class="nav-item" id="navDifficultStudentGl">励志生信息管理</li>
            <li class="nav-item" id="navDifficultStudentKu">励志生库</li>

            <li class="nav-item" id="navAccountManage">帐户管理</li>
        </ul>
    </div>
    <div class="form">
        <div class="location">
            <span id="form-location">所在位置：管理导航</span>
        </div>
        <div id="content">

        </div>
        <div class="page-travel" onselectstart="return false;">
            <ul class="pages">
                <li class="page"><<</li>
                <li class="page selected">1</li>
                <li class="page">>></li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<script src="/lib/bootstrap.min.js"></script>
<script src="/lib/bootstrap-switch/bootstrap-switch.js"></script>
<script type="text/javascript" src="/js/manager/manager.js"></script>
<script type="text/javascript" src="/lib/bower_components/sweetalert2/dist/sweetalert2.js"></script>
</body>
</html>
