$(document).ready(function () {
    initMenu();
    electricityChart();
});

//加载初始化菜单
function initMenu() {
    $.ajax({
        type: 'get',
        dataType: "json",
        url: "menu/getUserMenu",
        data: {"userName": userName},
        success: function (res) {
            if (res.code === 0) {
                var data = res.msg;
                for (var i = 0; i < data.length; i++) {
                    $("#menu li a").append(data[i].menuName);
                }

            } else {
                layer.msg(res.msg);
            }
        }
    });
}

function electricityChart() {

    var myChart = echarts.init(document.getElementById('electricity'));
    myChart.setOption({
        title: {
            text: '用电走势'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['用电量', '碳排放量']
        },
        toolbox: {
            show: true,
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '用电量(kwh)',
                type: 'bar',
              /*  barWidth: 30,*/
                data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
                itemStyle: {
                    normal: {
                        color: '#1C86EE'
                    }
                },
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]

                }
            },
            {
                name: '碳排放量(kg)',
                type: 'bar',
            /*    barWidth: 30,*/
                data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
                itemStyle: {
                    normal: {
                        color: '#3CB371'
                    }
                },
                markPoint: {
                    data: [
                        {name: '年最高', value: 182.2, xAxis: 7, yAxis: 183},
                        {name: '年最低', value: 2.3, xAxis: 11, yAxis: 3}
                    ]
                }
            }
        ]
    });

}
