<%--
  Created by IntelliJ IDEA.
  User: fukai
  Date: 2017/8/20 0020
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <title>jsSHA</title>
</head>
<body>
<h1>sha512</h1>
<p>
    sha512散列结果的16进制表示即为128位长度字符串
</p>
<input id="txt"><input id="sha" type="button" value="sha-512 hash">
<p id="res"></p>
<script type="text/javascript" src="/lib/bower_components/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="/lib/jsSHA/sha512.js"></script>
<script>
    $('#sha').click(()=>{
        let msg = $('#txt').val();
        const shaObj = new jsSHA("SHA-512", "TEXT");
        shaObj.update(msg);
        const sha = shaObj.getHash("HEX");
        $('#res').text(sha);
    })
</script>
</body>
</html>
