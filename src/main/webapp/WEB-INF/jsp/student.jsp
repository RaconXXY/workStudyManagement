<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>Student</title>
    <link rel="stylesheet" href="/lib/bower_components/normalize-css/normalize.css">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/student/student.css">
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
            <li class="nav-item nav-item-first selected" id="navGuide">申报导航</li>
            <li class="nav-item nav-item-separate unbind-click">励志生认定 ></li>
            <li class="nav-item" id="navFamilySituation">家庭情况调查</li>
            <li class="nav-item" id="navInspirationalStudent">励志生认定</li>
            <li class="nav-item nav-item-separate unbind-click">资助中心 ></li>
            <li class="nav-item" id="navNationalGrant">国家助学金</li>
            <li class="nav-item" id="navInspirationalScholarship">励志奖学金</li>
            <li class="nav-item" id="navNationalScholarship">国家奖学金</li>
            <li class="nav-item" id="navTuitionWaive">学费减免</li>
        </ul>
    </div>
    <div class="form">
        <div class="location">
            <span id="form-location">所在位置：申报导航</span>
        </div>
        <div id="content">
            <%-- js中添加 --%>
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
<script type="text/javascript" src="/js/student/student.js"></script>
<script type="text/javascript" src="/lib/bower_components/sweetalert2/dist/sweetalert2.js"></script>
</body>
</html>
