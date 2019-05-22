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
    <link rel="stylesheet" type="text/css" href="lib/flatpickr/flatpickr.css">
    <link rel="stylesheet" href="css/form/form.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/sweetalert2/dist/sweetalert2.css"/>
</head>

<body>
<center>
    <div class="admit_apply_form" style="width:750px;">
        <div class="horizonbar" style="text_align:center;margin_bottom:20px;font_family:'宋体';font_size:20px">
            杭州师范大学家庭经济困难学生认定申请表
        </div>
        <br/>
        <div class="horizonbar">个人基本介绍</div>
        <div class="form_main01 form_offset">
            <form>
                <table>
                    <tr id="stipend_name">
                        <td class="table_left">姓名：</td>
                        <td class='table_right'><input type="text" name="stipend_name" class="name-input" disabled="disabled"/></td>
                    </tr>
                    <tr id="stipend_sex">
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

                    <tr>
                        <td class="table_left">民族：</td>
                        <td class="nation_table_right">
                            <input type="text" name="stipend_nation" class="stipend_nation"/>
                            <img src="/img/form/star.png" class="star"><span class="point">填写完整，如：汉族</span></td>
                    </tr>
                    <tr>
                        <td class="table_left">政治面貌：</td>
                        <td>
                            <select name="stipend_face" class="stipend-face">
                                <option value="群众" selected>群众</option>
                                <option value="共青团员" >共青团员</option>
                                <option value="预备党员">预备党员</option>
                                <option value="中共党员">中共党员</option>
                            </select>
                        </td>
                    </tr>
                    <tr id="stipend_nation">
                        <td class="table_left">籍贯：</td>
                        <td>
                            <input type="text" name="stipend_nation" class="birth-place"/>
                            <img src="/img/form/star.png" class="star"><span class="point">填写到市级，如：浙江省杭州市</span>
                        </td>
                    </tr>
                    <tr id="stipend_academic">
                        <td class="table_left">学院：</td>
                        <td>
                            <input type="text" class="academy-input" disabled="disabled">
                        </td>
                    </tr>
                    <tr id="stipend_profession">
                        <td class="table_left">所学专业：</td>
                        <td>
                            <input type="text" class="major-input" disabled="disabled">
                        </td>
                    </tr>
                    <tr id="stipend_class">
                        <td class="table_left">班级：</td>
                        <td>
                            <input type="text" class="class-input" disabled="disabled">
                        </td>
                    </tr>
                    <tr id="stipend_number">
                        <td class="table_left">学号：</td>
                        <td><input type="text" name="stipend_number" class="id-input" disabled="disabled"/></td>
                    </tr>
                    <tr id="stipend_tel">
                        <td class="table_left">联系方式：</td>
                        <td><input type="text" name="stipend_tel" class="phone-input" />
                            <img src="/img/form/star.png" class="star"><span class="point">请输入手机长号</span></td>
                    </tr>
                    <tr id="stipend_apply">
                        <td class="table_left">是否继上年度连续申请：</td>
                        <td class="table_right">
                            <input type="radio" value="是" name="stipend_apply" class="stipend_apply" checked="checked"/>是
                            <input type="radio" value="否" name="stipend_apply" class="stipend_apply"/>否
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="horizonbar">在校有关情况</div>
        <div class="form_main02 form_offset">
            <form>
                <table>
                    <tr id="stipend_renting">
                        <td class="table_left">在校外租房：</td>
                        <td class="table_right">
                            <input type="radio" value="是" name="stipend_renting" class="stipend_renting" checked="checked"/>是
                            <input type="radio" value="否" name="stipend_renting" class="stipend_renting"/>否
                        </td>
                    </tr>
                    <tr id="stipend_">
                        <td class="table_left">参加勤工助学活动情况：</td>
                        <td class="table_right">
                            <textarea class="apply_reason work-study" rows="5" cols="50" placeholder="无"></textarea>
                    </tr>
                    <tr>
                        <td class="table_left">参与公益活动情况：</td>
                        <td class="table_right">
                            <textarea class="apply_reason social-activity" rows="5" cols="50" placeholder="无"></textarea>
                    </tr>
                    <td class="table_left">本学年获资助情况：</td>
                    <td class="table_right">
                        <input type="checkbox" value="国家励志奖学金" name="imburse">国家励志奖学金
                        <input type="checkbox" value="国家助学金" name="imburse">国家助学金
                        <input type="checkbox" value="山大助学金" name="imburse">山大助学金
                        <input type="checkbox" value="社会助学金" name="imburse">社会助学金
                        <input type="checkbox" value="临时困难补助" name="imburse">临时困难补助
                        <input type="checkbox" value="减免学费" name="imburse">减免学费
                        <input type="checkbox" value="其他" name="imburse">其他（请注明）

                    </td>
                    <tr>
                        <td class="table_left">其它：</td>
                        <td class="table_right">
                            <textarea class="apply_reason other-finance" name="" id="" cols="50" rows="5"
                                      placeholder="若无其他资助请跳过"></textarea>
                        </td>
                    </tr>

                    </tr>
                    <tr id="admit_imburse">
                        <td class="table_left">本学年已获资助金额（元）：</td>
                        <td>
                            <input type="text" name="admit_imburse" class="admit_imburse" placeholder="0"/>
                            <img src="/img/form/star.png" class="star"><span class="point">填写数字，如：5000</span></td>
                    </tr>
                </table>
            </form>
        </div>

        <div class="horizonbar">陈述申请认定理由</div>
        <div class="form_main03">
            <form>
                <textarea class="apply_reason reason" rows="10" cols="80"></textarea>
            </form>
        </div>
    </div>
    <form>
        <input type="button" name="submit" class="submit" value="保存并导出表格"/><br/><br/>
        <img src="/img/form/star.png" class="star"><span class="point">导出后请仔细检查信息是否无误，如有错误返回重新编辑之后导出</span>
    </form>
</center>

<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<%--<script type="text/javascript" src="/js/form/date.js"></script>--%>
<script src="/lib/flatpickr/flatpickr.js"></script>
<script type="text/javascript" src="/js/form/admit_apply.js"></script>
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
</body>
</html>
