
//$("img").prop("src","地址");
$(function() {

    initData();
    $("#content").empty();
});
//加载初始化数据
function initData(){
  /*  var firstAreaName = $('#select_area option:first').val();
    $("#areaName").text(firstAreaName);*/

    $.ajax({
        //
        url: "/project/get",
        type : "get",
        //contentType: "application/json;charset=utf-8",
        dataType : "json",
        success : function(result) {
            for(var i = 0; i < result.length; i++) {
               var devices = result[i].devices;
               console.log(devices);
            }
            $.each(result,function(index, item){
                $("#nav").append('<ul><li class="project">'+item.projectname+'</li></ul>');
            });
            $.each(devices,function(index, item){
                $(".project").append('<ul><li>'+item.deviceserial+'</li></ul>');
            });
        },
        error : function() {
            alert("服务器异常");
        }
    });
}
//select选择项目名称改变右边video的内容
$("#select_area").change(function (){

    var selectName= $("#select_area").find("option:selected").text();
    $("#areaName").text(selectName);
    console.log(selectName);

    $.ajax({
        //
        url: "/live/pass",
        type : "post",
        //contentType: "application/json;charset=utf-8",
        dataType : "json",
        data : {
            "selectName" : selectName
        },
        beforeSend: function (XMLHttpRequest) {
            $("#content").html("正在加载数据");
        },
        success : function(result) {
            var rtmp = [];
            var hls = [];
            var jsonO = eval(result);
            var video = $("#myPlayer");

            for ( var i in jsonO) {
                hls.push(jsonO[i].hls);
                rtmp.push(jsonO[i].rtmp);

            }
            var dataMap=[];
            for(var i= 0,len=rtmp.length;i<len;i++){
                dataMap.push([rtmp[i],hls[i]]);
            }
            console.log(dataMap);
            //动态添加二维数组到video标签 (index,value)
            var vid = 0;
            $.each(dataMap,function(i,row){
                var videoadd = "";
                vid=vid+1;
                videoadd +='<video id="myPlayer'+vid+'"  width="500" height="300" class="myPlayer" poster="" controls playsInline webkit-playsinline autoplay>';
                videoadd +='<source type="rtmp/flv" src="'+row[0]+'" />';
                videoadd +='<source type="application/x-mpegURL" src="'+row[1]+'" />';

                $("#content").append(videoadd);
                var player = new EZUIPlayer('myPlayer' + vid);
            });


            /* 	 $("video #rtmp").each(function(){
                     $(this).attr("src",rtmp);
                        //$("#hls").attr("src",hls);
                 });  */


        },
        error : function() {
            alert("服务器异常");
        }
    });

    $("#content").empty();
});

