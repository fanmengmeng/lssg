<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>绿色施工监控平台</title>

</head>
<style>

</style>
<body>
<!-- Form-->
<div class="form">

    <input type="text" name="username" id="username" placeholder="用户名"/>

    <input type="password" name="password" id="password" placeholder="密码"/>

</div>

<input type="checkbox" name="rememberme"/>&nbsp;&nbsp;记住我</p>


<button id="loginButton">登录</button>

</body>
<script src="<%=basePath%>/static/plugins/jquery.min.js"></script>
<script src="<%=basePath%>/static/plugins/layer/layer.js"></script>
<script src="<%=basePath%>/static/plugins/jquery-validate/js/jquery.validate.min.js"></script>
<script src="<%=basePath%>/static/plugins/jquery-validate/js/messages_zh.min.js"></script>
<script src="<%=basePath%>/static/js/login.js"></script>


</html>