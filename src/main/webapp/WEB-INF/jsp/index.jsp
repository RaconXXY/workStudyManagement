<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>首页</title>


    <link rel="stylesheet" type="text/css" href="/lib/bower_components/bootstrap/dist/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/lib/bower_components/sweetalert2/dist/sweetalert2.css"/>
    <link rel="stylesheet" type="text/css" href="/css/base.css"/>
    <link rel="stylesheet" type="text/css" href="/css/style2.css"/>


</head>
<body>
<div class="headerBj">
    <div class="header_top clear">
        <div class="left logo">
            <a href="/index">
                <img src="/img/logopic.png" style="margin-left:-50px;"/>
            </a>
        </div>
        <div class="right">
            <div class="clear">
                <div class="right searchBox clear">
                    <form action="utils/search.html" method="get" target="_blank">
                        <input type="text" name="word" placeholder="请输入关键字" class="searchText left"/>
                        <input type="submit" value="搜索" name="" class="searchBtn  left"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="navBox">
        <ul class="nav clear">
            <li class="nav_li">
                <a href="/index" class="nav_a">首页</a>
            </li>
            <li class="nav_li">
                <a href="javascript:void(0);" class="nav_a">通知动态</a>
            </li>
            <li class="nav_li">
                <a href="javascript:void(0);" class="nav_a">信息公告</a>
            </li>
            <li class="nav_li">
                <a href="javascript:void(0);" class="nav_a">常见问题</a>
            </li>

            <li class="nav_li">
                <a href="javascript:void(0);" class="nav_a">助学政策</a>
            </li>

            <li class="nav_li">
                <a href="javascript:void(0);" class="nav_a">意见反馈</a>
                <ul>
                    <li>
                        <a href="channels/118.html">在线留言</a>
                    </li>

                    <li>
                        <a href="channels/119.html">联系我们</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<!--banner-->
<div class="banner_visual">
    <div class="flicking_con">
        <a href="javascript:void(0);" class="on"></a>
        <a href="javascript:void(0);" class=""></a>
        <a href="javascript:void(0);" class=""></a>
        <a href="javascript:void(0);" class=""></a>
    </div>
    <div class="banner_image">
        <ul>

            <li>
                <a href="javascript:;"><img src="/img/main02.gif" width="1180" height="450"/></a>
            </li>

            <li>
                <a href="javascript:;"><img src="/img/main01.png" width="1180" height="450"/></a>
            </li>

            <li>
                <a href="javascript:;"><img src="/img/main02.gif" width="1180" height="450"/></a>
            </li>

            <li>
                <a href="javascript:;"><img src="/img/main01.png" width="1180" height="450"/></a>
            </li>
        </ul>
    </div>
    <a href="javascript:;" id="btn_prev" class="icon-arrow-left2"></a>
    <a href="javascript:;" id="btn_next" class="icon-arrow-right2"></a>
</div>


