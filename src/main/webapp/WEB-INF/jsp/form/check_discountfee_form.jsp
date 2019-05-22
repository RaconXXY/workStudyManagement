<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>学费减免申请表</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body style="margin-left: 10%;margin-right: 10%;">
<center>
    <h1><b>学费减免申请表</b></h1>
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
            <td>${userInfo.academy}</td>
            <td>${userInfo.major}</td>
            <td>${userInfo.className}</td>
            <td>${user.studentId}</td>
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
            <th>入学年月</th>
            <th>民族</th>
            <th>政治面貌</th>
            <th>联系电话</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${userInfo.name}</td>
            <td>${user.sex}</td>
            <td>${user.birthYear} - ${user.birthMonth}</td>
            <td>${user.studentId.toString().substring(0,4)} - 09</td>
            <td>${user.nation}</td>
            <td>${user.politicalStatus}</td>
            <td>${user.phone}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <caption>家庭经济情况</caption>
        <thead>
        <tr>
            <th>家庭户口</th>
            <th>收入来源</th>
            <th>家庭月总收入(元)</th>
            <th>家庭人口总数(人)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.residence == 0 ? '城镇' : '农村'}</td>
            <td>${user.incomeSource}</td>
            <td>${user.incomePerMonth}</td>
            <td>${user.peopleNumber}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <caption>本学年获得奖励和资助情况</caption>
        <thead>
        <tr>
            <th>是否申请助学贷款（含生源地贷款）</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.isLoan == 1 ? '是' : '否'}</td>
        </tr>
        </tbody>
    </table>
    <!-- 获奖励情况 -->
    <c:if test="${!empty awards}">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>奖励项目名称</th>
                <th>获奖金额</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="award" items="${awards}">
                <tr>
                    <td>${award.awardName}</td>
                    <td>${award.awardNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty awards}">无获奖情况</c:if>
    <!-- 资助情况 -->
    <c:if test="${!empty helps}">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>资助项目名称</th>
                <th>资助金额</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="help" items="${helps}">
                <tr>
                    <td>${help.helpName}</td>
                    <td>${help.helpNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty helps}">无资助情况</c:if>

    <table class="table table-bordered table-striped">
        <caption>其他</caption>
        <thead>
        <tr>
            <th>申请理由</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.reason}</td>
        </tr>
        </tbody>
    </table>

</center>

<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
