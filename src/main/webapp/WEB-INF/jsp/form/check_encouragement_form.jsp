<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>国家励志奖学金申请表</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body style="margin-left: 10%;margin-right: 10%;">
<center>
    <h1><b>国家励志奖学金申请表</b></h1>
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
        <caption>学习情况</caption>
        <thead>
        <tr>
            <th>成绩排名</th>
            <th>必修课门数</th>
            <th>必修课及格以上门数</th>
            <th>是否实行综合考评排名</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.grade}</td>
            <td>${user.courseNum}</td>
            <td>${user.passNum}</td>
            <td>${user.rank == 1 ? '是' : '否'}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <caption>大学期间主要获奖情况</caption>
    </table>
    <!-- 获奖励情况 -->
    <c:if test="${!empty prizes}">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>获奖日期</th>
                <th>奖项名称</th>
                <th>颁奖单位</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="prize" items="${prizes}">
                <tr>
                    <td>${prize.date}</td>
                    <td>${prize.priceName}</td>
                    <td>${prize.awardCeremony}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty prizes}">无获奖情况</c:if>

    <table class="table table-bordered table-striped">
        <caption>家庭情况</caption>
        <thead>
        <tr>
            <th>家庭户口</th>
            <th>收入来源</th>
            <th>家庭月总收入(元)</th>
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
