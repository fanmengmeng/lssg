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
    <title>实时监控</title>
    <link href="<%=basePath%>/static/css/video/live/live.css" rel="stylesheet">

</head>
<body>

<div id="nav">

</div>

<script src="<%=basePath%>/static/plugins/jquery.min.js"></script>
<script src="<%=basePath%>/static/plugins/bootstrap/js/bootstrap.js"></script>
<!--<script src="/static/js/live/live.js"></script>-->
<script src="<%=basePath%>/static/plugins/ezkitjs/ezuikit.js" type="text/javascript"></script>
<script src="<%=basePath%>/static/js/live/live.js" type="text/javascript"></script>
</body>
</html>