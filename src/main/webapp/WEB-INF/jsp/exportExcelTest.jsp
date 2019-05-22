<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>download</title>
</head>
<body>
<div>
    文件以模板的方式导出，模板存放在项目中(resource/template)
</div>
<form action="ExportExcel/ajaxExport.do" method="post" id="form2">
    <input type="submit" id="exportExcel" name="exportExcel" value="测试Excel导出"/>
</form>
<button onclick="downloadExcel('/discountfeetablesaveExcel')">学费减免学生信息汇总表</button><br/>
<button onclick="downloadExcel('/encouragementtablesaveExcel')">励志奖学金获奖学生初审名单表</button><br/>
<button onclick="downloadExcel('/scholarshiptablesaveExcel')">国家奖学金获奖学生初审名单表</button><br/>
<button onclick="downloadExcel('/stipendtablesaveExcel')">国家助学金获得者名单备案表</button><br/>
<button onclick="downloadExcel('/studentlibtablesaveExcel')">【励志生库】家庭经济困难学生信息登记表和统计表</button><br/>
</body>
<script src="/lib/bower_components/jquery/dist/jquery.js"></script>
<script>
    function downloadExcel(path) {
        console.log(path);
        let data = {
                userId: JSON.parse(localStorage.user).userId
            };
        let form = $(`<form id="downloadwordexcel" style="display:none" target="" method="post" action="${path}"></form>`);
        $('body').append(form);
        for (let i in data) {
            let str = `<input type="hidden" name="${i}" value="${data[i]}"/>`;
            console.log(str);
            form.append(str);
        }
        form.submit();
        $('#downloadwordexcel').remove();
    }
</script>
</html>


