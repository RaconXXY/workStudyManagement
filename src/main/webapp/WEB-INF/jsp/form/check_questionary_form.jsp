<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>家庭情况调查表</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body style="margin-left: 8%;margin-right: 8%;">
<center>
    <h1><b>家庭情况调查表</b></h1>
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
            <th>联系电话</th>
            <th>身份证号</th>
            <th>家庭地址</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${userInfo.name}</td>
            <td>${user.sex}</td>
            <td>${user.birthYear} - ${user.birthMonth}</td>
            <td>${user.nation}</td>
            <td>${user.phone}</td>
            <td>${user.identityCardId}</td>
            <td>${user.address}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>入学前户口</th>
            <th>是否孤儿</th>
            <th>是否残疾</th>
            <th>是否单亲</th>
            <th>烈士或优抚对象子女</th>
            <th>农村建档立卡贫困户或城市低保户</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.residence == 0 ? '城市' : '农村'}</td>
            <td>${user.isOrphan == 1 ? '是' : '否'}</td>
            <td>${user.isDeformity == 1 ? '是' : '否'}</td>
            <td>${user.isSingleFamily == 1 ? '是' : '否'}</td>
            <td>${user.isMartyr == 1 ? '是' : '否'}</td>
            <td> ${user.isDiffFamily == 1 ? '是（需提供相关证明材料）' : '否'}</td>
        </tr>
        </tbody>
    </table>
    <!-- 家庭成员情况 -->
    <table class="table table-bordered table-striped">
        <caption>家庭成员情况</caption>
    </table>
    <c:if test="${!empty members}">
        <table class="table table-bordered table-striped">
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
        </table>
    </c:if>
    <!-- 经济情况 -->
    <table class="table table-bordered table-striped">
        <caption>本年度家庭成员收入情况</caption>
        <thead>
        <tr>
            <th>家庭人口(人)</th>
            <th>家庭劳动力(人)</th>
            <th>家庭年收入总计(元)</th>
            <th>家庭成员年工资合计(元)</th>
            <th>家庭人均年收入(元)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.peopleNumber}</td>
            <td>${user.workPeople}</td>
            <td>${user.totalIncomePerYear}</td>
            <td>${user.salaryPerYear}</td>
            <td> ${user.yearIncomePerPerson}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>家庭个体经营年总收入(元)</th>
            <th>家庭农业年净收入(元)</th>
            <th>家庭副业年净收入(元)</th>
            <th>资产年收入(元)</th>
            <th>家庭其他收入(元)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.indiOperPerYear}</td>
            <td>${user.agricultureIncome}</td>
            <td>${user.sidelineIncome}</td>
            <td>${user.assetsIncome}</td>
            <td>${user.otherIncome}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <caption>本年度家庭成员年大笔支出情况</caption>
        <thead>
        <tr>
            <th>家庭成员大病支出(元)</th>
            <th>家庭成员非义务制教育支出(含本人)学费</th>
            <th>家庭成员非义务制教育支出(含本人)住宿费</th>
            <th>家庭遭受自然灾害、农作物或家庭财产受损严重(元)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.illnessFee}</td>
            <td>${user.tuition}</td>
            <td>${user.accommodation}</td>
            <td>${user.naturalLoss}</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>其他(详细说明)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.other}</td>
        </tr>
        </tbody>
    </table>

</center>

<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
