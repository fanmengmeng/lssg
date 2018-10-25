
$("#table").bootstrapTable({
    //请求地址
    method: "post", //get方式提交 
    //contentType : "application/x-www-form-urlencoded; charset=UTF-8" ,
    url: "user/list", //获取数据  
    //请求内容类型
    async: true,
    contentType: "application/x-www-form-urlencoded;charset=UTF-8",
    //数据类型
    dataType: "json",
    //每行的唯一标识
    uniqueId: "id",
    //显示隐藏列
    showColumns: true,
    //是否显示分页
    pagination: true,
    //是否启用点击选中行
    clickToSelect: true,
    //最少要显示的列数
    minimumCountColumns: 10,
    //分页方式：client客户端分页，server服务端分页
    sidePagination: "server",
    //每页的记录行数
    pageSize: 10,
    //初始化加载第1页，默认第1页
    pageNumber: 1,
    //可供选择的每页的行数
    pageList: "[10, 25, 50, 80, 100]",
    paginationFirstText: "首页",
    paginationPreText: "上一页",
    paginationNextText: "下一页",
    paginationLastText: "末页",
    buttonsClass: 'default',
    queryParams: function queryParams(params) {
        var param = {
            pageNumber: this.pageNumber,
            pageSize: this.pageSize
        };
        return param;
    },
    columns: [
        {
            //field: 'Number',//可不加
            //title: 'Number',//标题  可不加
            width: 20,
            formatter: function (value, row, index) {
                return index + 1;
            }
        },
        {
            checkbox: true
        },
        {
            field: 'id',
            visible: false
        },
        {
            field: 'username',
            title: '用户昵称',
            align: 'center',
            cellStyle: {
                css: {"color": "green"}
            }
        },
        {
            field: 'company',
            title: '所属公司(项目)',
            align: 'center'

        },
        {
            field: 'mobile',
            title: '手机号',
            align: 'center'
        },
        {
            field: 'wechat',
            title: '微信号',
            align: 'center'

        },
        {
            field: 'status',
            title: '状态',
            align: 'center',
            formatter: function (value, row, index) {
                if (value === '1') return '<span class="badge badge-success">有效</span>';
                if (value === '0') return '<span class="badge badge-warning">锁定</span>';
            }
        },
        {
            field: 'remark',
            title: '备注',
            align: 'center'
        }
    ],

    onLoadSuccess: function () {
        //加载成功时执行
        console.log("加载成功!");
    }, onLoadError: function () {
        //加载失败时执行
        layer.msg("加载失败!", {icon: 2, time: 2000});
    }, formatLoadingMessage: function () {
        //正在加载
        return "请稍等，正在加载中...";
    }, formatNoMatches: function () {
        //没有匹配的结果
        return '无符合条件的记录';
    }
})
//刷新页面
function refresh() {
    $("#table").bootstrapTable('refresh');
}

//查询按钮点击事件
$("#btn_search").on("click", function () {
    refresh();
});

function deleteUsers() {
    var selected = $.map($("#table").bootstrapTable('getSelections'), function (row) {
        return row;
    });
    var selected_length = selected.length;
    var contain = false;
    if (!selected_length) {
        layer.alert('请勾选需要删除的用户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].id;
        if (i !== (selected_length - 1)) ids += ",";
    }
    layer.confirm('您确定要删除选中用户吗?', {btn: ['确定', '取消'], title: "提示"}, function () {
        $.post( 'user/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                layer.msg("删除成功", {icon: 1});
                refresh();
            } else {
                layer.msg("删除失败", {icon: 2});
            }
        });
    });
}

function exportUserExcel() {
    $.post( "user/excel", function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            layer.msg(r.msg);
        }
    });
}




