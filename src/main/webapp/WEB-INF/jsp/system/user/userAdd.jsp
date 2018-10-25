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
    <title>添加用户</title>
    <link rel="stylesheet" href="<%=basePath%>/static/plugins/amazeui/css/amazeui.css"/>
</head>

<body>
<form id="user-add-form">
    <span>用户名：</span>
    <input type="text" name="username">
    <span>密码：</span>
    <input type="text" name="password">

    <span>所属企业(项目)：</span>
    <input type="text" name="company">
    <span>联系电话：</span>
    <input type="text" name="mobile">
    <span>微信号：</span>
    <input type="text" name="wechat">
    <span>状态：</span>
    <div class="toggle-switch">
        <input type="checkbox" name="status" checked class="toggle-switch__checkbox">
        <i class="toggle-switch__helper"></i>
    </div>

    <input type="text" name="status">
    <span>头像：</span>
    <input type="text" name="avatar">

    <span>备注：</span>
    <input type="text" name="remark">

    <select id="selectRole"  style="width: 80%">
    </select>
    <input id="roles" name="roles" hidden/>

    <select id=“selectInfo”  multiple style="width: 80%"></select>
    <input id="infos" name="infos" hidden/>

</form>
<button type="button" class="btn btn-save" id="save" name="save">保存</button>

<script src="<%=basePath%>/static/plugins/jquery.min.js"></script>
<script src="<%=basePath%>/static/plugins/amazeui/js/amazeui.js"></script>
<script src="<%=basePath%>/static/plugins/jquery-validate/js/jquery.validate.min.js"></script>
<script src="<%=basePath%>/static/plugins/jquery-validate/js/messages_zh.min.js"></script>
<script src="<%=basePath%>/static/plugins/jquery-validate/js/additional-methods.min.js"></script>
<script src="<%=basePath%>/static/plugins/layer/layer.js"></script>
<script src="<%=basePath%>/static/js/sys/user/userAdd.js"></script>

</body>
</html>