<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>励志生信息</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body style="margin-left: 10%;margin-right: 10%;">
<center>
    <h1><b>励志生信息</b></h1>
    <br>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>学校</th>
            <th>院系</th>
            <th>专业</th>
            <th>班级</th>
            <th>学号</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>杭州师范大学</td>
            <td>${user.academy}</td>
            <td>${user.major}</td>
            <td>${user.className}</td>
            <td>${user.userId}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <caption>个人基本情况</caption>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>出生年月</th>
            <th>联系电话</th>
            <th>身份证号</th>
            <th>生源地</th>
            <th>是否特困</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.name}</td>
            <td>${questionary.sex}</td>
            <td>${questionary.birthYear} - ${questionary.birthMonth}</td>
            <td>${user.phone}</td>
            <td>${questionary.identityCardId}</td>
            <td>${questionary.address}</td>
            <td>
                <c:if test="${isDiff == 3}">
                    是
                </c:if>
                <c:if test="${isDiff != 3}">
                    否
                </c:if>
            </td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>家庭情况简介</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${reason}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <caption>其他信息</caption>
        <thead>
        <tr>
            <th>本年度是否申请国家助学贷款</th>
            <th>是否有勤工助学岗位</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <c:if test="${studentLib.isLoan == 1}">是</c:if>
                <c:if test="${studentLib.isLoan != 1}">否</c:if>
            </td>
            <td>
                <c:if test="${studentLib.isWorkAndStudy == 1}">是</c:if>
                <c:if test="${studentLib.isWorkAndStudy != 1}">否</c:if>
            </td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>本年度获得奖励情况</th>
            <th>本年度获得奖励总数</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${studentLib.awardsName}</td>
            <td>${studentLib.awardsNumber}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>本年度获得资助情况</th>
            <th>本年度获得资助总额</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${studentLib.helpsName}</td>
            <td>${studentLib.helpsNumber}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${studentLib.other}</td>
        </tr>
        </tbody>
    </table>

</center>

<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
