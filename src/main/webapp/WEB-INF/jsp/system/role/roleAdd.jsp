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
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>新增角色</title>
    <link href="<%=basePath%>/static/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>/static/plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet">
    <link href="<%=basePath%>/static/plugins/jsTree/css/style.min.css" rel="stylesheet">
</head>
<body>
<form id="role-add-form">
    <span>角色名称：</span>
    <input type="text" name="rolename">
    <input type="text" name="id" hidden class="form-control">

    <span>备注：</span>
    <input type="text" name="remark">

    <div id="menuTree"></div>
    <input type="hidden" name="menuId">

</form>
<button type="button"  id="save">保存</button>

<script src="<%=basePath%>/static/plugins/jquery.min.js"></script>
<script src="<%=basePath%>/static/plugins/bootstrap/js/bootstrap.js"></script>
<script src="<%=basePath%>/static/plugins/bootstrap-select/js/bootstrap-select.js"></script>
<script src="<%=basePath%>/static/plugins/jsTree/js/jstree.js"></script>
<script src="<%=basePath%>/static/plugins/jquery-validate/js/jquery.validate.min.js"></script>
<script src="<%=basePath%>/static/plugins/jquery-validate/js/messages_zh.min.js"></script>
<script src="<%=basePath%>/static/plugins/jquery-validate/js/additional-methods.min.js"></script>
<script src="<%=basePath%>/static/plugins/layer/layer.js"></script>
<script src="<%=basePath%>/static/js/sys/role/roleAdd.js"></script>

</body>
</html>