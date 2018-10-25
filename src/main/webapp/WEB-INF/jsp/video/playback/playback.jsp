<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>录像回放</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link href="<%=basePath%>/static/css/style_ie.css" rel="stylesheet">
    <link href="<%=basePath%>/static/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>/static/plugins/datetimePicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <style type="text/css">
        body {
            background-color: #F0F8FF;
        }

        table {
            /* BORDER-COLLAPSE: collapse;
            border-style: dotted;
            border-color: #7CCD7C;  */

        }

        #myModal {
            top: 350px;
            left: 50px;
        }

        .modal-dialog {
            left: 10px;
            top: 50px;
        }

        #cal {
            left: 200px;
        }

        .container {
            margin: 0;
            padding-top: 10px;
            /*padding: 0px 0px 0px 0px;*/
            width: 750px;
            font-family: "Trebuchet MS", Arial, Verdana, sans-serif;
            font-size: 14px;
            color: #000000;
        }

        .application {
            /*float: right;*/
            padding: 10px 10px 10px 10px;
            margin: 0 0 0 0;
            width: 1000px;
            background: #CECEB5;
            font-family: "Trebuchet MS", Arial, Verdana, sans-serif;
            /* border: 1px solid #212829; */
            text-align: left;
        }

    </style>

</head>
<body onload="init()">
<!--   video -->
<table width="1400">

    <tr>
        <td width="255">
            <object
                    classid="clsid:54FC7795-1014-4BF6-8BA3-500C61EC1A05" id="EZUIKit"
                    width="1000" height="400" name="EZUIKit">

            </object>
        </td>
        <td valign="bottom">
</table>

<table width="1200" height="100">
    <tr>
        <td>选择日期播放录像回放</td>
        <td>
            <!-- <div class="input-group date form_datetime" id="sform"> -->
            <input type="text" id="t1" class="bind_hover_card"
                   style="width:150px;height:40px;color: red;font-size: 15px;border-radius:20px;text-align:center;margin-left:20px;margin-top:30px;"
                   data-date-format="yyyy-mm-dd" readonly="readonly" onchange="change();"/>
            <input type="text" id="t2" data-backdrop="static"
                   style="width:150px;height:40px;color: red;font-size: 15px;border-radius:20px;text-align:center;margin-top:30px;"
                   value="12:00:00" readonly="readonly" data-toggle="modal" data-target="#myModal"
                   onclick="editInfo();"/>
                 </td>
    </tr>
    <tr>
        <td><input type="button" value="开始播放" onclick="StartPlay()"
                   style="display: block" id="startplaybtn"> <input
                type="button" value="结束播放" onclick="StopPlay()"
                style="display: none" id="stopplaybtn"></td>
        <td><textarea rows=8 cols=70 id="dataPanel"></textarea></td>
    </tr>

    <tr>
        <td>播放结果</td>
        <td><textarea rows=8 cols=70 id="showPanel" value=""></textarea></td>
    </tr>
</table>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" style=""
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color: #E8E8E8;">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    定位录像时间
                </h4>
            </div>
            <div class="modal-body" style="height:150px;margin:0;text-align: center;margin-top: 50px;font-size: 18px;">
                <span id="cal"></span>


                <!--  onkeyup="this.value=this.value.replace(/^([0-1]{1}/d|2[0-3])/,'')" -->
                <input type="text" style="width:70px;height:40px;text-align:center;" class="hh" value="00"
                       onblur="hh();"/>
                <span>时</span>
                <input type="text" style="width:70px;height:40px;text-align: center;" class="mm" value="00"
                       onblur="mm();"/>
                <span>分</span>
                <input type="text" style="width:70px;height:40px;text-align: center;" class="ss" value="00"
                       onblur="ss();"/>
                <span>秒</span>
            </div>
            <div class="modal-footer" style="height:60px;background-color: #E8E8E8;">

                <button type="button" class="btn btn-primary" id="confirm" onclick="update();">
                    确定
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div>

<script src="<%=basePath%>/static/plugins/jquery.min.js"></script>
<script src="<%=basePath%>/static/plugins/json2.js" type="text/javascript"></script>
<script src="<%=basePath%>/static/plugins/bootstrap/js/bootstrap.js"></script>
<script src="<%=basePath%>/static/plugins/datetimePicker/js/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="<%=basePath%>/static/plugins/datetimePicker/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="<%=basePath%>/static/js/live/playback.js"></script>
<script src="<%=basePath%>/static/plugins/ezkitjs/activex.js"></script>


<script language="javascript" for="EZUIKit"
        event="PluginEventHandler(lEventType, strErrorCode, lInterErrorCode)">   //打开预览时触发该事件
PluginEventHandler(lEventType, strErrorCode, lInterErrorCode);
</script>
</body>
</html>