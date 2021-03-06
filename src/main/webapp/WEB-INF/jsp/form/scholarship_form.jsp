<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>国家奖学金申请表</title>
    <link rel="stylesheet" type="text/css" href="lib/flatpickr/flatpickr.css">
    <link rel="stylesheet" href="/css/form/form.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/sweetalert2/dist/sweetalert2.css"/>
</head>

<body>
<center>
    <div class="schoolarship_form" style="width:750px;">
        <div class="horizonbar" style="text-align:center;margin-bottom:20px;font-family:'宋体';font-size:20px">国家奖学金申请表
        </div>
        <div class="form_top">
            <form>
                <table>
                    <tr id="top1">
                        <td id="stipend_school">
                            学校：
                            <input type="text" value="杭州师范大学" name="stipend_school" class="stipend_school" disabled/>
                        </td>
                        <td id="stipend_academic">
                            院系：
                            <input type="text" class="academy-input" disabled>
                        </td>
                    <tr id="top2">
                        <td id="stipend_profession">
                            专业：
                            <input type="text" class="major-input" disabled>
                        </td>
                        <td id="stipend_class">
                            班级：
                            <input type="text" class="class-input" disabled>
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
                        <td>
                            <input type="text" name="stipend_name" class="stipend_name name-input" disabled/>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">性别：</td>
                        <td class="table_right">
                            <input type="radio" value="男" name="stipend_sex" class="stipend_sex" checked="checked"/>男
                            <input type="radio" value="女" name="stipend_sex" class="stipend_sex"/>女
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">出生年月：</td>
                        <td>
                            <input type="text" id="flatpickr-calendar" class="book_text birth-input" data-date-format="Y-m-d">
                        </td>
                    </tr>
                    <tr id="stipend_face">
                        <td class="table_left">政治面貌：</td>
                        <td>
                            <select name="stipend_face" class="stipend_face">
                                <option value="群众" selected>群众</option>
                                <option value="共青团员">共青团员</option>
                                <option value="预备党员">预备党员</option>
                                <option value="中共党员">中共党员</option>
                            </select>
                        </td>
                    </tr>
                    <tr id="stipend_nation">
                        <td class="table_left">民族：</td>
                        <td><input type="text" name="stipend_nation" class="stipend_nation"/>
                            <img src="/img/form/star.png" class="star"><span class="point">填写完整，如：汉族</span></td>
                    </tr>
                    <tr>
                        <td class="table_left">入学时间：</td>
                        <td>
                            <input type="text" class="book_text start-input" disabled/>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">专业：</td>
                        <td>
                            <input type="text" name="stipend_profession" class="stipend_profession major-input" disabled/>
                        </td>
                    </tr>
                    <tr id="stipend_time">
                        <td class="table_left">学制：</td>
                        <td><input type="text" name="stipend_time" class="stipend_time"/>
                            <img src="/img/form/star.png" class="star"><span class="point">肆年</span></td>
                    </tr>
                    <tr id="stipend_tel">
                        <td class="table_left">联系电话：</td>
                        <td>
                            <input type="text" name="stipend_tel" class="stipend_tel phone-input" />
                            <img src="/img/form/star.png" class="star"><span class="point">请输入手机长号</span></td>
                    </tr>
                    <tr id="stipend_identity">
                        <td class="table_left">身份证号：</td>
                        <td>
                            <input type="text" name="stipend_identity" class="stipend_identity"/>
                            <img src="/img/form/star.png" class="star">
                            <span class="point">若最后一位为字母，需大写</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="horizonbar">学习情况</div>
        <div class="form_main02 form_offset">
            <form>
                <table>
                    <tr id="stipend_origin">
                        <td class="table_left">成绩排名：</td>
                        <td>
                            <input type="text" name="stipend_origin" class="stipend_origin rank-input"/>
                            <img src="/img/form/star.png" class="star"><span class="point">名次/总人数</span></td>
                    </tr>
                    <tr id="stipend_income">
                        <td class="table_left">必修课门数：</td>
                        <td>
                            <input type="text" name="stipend_income" class="stipend_income course-num"/>
                            <img src="/img/form/star.png" class="star"><span class="point">填写数字，如：12</span></td>
                    </tr>
                    <tr id="stipend_people">
                        <td class="table_left">必修课及格以上门数：</td>
                        <td>
                            <input type="text" name="stipend_people" class="stipend_people pass-num"/>
                            <img src="/img/form/star.png" class="star"><span class="point">填写数字，如：12</span></td>
                    </tr>
                    <tr id="stipend_sex">
                        <td class="table_left">是否实行综合考评排名：</td>
                        <td class="table_right">
                            <input type="radio" value="是" name="rank" class="rank" checked="checked"/>是
                            <input type="radio" value="否" name="rank" class="rank"/>否
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="horizonbar">大学期间主要获奖情况</div>
        <div class="form_main03">
            <form>
                <table>

                </table>
                <input type="button" name="submit" class="submit addRewardInfo" value="添加获奖信息"/>
            </form>
        </div>
        <div class="horizonbar">申请理由</div>
        <div class="form_main04">
            <form>
                <textarea class="apply_reason reason" rows="10" cols="80" placeholder="字数200字以内"></textarea>
            </form>
        </div>
    </div>
    <form>
        <input type="button" name="submit" class="submit final-submit" value="保存并导出申请表"/><br/><br/>
        <img src="/img/form/star.png" class="star"><span class="point">导出后请仔细检查信息是否无误，如有错误返回重新编辑之后导出</span>
    </form>
</center>

<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<%--<script type="text/javascript" src="/js/form/date.js"></script>--%>
<script src="/lib/flatpickr/flatpickr.js"></script>
<script type="text/javascript" src="/js/form/scholarship.js"></script>
<script type="text/javascript" src="/lib/bower_components/sweetalert2/dist/sweetalert2.js"></script>
<script>
    $(function () {
//        $.ms_DatePicker({
//            YearSelector: ".sel_year",
//            MonthSelector: ".sel_month",
//        });
//        $.ms_DatePicker();
        $("#flatpickr-calendar").flatpickr();
        $("#flatpickr-calendar-study").flatpickr();
    });
</script>
</body>
</html>
