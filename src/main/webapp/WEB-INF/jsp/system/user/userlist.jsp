<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>用户信息</title>
    <link href="<%=basePath%>/static/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>/static/plugins/bootstrap/css/bootstrap-table.css" rel="stylesheet">
    <style>
        .fixed-table-toolbar{
            display: none;
        }
    </style>
</head>
<body>
<div>

    <button onclick="location.href='useradd.html'" shiro:hasPermission="user/add"
            style="width: 50px;background-color: white"> +
    </button>
    <button onclick="deleteUsers()" style="width: 50px;background-color: white">-</button>
    <a href="javascript:void(0)" onclick="exportUserExcel()">
        Excel (.xlsx) </a>
    <table id="table" class="table-responsive"></table>

    </table>
</div>

<script src="<%=basePath%>/static/plugins/jquery.min.js"></script>
<script src="<%=basePath%>/static/plugins/bootstrap/js/bootstrap-table.js"></script>
<script src="<%=basePath%>/static/plugins/bootstrap/js/bootstrap.js"></script>
<script src="<%=basePath%>/static/plugins/bootstrap/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript"
        src="<%=basePath%>/static/plugins/layer/layer.js"></script>
<script src="<%=basePath%>/static/js/sys/user/user.js"></script>

</body>
</html>