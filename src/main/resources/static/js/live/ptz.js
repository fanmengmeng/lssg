//云台控制

$("#up").click(function () {
    var direction = $("#up").val();
    openPtz(direction);
});

function openPtz(direction){
    $.ajax({
        //
        url: "/ptz/open",
        type : "post",
        //contentType: "application/json;charset=utf-8",
        dataType : "json",
        data : {
            "direction" : direction
        },
        success : function(result) {
            console.log(result.msg);
            if(result.code!=200){
                alert("设备故障，请联系管理员!");
            }
        }

    });

}
$("#down").click(function () {
    $.ajax({
        //
        url: "/ptz/ss",
        type: "post",
        //contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
            console.log(result);
            if (result.code != 200) {
                alert("设备故障，请联系管理员!");
            }
        }
    });
});