<%@page isELIgnored="false"  contentType="text/html; UTF-8" pageEncoding="UTF-8" %>

    <script type="application/javascript">
        $.ajax({
            type:"post",
            url:"/User/selectUserMonth",
            dataType:"json",
            success:function (data) {
                myChart.setOption({
                    xAxis: {
                    data:data.name
                      },
                        series: [{
                            name: '用户月份走势图',
                            type: 'line',
                            data:data.value
                        }]
                    }
                )
            }
        })

    </script>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['用户月份走势图']
        },
        xAxis: {
            data: ["1","2","3","4","5","6","7","8","9","10","11","12"]
        },
        yAxis: {}
    };
    myChart.setOption(option);
</script>
