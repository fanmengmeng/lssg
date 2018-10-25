$(function () {
    /* 	 var now = new Date();
         var strTime=now.getFullYear()+"-"+now.getMonth()+"-"+now.getDate()+" "+now.getHours()+":"+now.getMinutes()+"-"+now.getSeconds();
         $("#t1").val(strTime);  */
    /* bootstrap datatimePicker日历插件 */

    $("#t1").datetimepicker({
        format:'yyyy-mm-dd',
        language:'zh-CN',
        minView: "month",
        todayBtn:  1,
        autoclose: 1,
        defaultDate: +7,
        endDate:new Date(),
        timeFormat: "HH:mm:ss",
        dateFormat: "yyyy-mm-dd",
        linkField:"mirror_field"

    });
    change = function (){
        var cal = $("#t1").val().replace(/\-| |:/g,"");
        init(cal);
    }


    var time = new Date();
    //jQuery(".nowTime").val(time.toJSON().substring(0, 10).replace("/", "").replace("/", ""));
    jQuery("#t1").val(time.toJSON().substring(0, 10));
    // $('input').unbind();
    $('#t2').unbind();
    $("#t2").click (function () {

        $(".modal-body").triggerHandler ("click");
        /*  $("#t2").css('display','block');  */
    })

    //bootstarp modal可以控制位置
    /*  $(".modal-dialog").draggable({
        handle: ".modal-header",
        cursor: 'move',
        refreshPositions: false
    });   */
    $("#myModal").css("overflow", "hidden");//禁止模态对话框的半透明背景滚动

    /*  input传值       */

    editInfo = function (){
        var cal = document.getElementById("t1").value;
        // console.log(cal);
        var reg =/(\d{4})\-(\d{2})\-(\d{2})/;
        var date = cal.replace(reg,"$1年$2月$3日");
        $('#cal').text(date);
        $('#myModal').modal('show');
    }

    /* 验证input输入框时分秒值 */
    hh = function (){

        var str = $(".hh").val();

        var a = str.match(/^([0-9]|1\d|2[0-3])$/);
        if (!a || str=="" || str==null) {  //格式错误这里就报错,提示a1=null

            $(".hh").val('00');
        }

        else if(str.length<2){
            str = "0" + str;
            $(".hh").val(str);
        }
        else{

            return true;
        }

    }

    mm = function (){
        var str = $(".mm").val();

        var a = str.match(/^[1-5]?[0-9]$/);
        if (!a || str=="" || str==null) {  //格式错误这里就报错,提示a1=null

            $(".mm").val('00');
        }

        else if(str.length<2){
            str = "0" + str;
            $(".mm").val(str);
        }
        else{

            return true;
        }

    }
    ss = function (){

        var str = $(".ss").val();

        var a = str.match(/^[1-5]?[0-9]$/);
        if (!a || str=="" || str==null) {  //格式错误这里就报错,提示a1=null

            $(".ss").val('00');
        }
        else if(str.length<2){
            str = "0" + str;
            $(".ss").val(str);
        }

        else{

            return true;
        }

    }

});
/* 确定按钮 */
function update() {
    //获取模态框数据
    var hh = $('.hh').val();
    var mm= $('.mm').val();
    var ss = $('.ss').val();
    var t = hh+':'+mm+':'+ss;
    //var t =hh+':'+mm+':'+ss;

    var ten1 = $('#t2').val(t);
    var ten = hh+mm+ss;

    init(ten);
    $('#myModal').modal('hide');
}


