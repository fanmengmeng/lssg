/**
 * Created by zxk175 on 16/12/2.
 */

var $table = $('#table');

//bootstrapTable使用中文
$.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']);

//防止表头与表格不对齐
$(window).resize(function () {
    $table.bootstrapTable('resetView');
});

$(function () {

    tableInit();
})

//初始化Table
function tableInit() {
    //先销毁表格
    $table.bootstrapTable('destroy');

    $table.bootstrapTable({
        //请求地址
        method : "post", //get方式提交 
        //contentType : "application/x-www-form-urlencoded; charset=UTF-8" ,
        url : "/info/list", //获取数据  
        //请求内容类型
        async : true,
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        //数据类型
        dataType: "json",
        //table高度，
        //如果没有设置height属性，
        //表格自动根据记录条数觉得表格高度
        //height: '600',
        //是否显示行间隔色
        striped: true,
        //是否启用排序
        sortable: false,
        //排序方式
        sortOrder: "asc",
        //是否使用缓存
        cache: false,
        //每行的唯一标识
        uniqueId: "id",
        //指定工具栏
        toolbar: "#toolbar",
        //显示隐藏列
        showColumns: true,
        //显示刷新按钮
        showRefresh: false,
        //切换显示样式
        showToggle: false,
        //显示Table脚部
        showFooter: false,
        //是否显示详细视图
        cardView: false,
        //是否显示父子表
        detailView: false,
        //detail格式化
        detailFormatter: genderDetail,
        //是否显示分页
        pagination: true,
        //是否显示分页按钮
        showPaginationSwitch: false,
        //是否启用点击选中行
        clickToSelect: false,
        //最少要显示的列数
        minimumCountColumns: 2,
        //cell没有值时显示
        undefinedText: '-',
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
        iconsPrefix: 'glyphicon',
        queryParams: function queryParams(params) {
            var param = {
                pageNumber: this.pageNumber,
                pageSize: this.pageSize
            };
            return param;
        },
        icons: {
            paginationSwitchDown: 'glyphicon-collapse-down icon-chevron-down',
            paginationSwitchUp: 'glyphicon-collapse-up icon-chevron-up',
            refresh: 'glyphicon-refresh icon-refresh',
            toggle: 'glyphicon-list-alt icon-list-alt',
            columns: 'glyphicon-th icon-th',
            detailOpen: 'glyphicon-plus icon-plus',
            detailClose: 'glyphicon-minus icon-minus'
        },//数据返回成功进行的操作  
        columns: [
            {
                //field: 'Number',//可不加
                //title: 'Number',//标题  可不加
                width:20,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            },
            {
                checkbox: true
            },
            {
                field: 'name',
                title: '项目名称',
                align: 'center',
                cellStyle:{
                    css:{"color":"green"}
                }
            },
            {
                field: 'manager',
                title: '项目经理',
                align: 'center',

            },
            {
                field: 'address',
                title: '详细地址',
                align: 'center'

            },
            {
                field: 'area',
                title: '建筑面积',
                align: 'center'

            },
            {
                field: 'structuretype',
                title: '结构类型',
                align: 'center'
            }, {
                field: 'buildinglayers',
                title: '建筑层数',
                align: 'center'
            },
            {
                field: 'dealcost',
                title: '合同造价',
                align: 'center'

            },
            {
                field: 'startworkdate',
                title: '开工日期',
                align: 'center'
            },
            {
                field: 'completiondate',
                title: '竣工日期',
                align: 'center'
            },
            {
                field: 'longitude',
                title: '经度',
                align: 'center'
            },
            {
                field: 'latitude',
                title: '纬度',
                align: 'center'
            }
        ],
        paginationPreText: "上一页",
        paginationNextText: "下一页",

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
}

//生成详细视图
function genderDetail(index, row) {
    var html = [];
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    });
    return html.join('');
}

//生成序号
function genderIndex(value, row, index) {
    return index + 1;
}


//替换delete数据为文字
function genderDel(value, row, index) {
    if (value == null || value == undefined) {
        return "-";
    } else if (value == 1) {
        return "已删除";
    } else if (value == 0) {
        return "正常";
    }
}


/**dd
 *
 * 后台crud操作
 */

//刷新页面
function refresh() {
    $table.bootstrapTable('refresh');
}

//查询按钮点击事件
$("#btn_search").on("click", function () {
    refresh();
});

//删除按钮点击事件
$("#btn_delete").on("click", function () {
    var datas = $table.bootstrapTable('getSelections');
    if (datas.length < 1) {
        layer.alert('请选择一条或多条数据进行删除！', {icon: 2});
    } else {
        var id = [];
        for (var i = 0; i < datas.length; i++) {
            id.push(datas[i].id);
        }
        delData(id);
    }
});


function delData(id) {
    layer.confirm('确定要删除用户编号为' + id + '数据?', {icon: 3, title: '提示'}, function () {
        $.ajax({
            url: '/area/del',
            method: 'post',
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            //阻止深度序列化，向后台传送数组
            traditional: true,
            data: {id: id.toString()},
            success: function (msg) {
                if (msg.success) {
                    layer.msg(msg.msg, {icon: 1, time: 1500});
                } else {
                    layer.msg(msg.msg, {icon: 2, time: 1500});
                }
                refresh();
            }
        })
    });
}

