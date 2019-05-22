<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>国家助学金申请表</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body style="margin-left: 10%;margin-right: 10%;">
<center>
    <h1><b>国家助学金申请表</b></h1>
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
        <caption>本人情况</caption>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>出生年月</th>
            <th>民族</th>
            <th>入学时间</th>
            <th>政治面貌</th>
            <th>联系电话</th>
            <th>身份证号</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${userInfo.name}</td>
            <td>${user.sex}</td>
            <td>${user.birthYear} - ${user.birthMonth}</td>
            <td>${user.nation}</td>
            <td>${user.studentId.toString().substring(0,4)} - 09</td>
            <td>${user.politicalStatus}</td>
            <td>${user.phone}</td>
            <td>${user.identityCardId}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <caption>家庭经济情况</caption>
        <thead>
        <tr>
            <th>户口</th>
            <th>收入来源</th>
            <th>家庭总收入(元)</th>
            <th>家庭人口总数(人)</th>
            <th>家庭住址</th>
            <th>邮政编码</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.residence == 0 ? '城镇' : '农村'}</td>
            <td>${user.incomeSource}</td>
            <td>${user.incomePerMonth}</td>
            <td>${user.peopleNumber}</td>
            <td>${user.address}</td>
            <td>${user.postcode}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <caption>家庭成员情况</caption>
        <c:if test="${!empty members}">
            <thead>
            <tr>
                <th>姓名</th>
                <th>年龄</th>
                <th>称谓</th>
                <th>工作(学习)单位</th>
                <th>健康状况</th>
                <th>目前在学状况</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td>${member.name}</td>
                    <td>${member.age}</td>
                    <td>${member.appellation}</td>
                    <td>${member.workCeremony}</td>
                    <td>${member.health == 0 ? '大病/重残' : member.health == 1 ? '小病/轻残' : '健康'}</td>
                    <td>
                        <c:choose>
                            <c:when test="${member.health == 0}">
                                未在学
                            </c:when>
                            <c:when test="${member.health == 1}">
                                小学
                            </c:when>
                            <c:when test="${member.health == 2}">
                                初中
                            </c:when>
                            <c:when test="${member.health == 3}">
                                高中
                            </c:when>
                            <c:otherwise>
                                大学（含研究生）
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>
    </table>
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
