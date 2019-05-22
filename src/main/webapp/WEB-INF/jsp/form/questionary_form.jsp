<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>家庭情况调查表</title>
    <link rel="stylesheet" type="text/css" href="lib/flatpickr/flatpickr.css">
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/sweetalert2/dist/sweetalert2.css"/>
    <link rel="stylesheet" href="/css/form/form.css" type="text/css"/>
</head>

<body>
<center>
    <div class="questionary_form" style="width:750px;">
        <div class="horizonbar" style="text-align:center;margin-bottom:20px;font-family:'宋体';font-size:20px">
            杭州师范大学学生及家庭情况调查表
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
        <div class="horizonbar">学生基本情况</div>
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
                    <tr>
                        <td class="table_left">民族：</td>
                        <td><input type="text" name="stipend_nation" class="stipend_nation"/>
                            <img src="/img/form/star.png" class="star"><span class="point">填写完整，如：汉族</span></td>
                    </tr>
                    <tr>
                        <td class="table_left">入学前户口：</td>
                        <td class="table_right">
                            <input type="radio" value="城镇" name="stipend_household" class="stipend_household" checked="checked"/>城镇
                            <input type="radio" value="农村" name="stipend_household" class="stipend_household"/>农村
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">孤儿：</td>
                        <td class="table_right">
                            <input type="radio" value="是" name="stipend_orphan" class="stipend_orphan" checked="checked"/>是
                            <input type="radio" value="否" name="stipend_orphan" class="stipend_orphan"/>否
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">残疾：</td>
                        <td class="table_right">
                            <input type="radio" value="是" name="stipend_deformed" class="stipend_deformed" checked="checked"/>是
                            <input type="radio" value="否" name="stipend_deformed" class="stipend_deformed"/>否
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">单亲：</td>
                        <td class="table_right">
                            <input type="radio" value="是" name="stipend_single" class="stipend_single" checked="checked"/>是
                            <input type="radio" value="否" name="stipend_single" class="stipend_single"/>否
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">烈士或优抚对象子女：</td>
                        <td class="table_right">
                            <input type="radio" value="是" name="stipend_martyr" class="stipend_martyr" checked="checked"/> 是（需提供相关证明材料）
                            <input type="radio" value="否" name="stipend_martyr" class="stipend_martyr"/>否
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">农村建档立卡贫困户或城市低保户：</td>
                        <td class="table_right">
                            <input type="radio" value="是" name="stipend_basic_living" class="stipend_basic_living" checked="checked"/> 是（需提供相关证明材料）
                            <input type="radio" value="否" name="stipend_basic_living" class="stipend_basic_living"/>否
                        </td>
                    </tr>
                    <tr id="stipend_tel">
                        <td class="table_left">联系电话：</td>
                        <td>
                            <input type="text" name="stipend_tel" class="stipend_tel" />
                            <img src="/img/form/star.png" class="star"><span class="point">请输入手机长号</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">身份证号码：</td>
                        <td><input type="text" name="stipend_identity" class="stipend_identity"/>
                            <img src="/img/form/star.png" class="star"><span class="point">若最后一位为字母，需大写</span></td>
                    </tr>
                    <tr>
                        <td class="table_left">家庭地址：</td>
                        <td class="table_right">
                            <input type="text" name="stipend_address" class="stipend_address" style="width:300px;"/>
                            <img src="/img/form/star.png" class="star"><span class="point">填写完整家庭住址，具体到门牌号</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="horizonbar">家庭成员情况</div>
        <div class="form_main02">
            <form>
                <table>


                </table>
                <input type="button" name="submit" class="submit addFamilyInfo" value="添加家庭成员信息"/>
            </form>
        </div>
        <div class="horizonbar">家庭经济情况>>>本年度家庭成员年收入
            <img src="/img/form/star.png" class="star"><span class="point">收入或人口数一律填写数字，如：5000/4</span>
        </div>
        <div class="form_main03 form_offset">
            <form>
                <table>
                    <tr>
                        <td class="table_left">家庭成员年工资合计（元）：</td>
                        <td>
                            <input type="text" name="questionary_income_01" class="questionary_income_01 salary-per-year"/>
                            <img src="/img/form/star.png" class="star">
                            <span class="point">包含工资、奖金、养老金等以及打工收入</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">家庭个体经营年总收入（元）：</td>
                        <td>
                            <input type="text" name="questionary_income_02" class="questionary_income_02 indi-oper-year"/>
                            <img src="/img/form/star.png" class="star">
                            <span class="point">包含个体手工业、商业买卖等</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">资产年收入（元）：</td>
                        <td>
                            <input type="text" name="questionary_income_03" class="questionary_income_03 assets-income"/>
                            <img src="/img/form/star.png" class="star">
                            <span class="point">房产出租、存款利息及股票、基金、债券收益等</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">家庭农业年净收入（元）：</td>
                        <td>
                            <input type="text" name="questionary_income_04" class="questionary_income_04 agriculture-income"/>
                            <img src="/img/form/star.png" class="star">
                            <span class="point">扣除化肥、农药、种子、税费等农业支出</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">家庭副业年净收入（元）：</td>
                        <td>
                            <input type="text" name="questionary_income_05" class="questionary_income_05 sideline-income"/>
                            <img src="/img/form/star.png" class="star">
                            <span class="point">包含渔业、畜牧业、林业等</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">家庭其他收入（元）：</td>
                        <td>
                            <input type="text" name="questionary_income_06" class="questionary_income_06 other-income"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">家庭人口（人）：</td>
                        <td>
                            <input type="text" name="questionary_people" class="questionary_people"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">家庭年收入总计（元）：</td>
                        <td>
                            <input type="text" name="questionary_income_all" class="questionary_income_all"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">家庭人均年收入（元）：</td>
                        <td>
                            <input type="text" name="questionary_income_average" class="questionary_income_average"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="table_left">家庭劳动力（人）：</td>
                        <td>
                            <input type="text" name="questionary_work" class="questionary_work"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="horizonbar">家庭经济情况>>>本年度家庭成员年大笔支出情况
            <img src="/img/form/star.png" class="star"><span class="point">收入一律填写数字，如：5000</span>
        </div>
        <div class="form_main04 form_offset">
            <form>
                <table>
                    <tr id="questionary_income_01">
                        <td class="table_left">家庭成员大病支出（元）：</td>
                        <td>
                            <input type="text" name="questionary_income_01" class="questionary_income_01 illness-fee"/>
                            <img src="/img/form/star.png" class="star">
                            <span class="point">金额超过1万需提供医疗费票据复印件</span>
                        </td>
                    </tr>
                    <tr id="questionary_income_02">
                        <td class="table_left">家庭成员非义务制教育支出（包含本人）学费：</td>
                        <td>
                            <input type="text" name="questionary_income_02" class="questionary_income_02 tuition"/>
                        </td>
                    </tr>
                    <tr id="questionary_income_03">
                        <td class="table_left">家庭成员非义务制教育支出（包含本人）住宿费：</td>
                        <td>
                            <input type="text" name="questionary_income_03" class="questionary_income_03 accommodation"/>
                        </td>
                    </tr>
                    <tr id="questionary_income_04">
                        <td class="table_left">家庭遭受自然灾害，农作物或家庭财产受损严重（元）：</td>
                        <td>
                            <input type="text" name="questionary_income_04" class="questionary_income_04 natural-loss"/>
                        </td>
                    </tr>
                    <tr id="questionary_income_05">
                        <td class="table_left">其他：</td>
                        <td>
                            <input name="questionary_income_05" class="questionary_income_05 other"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <form>
        <input type="button" name="submit" class="submit final-submit" value="保存并导出表格"/><br/><br/>
        <img src="/img/form/star.png" class="star"><span class="point">导出后请仔细检查信息是否无误，如有错误返回重新编辑之后导出</span>
    </form>
</center>

<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<%--<script type="text/javascript" src="/js/form/date.js"></script>--%>
<script src="/lib/flatpickr/flatpickr.js"></script>
<script type="text/javascript" src="/js/form/questionary.js"></script>
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