<div class="main" id="main">
    <div class="home_column2 clear">
        <div class="left home_column2_Left">
            <div class="home_column2_title">
                <div class="left clear">

                    <span class="home_column2_title_tabBtn left first">通知动态</span>
                </div>
                <div class="clear right home_moreBox1">

                    <a href="channels/104.html" class="home_more right">更多</a>
                </div>
            </div>
            <div class="home_column2_tabDivBox">

                <div class="home_column2_tabDiv clear">
                    <ul class="home_news">

                        <li class="clear">
                            <a href="contents/105/304.html"
                               class="col_3 f_12 left">关于做好2016年国家奖学金、国家励志奖学金和国家助学金评定工作的通知</a>
                            <span class="col_6 f_12 right">2016-09-30</span>
                        </li>

                        <li class="clear">
                            <a href="contents/104/292.html"
                               class="col_3 f_12 left">关于做好2016年国家奖学金、国家励志奖学金和国家助学金评定工作的通知</a>
                            <span class="col_6 f_12 right">2016-09-30</span>
                        </li>

                        <li class="clear">
                            <a href="contents/105/303.html"
                               class="col_3 f_12 left">关于做好2016年国家奖学金、国家励志奖学金和国家助学金评定工作的通知</a>
                            <span class="col_6 f_12 right">2016-09-30</span>
                        </li>

                        <li class="clear">
                            <a href="contents/104/291.html"
                               class="col_3 f_12 left">关于做好2016年国家奖学金、国家励志奖学金和国家助学金评定工作的通知</a>
                            <span class="col_6 f_12 right">2016-09-30</span>
                        </li>

                        <li class="clear">
                            <a href="contents/105/302.html"
                               class="col_3 f_12 left">关于做好2016年国家奖学金、国家励志奖学金和国家助学金评定工作的通知</a>
                            <span class="col_6 f_12 right">2016-09-30</span>
                        </li>

                        <li class="clear">
                            <a href="contents/104/290.html"
                               class="col_3 f_12 left">关于做好2016年国家奖学金、国家励志奖学金和国家助学金评定工作的通知</a>
                            <span class="col_6 f_12 right">2016-09-30</span>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="right home_column2_Right">
            <div class="home_column2_title">
                <div class="left">
                    <span class="home_column2_title_span">登录入口</span>

                </div>
            </div>
            <div class="home_contactUs">
                <div class="yunBox">
                    <div class="yun_u2">
                        <p class="success_info">登录成功</p>
                        <div class="user_info">
                            <p>
                                <span class="success_left">学号（工号）: </span>
                                <span class="idNumber success_right"></span>
                            </p>
                            <p>
                                <span class="success_left">用户名: </span>
                                <span class="userName success_right"></span>
                            </p>
                            <p>
                                <span class="success_left">您的身份是: </span>
                                <span class="character success_right"></span>
                            </p>
                        </div>
                        <div class="action_control">
                            <input type="button" value="进入用户空间" id="enter_space">
                            <input type="button" value="登出" id="logout">
                            <input type="button" value="修改密码" id="change_password">
                        </div>
                    </div>


                    <div class="yun_u1">
                        <ul>
                            <li><span class="yun_s1">用户名：</span>

                                <input name="UserName" type="text" id="UserName" class="yun_int1"/>
                                <span id="RequiredFieldValidator" style="color:red;display:none;"> *</span>
                                <span id="ctl01" style="color:Red;display:none;"> *</span>

                            </li>
                            <li><span class="yun_s1">密&emsp;码：</span>

                                <input name="Password" type="password" id="Password" class="yun_int1"/>
                                <span id="RequiredFieldValidator1" style="color:Red;display:none;"> *</span>
                                <span id="ctl02" style="color:Red;display:none;"> *</span>

                            </li>

                            <li><span class="yun_s1">验证码：</span>

                                <input type="text" id="ValidateCode" name="ValidateCode"
                                       class="yun_int1 yun_int2" style="width:60px;"/>
                                <img id="imgVerify" name="imgVerify" align="absmiddle"
                                     src="<%= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + "/validatecode.jsp"%>"/>
                                <span id="ctl03" style="color:Red;display:none;"> *</span>
                            </li>

                            <li>
                                <label><input type="radio" name="character"  value="student" class="character-radio first"
                                              onselect="return false;" checked/>学生&emsp;</label>
                                <label><input type="radio" name="character" value="teacher" class="character-radio"
                                              onselect="return false;"/>教师&emsp;</label>
                                <label><input type="radio" name="character" value="manager" class="character-radio"
                                              onselect="return false;"/>管理员&emsp;</label>
                            </li>

                            <li><span class="yun_s1">&nbsp;</span>

                                <label class="checkbox">
                                    <input id="RememberMe" type="checkbox" name="RememberMe" checked="checked"/> 记住用户名&nbsp;&nbsp;&nbsp;&nbsp;<a href="/forgetPwd">忘记密码</a>
                                </label>

                                &nbsp;&nbsp;&nbsp;&nbsp;
                            </li>
                            <li><span class="yun_s1">&nbsp;</span>
                                <input name="LoginSubmit" value="登录"
                                       id="loginSubmit" class="yun_submit" style="width:101px" type="submit">
                                <input name="register" value="学生注册"
                                       id="registerSubmit" class="yun_submit" style="width:101px" type="submit">
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footerBj">
    <div class="footer">
    </div>

    <div class="footer_bottom">
        <div class="footer_text">
            <p>
                <span class="col_f f_12">浙江省杭州市余杭区仓前街道余杭塘路2318号|杭州师范大学|杭州国际服务工程学院</span>
            <p>
        </div>
    </div>

    <!--百度统计代码录入处-->

</div>

<ul class="rightNav">
    <li id="goTop" style="display: none;"><a href="#" title="返回顶部"><img src="/img/back.png"></a></li>
</ul>
<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="/lib/bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/lib/bower_components/sweetalert2/dist/sweetalert2.js"></script>
<script type="text/javascript" src="/lib/jsSHA/sha512.js"></script>
<script type="text/javascript" src="/js/jquery-juren-slidepattern.js"></script>
<script type="text/javascript" src="/js/jquery.touchSlider.js"></script>
<script type="text/javascript" src="/js/base.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
<script>
    console.log("<%= application.getAttribute("hostip") %>");
    console.log("<%= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() %>");
</script>
</body>
</html>


