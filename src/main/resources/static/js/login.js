$(document).ready(function () {
    $("#loginButton").click(function () {
        var username = $("#username").val().trim();
        var password = $("#password").val().trim();
        var rememberMe = $("input[name='rememberme']").is(':checked');
        if (username == null || username.length==0) {
            layer.tips('请输入用户名','#username',{
                tips: [2, 'red'],
                time:2000
            });
            return false;
        }
        if (password == null || password.length==0){
            layer.tips('请输入密码！','#password',{
                tips: [2, 'red'],
                time:2000
            });
            return false;
        }
        $.ajax({
            type: "post",
            url:  "login",
            data: {
                "username": username,
                "password": password,
                "rememberMe": rememberMe
            },
            dataType: "json",
            success: function (r) {
                if (r.code === 0) {
                    location.href =  '/index';
                } else {
                        layer.msg(r.msg,{icon:2});
                        $("#loginButton").html("登录");
                    }
                    /*  else {
                          $("#loginButton").html("登录");
                      }*/

                }

        });
    });
});
function changeImg() {
    var imgSrc = $("#imgObj");
    var src = imgSrc.attr("src");
    imgSrc.attr("src", chgUrl(src));
};
//时间戳
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function chgUrl(url) {
    var timestamp = (new Date()).valueOf();
    var stamp = $("#timestamp");
    /* alert(url);
    url = url.substring(0, 60);
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
        stamp.val(timestamp);
    } */
    return url;
};


