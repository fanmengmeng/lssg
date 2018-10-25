var validator;
var $roleAddForm = $("#role-add-form");
$(function () {
    validateRule();
    createMenuTree();
    $("#save").click(function () {
        getMenu();;
        var validator = $roleAddForm.validate();
        var flag = validator.form();
        if (flag) {
            $.post("role/add", $roleAddForm.serialize(), function (r) {
                if (r.code === 0) {
                    layer.msg(r.msg,{icon:1});
                }else {
                    layer.msg(r.msg,{icon:2});
                }
            });
        }

    });
});

function validateRule() {
    validator = $roleAddForm.validate({
        rules: {
            rolename: {
                required: true,
                minlength: 1,
                maxlength: 10,
                },
            remark: {
                maxlength: 50
            },
          menuId: {
             required: true
         }
}, messages: {
            rolename: {
                required:  "请输入角色名称",
                minlength:  "角色名称长度1到10个字符"
        },
            remark: "角色描述不能超过50个字符",
            menuId:  "请选择相应菜单权限"
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

function createMenuTree() {
    $.post("menu/menuButtonTree", {}, function (r) {
        if (r.code === 0) {
            var data = r.msg;
            $('#menuTree').jstree({
                "core": {
                    'data': data.children
                },
                "state": {
                    "disabled": true
                },
                "checkbox": {
                    "three_state": false
                },
                "plugins": ["wholerow", "checkbox"]
            });
        } else {

        }
    })

}

function getMenu() {
    var $menuTree = $('#menuTree');
    var ref = $menuTree.jstree(true);
    var menuIds = ref.get_checked();
    $menuTree.find(".jstree-undetermined").each(function (i, element) {
        menuIds.push($(element).closest('.jstree-node').attr("id"));
    });
    $("[name='menuId']").val(menuIds);
}