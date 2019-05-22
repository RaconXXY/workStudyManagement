<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta http_equiv="Content_Type" content="text/html; charset=utf_8"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>杭州师范大学家庭经济困难学生认定申请表</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body style="margin-left: 10%;margin-right: 10%;">
<center>
    <h1><b>家庭经济困难学生认定申请表</b></h1>
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
        <caption>个人基本介绍</caption>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>出生年月</th>
            <th>民族</th>
            <th>政治面貌</th>
            <th>籍贯</th>
            <th>联系电话</th>
            <th>继上年度连续申请</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${userInfo.name}</td>
            <td>${user.sex}</td>
            <td>${user.birthYear} - ${user.birthMonth}</td>
            <td>${user.nation}</td>
            <td>${user.politicalStatus}</td>
            <td>${user.birthPlace}</td>
            <td>${user.phone}</td>
            <td>${user.isContinue == 1 ? '是' : '否'}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <caption>在校有关情况</caption>
        <thead>
        <tr>
            <th>在校外租房</th>
            <th>参加勤工助学活动情况</th>
            <th>参加公益活动情况</th>
            <th>本学年获资助情况</th>
            <th>本学年已获资助金额(元)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.isRender == 1 ? '是' : '否'}</td>
            <td>${user.workAndStudy}</td>
            <td>${user.socialActivity}</td>
            <td>
                <input type="checkbox" value="国家励志奖学金" name="imburse" <c:if test="${user.finance.charAt(0).toString() == '1'}">checked</c:if> disabled="disabled">国家励志奖学金
                <input type="checkbox" value="国家助学金" name="imburse" <c:if test="${user.finance.charAt(1).toString() == '1'}">checked</c:if> disabled="disabled">国家助学金
                <input type="checkbox" value="山大助学金" name="imburse" <c:if test="${user.finance.charAt(2).toString() == '1'}">checked</c:if> disabled="disabled">山大助学金
                <input type="checkbox" value="社会助学金" name="imburse" <c:if test="${user.finance.charAt(3).toString() == '1'}">checked</c:if> disabled="disabled">社会助学金
                <input type="checkbox" value="临时困难补助" name="imburse" <c:if test="${user.finance.charAt(4).toString() == '1'}">checked</c:if> disabled="disabled">临时困难补助
                <input type="checkbox" value="减免学费" name="imburse" <c:if test="${user.finance.charAt(5).toString() == '1'}">checked</c:if> disabled="disabled">减免学费
                <input type="checkbox" value="其他" name="imburse" <c:if test="${user.finance.charAt(6).toString() == '1'}">checked</c:if> disabled="disabled">其他（请注明）：${user.otherFinance}
            </td>
            <td>${user.financeNumber}</td>
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
