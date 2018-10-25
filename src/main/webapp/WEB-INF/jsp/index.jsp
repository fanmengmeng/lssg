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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="edge" />
    <title>绿色施工监控平台</title>
    <link rel="shortcut icon" type="image/png" href="<%=basePath%>/static/img/favicon.ico" />

</head>
<body>
    <div>
        <ul id="#menu">
            <li><a></a></li>
        </ul>

    </div>

    <div id="electricity" style="height:400px;width: 550px;"></div>


</body>
<script src="<%=basePath%>/static/plugins/jquery.min.js"></script>
<script src="<%=basePath%>/static/plugins/echarts/echarts.min.js"></script>
<script src="<%=basePath%>/static/plugins/layer/layer.js"></script>
<script src="<%=basePath%>/static/js/index.js"></script>

</html>