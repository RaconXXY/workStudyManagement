<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>励志生信息</title>
    <link rel="stylesheet" type="text/css" href="lib/flatpickr/flatpickr.css">
    <link rel="stylesheet" href="/css/form/form.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/sweetalert2/dist/sweetalert2.css"/>
</head>

<body>
<center>
    <div class="encouragement_form" style="width:750px;">
        <div class="horizonbar" style="text-align:center;margin-bottom:20px;font-family:'宋体';font-size:20px">
            励志生信息
        </div>
        <div class="form_top">
            <form>
                <table>
                    <tr id="top1">
                        <td id="stipend_school">
                            学校：
                            <input type="text" name="stipend_school" class="stipend_school" disabled value="杭州师范大学"/>
                        </td>
                        <td id="stipend_academic">
                            院系：
                            <input type="text" name="stipend_school" class="stipend_school" disabled value="${user.academy}"/>
                        </td>
                    <tr id="top2">
                        <td id="stipend_profession">
                            专业：
                            <input type="text" name="stipend_school" class="stipend_school" disabled value="${user.major}"/>
                        </td>
                        <td id="stipend_class">
                            班级：
                            <input type="text" name="stipend_school" class="stipend_school" disabled value="${user.className}"/>
                        </td>
                </table>
            </form>
        </div>
        <div class="horizonbar">基本情况</div>
        <div class="form_main01 form_offset">
            <form>
                <table>
                    <tr id="stipend_name">
                        <td class="table_left">姓名：</td>
                        <td><input type="text" name="stipend_name" class="stipend_name" disabled value="${user.name}"/></td>
                    </tr>
                    <tr id="stipend_sex">
                        <td class="table_left">性别：</td>
                        <td class="table_right">
                            <input type="text" name="stipend_name" class="stipend_name" disabled value="${questionary.sex}"/>
                        </td>
                    </tr>
                    <tr id="stipend_birthday">
                        <td class="table_left">出生年月：</td>
                        <td>
                            <input type="text" class="book_text" disabled value="${questionary.birthYear}-${questionary.birthMonth}">
                        </td>
                    </tr>
                    <tr id="stipend_number">
                        <td class="table_left">学号：</td>
                        <td><input type="text" name="stipend_number" class="stipend_number" disabled value="${user.userId}"/></td>
                    </tr>
                    <tr id="stipend_tele">
                        <td class="table_left">联系电话：</td>
                        <td>
                            <input type="text" name="stipend_tele" class="stipend_tele" disabled value="${user.phone}"/>
                            <img src="/img/form/star.png" class="star"><span class="point">请输入手机长号</span>
                        </td>      
                    </tr>
                    <tr id="stipend_identity">
                        <td class="table_left">身份证号：</td>
                        <td>
                            <input type="text" name="stipend_identity" class="stipend_identity" disabled value="${questionary.identityCardId}"/>
                            <img src="/img/form/star.png" class="star"><span class="point">若最后一位为字母，需大写</span>
                        </td>
                    </tr>
                    <tr id="stipend_birthplace">
                        <td class="table_left">生源地：</td>
                        <td>
                            <input type="text" name="stipend_birthplace" class="stipend_birthplace"  disabled value="${questionary.address}"/>
                        </td>
                    </tr>
                    <tr id="stipend_isSpeDifficult">
                        <td class="table_left">是否特困：</td>
                        <td>
                            <c:if test="${isDiff == 3}">
                                是
                            </c:if>
                            <c:if test="${isDiff != 3}">
                                否
                            </c:if>
                        </td>
                    </tr>
                    <tr id="stipend_familyIntro">
                        <td class="table_left" valign="top">家庭情况简介：</td>
                        <td>
                            <textarea name="stipend_familyIntro" class="stipend_familyIntro" cols="50" rows="5" disabled>${reason}</textarea>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="horizonbar">其他信息</div>
        <div class="form_main02 form_offset">
            <form>
                <table>
                    <tr id="stipend_hasApply">
                        <td class="table_left">本年度是否申请国家助学贷款：</td>
                        <td>
                            <label><input type="radio" value="1" name="stipend_hasApply" <c:if test="${studentLib.isLoan == 1}">checked</c:if>>是</label>
                            <label><input type="radio" value="0" name="stipend_hasApply" <c:if test="${studentLib.isLoan == 0}">checked</c:if>>否</label>
                        </td>
                    </tr>
                    <tr id="stipend_hasJob">
                        <td class="table_left">是否有勤工助学岗位：</td>
                        <td>
                            <label><input type="radio" value="1" name="stipend_hasJob" <c:if test="${studentLib.isWorkAndStudy == 1}">checked</c:if>>是</label>
                            <label><input type="radio" value="0" name="stipend_hasJob" <c:if test="${studentLib.isWorkAndStudy == 0}">checked</c:if>>否</label>
                        </td>
                    </tr>
                    <tr id="stipend_rewardSituation">
                        <td class="table_left">本年度获得奖励情况：</td>
                        <td>
                            <textarea name="stipend_rewardSituation" class="stipend_rewardSituation" cols="50" rows="5">${studentLib.awardsName}</textarea>
                        </td>
                    </tr>
                    <tr id="stipend_rewardNumber">
                        <td class="table_left">本年度获得奖励总数：</td>
                        <td>
                            <input type="text" name="stipend_rewardNumber" class="stipend_rewardNumber" value="${studentLib.awardsNumber}"/>
                        </td>
                    </tr>
                    <tr id="stipend_supprotSituation">
                        <td class="table_left">本年度获得资助情况：</td>
                        <td>
                            <textarea name="stipend_supprotSituation" class="stipend_supprotSituation" cols="50" rows="5">${studentLib.helpsName}</textarea>
                        </td>
                    </tr>
                    <tr id="stipend_supprotNumber">
                        <td class="table_left">本年度获得资助总额：</td>
                        <td>
                            <input type="text" name="stipend_supprotNumber" class="stipend_supprotNumber" value="${studentLib.helpsNumber}"/>
                        </td>
                    </tr>
                    <tr id="stipend_remark">
                        <td class="table_left">备注：</td>
                        <td>
                            <textarea name="stipend_remark" class="stipend_remark" cols="50" rows="3">${studentLib.other}</textarea>
                        </td>
                    </tr>                    
                </table>
            </form>
        </div>
       
    </div>
    <form>
        <input type="button" name="submit" class="submit" value="保存确认修改"/><br/><br/>
        <!-- <img src="/img/form/star.png" class="star"><span class="point">导出后请仔细检查信息是否无误，如有错误返回重新编辑之后导出</span> -->
    </form>
</center>

<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<%--<script type="text/javascript" src="/js/form/date.js"></script>--%>
<script src="/lib/flatpickr/flatpickr.js"></script>
<script type="text/javascript" src="/lib/bower_components/sweetalert2/dist/sweetalert2.js"></script>
<script>
    $(function () {
//        $.ms_DatePicker({
//            YearSelector: ".sel_year",
//            MonthSelector: ".sel_month",
//        });
//        $.ms_DatePicker();
        $("#flatpickr-calendar").flatpickr();
    });
</script>
<script src="/js/form/enco_info.js"></script>
</body>
</html>
