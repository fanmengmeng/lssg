<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>角色信息</title>
    <link href="<%=basePath%>/static/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>/static/plugins/bootstrap/css/bootstrap-table.css" rel="stylesheet">
    <style>
        .fixed-table-toolbar {
            display: none;
        }
    </style>
</head>
<body>
<div>
    <input type="text" id="rolename" class="form-control">
    <div>
        <shiro:hasPermission name="user/add">
            <a href="<%=basePath%>roleadd">新增角色</a>
        </shiro:hasPermission>
        <a href="javascript:void(0)">修改角色</a>
        <a href="javascript:void(0)" onclick="deleteRoles()">删除角色</a>
        <a href="javascript:void(0)" onclick="exportRoleExcel()">Excel (.xlsx)</a>
    </div>
    <table id="table" class="table-responsive"></table>

    </table>

</div>

<script src="<%=basePath%>/static/plugins/jquery.min.js"></script>
<script src="<%=basePath%>/static/plugins/bootstrap/js/bootstrap-table.js"></script>
<script src="<%=basePath%>/static/plugins/bootstrap/js/bootstrap.js"></script>
<script src="<%=basePath%>/static/plugins/bootstrap/js/bootstrap-table-zh-CN.js"></script>
<script src="<%=basePath%>/static/plugins/layer/layer.js"></script>
<script src="<%=basePath%>/static/js/sys/role/role.js"></script>

</body>
</html>