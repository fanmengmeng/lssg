var validator;
var $userAddForm = $("#user-add-form");
var $rolesSelect = $userAddForm.find("select[name='rolesSelect']");
var $roles = $userAddForm.find("input[name='roles']");
$(function () {
    validateRule();
    initRole();
    initInfo();

    $("input[name='status']").change(function () {
        var checked = $(this).is(":checked");
        var $status_label = $("#status");
        if (checked) $status_label.html('可用');
        else $status_label.html('禁用');
    });

});
$("#save").click(function () {
    var validator = $userAddForm.validate();
    var flag = validator.form();
    if (flag) {
        $.post("user/add", $userAddForm.serialize(),function (r) {
            if (r.code === 0) {
                layer.msg(r.msg,{icon:1});
            }else {
                layer.msg(r.msg,{icon:2});
            }
        });
    }
});

function validateRule() {
    validator = $userAddForm.validate({
        rules: {
            username: {
                required: true,
                minlength: 3,
                maxlength: 10,
            },
          /*  roles: {
                required: true
            },*/
            mobile: {
                checkPhone: true
            }
        },
        errorPlacement: function (error, element) {
            if (element.is(":checkbox") || element.is(":radio")) {
                error.appendTo(element.parent().parent());
            } else {
                error.insertAfter(element);
            }
        },
        messages: {
            username: {
                required: "请输入用户名!",
                minlength:  "用户名长度3到10个字符",
            },
            roles:  "请选择用户角色"
        },
        //重写showErrors
        showErrors: function (errorMap, errorList) {
            var msg = "";
            $.each(errorList, function (i, v) {
                //msg += (v.message + "\r\n");
                //在此处用了layer的方法,显示效果更美观
                layer.tips(v.message, v.element, { time: 2000,tips: [2, 'red']});
                return false;
            });
        },
        /* 失去焦点时不验证 */
        onfocusout: false

    });
}
function initRole(){
    $.post("role/roles", function (data) {
        $.each(data, function(index, item) {
            $("#selectRole").append(  //此处向select中循环绑定数据
                "<option value="+item.id+">" + item.rolename+ "</option>");
        });

    });
    }
$("#selectRole").change(function () {
    $("#roles").val($("#selectRole").val());
});

function initInfo() {
    $.post("info/infos", function (data) {
        console.log(data);
        var select =  $("#selectInfo");
        for(var i = 0;i<data.length;i++){
            select.append( "<option value='" + data[i].id + "'>" + data[i].projectname + "</option>");
        }
    });

}
$("#selectInfo").change(function () {
    $("#infos").val($('#selectInfo').selectpicker('val'));
});