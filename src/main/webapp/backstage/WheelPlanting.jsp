<%@page isELIgnored="false"  contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<script>
    //删除轮播图
    function remove(){
        var gr=$("#whellplanting").jqGrid('getGridParam',"selrow");
        if(gr!=null){
            $("#whellplanting").jqGrid('delGridRow', gr, {
                reloadAfterSubmit : false ,
            })
        }
        else
            alert("请选择修改行！")
    }
    //修改轮播图方法
    function update(){
        var gr=$("#whellplanting").jqGrid('getGridParam',"selrow");
        if(gr!=null)
            $("#whellplanting").jqGrid("editGridRow",gr,{
                height:400,
                reloadAfterSubmit:false,

            });
        else
            alert("请选择修改行！")
    }
    $(function () {
        /*轮播图列表*/
            $("#whellplanting").jqGrid({
                colNames:["id","标题","图片","状态","创建时间","描述","操作"],//列名称
                cellEdit:false,                         //设置表格可编辑
                pager:"#paper",                      //分页
                rowNum:5,                            //每页展示条数
                page:1,                             //默认第几页
                rowList:[5,10,15,20],               //下拉框选择每页展示条数
                autowidth:true,                      //自适应度表格宽度
                editurl:"${pageContext.request.contextPath}/WheelPlanting/edit",//增删改的URL
                multiselect:true,//支持多选框
                viewrecords:true,//显示数据总条数
                url:"${pageContext.request.contextPath}/WheelPlanting/queryWheelPlanting",//加载数据的url
                datatype:"json",//url返回值类型
                styleUI: 'Bootstrap',
                colModel:[
                    {name:"id",align:"center"},
                    {name:"title",align:"center",resizable:false,editable:true,edittype:"text"},
                    {name:"picturePath",align:"center",resizable:false,editable:true,edittype:"file",
                        formatter:function(cellvalue,options,rowsObject){
                            return "<img src=${pageContext.request.contextPath}/projectimg/audioCollection/"+rowsObject.picturePath+" width=40px height=40px></img>";
                        }
                    },
                    {name:"status",align:"center",resizable:false,editable:true,edittype:"select",
                        editoptions:{
                            dataUrl:"${pageContext.request.contextPath}/WheelPlanting/select"
                        },
                        formatter:function (cellvalue,options,rowsObject) {
                            if(cellvalue==1){
                                return "展示";
                            }
                            return "不展示";
                        }
                    },
                    {name:"createDate",align:"center",resizable:false,edittype:"date"},
                    {name:"description",align:"center",resizable:false,editable:true,edittype:"text"},
                    {name:"options",
                        formatter:function (cellvalue,options,rowsObject) {
                            return"<a class='btn btn-primary glyphicon glyphicon-piggy-bank' onclick='update()'>修改</a>"
                            +"<a class='btn btn-danger glyphicon glyphicon-piggy-bank' onclick='remove()'>删除</a>"
                        }
                    }
                ]
            }).jqGrid("navGrid","#paper",
                //设置分页右边图标 和文本
                {search:false,addtext:"添加",edittext:"修改",deltext:"删除"},
                {
                    //设置修改完毕是否关闭弹出框
                    closeAfterEdit:true,
                    afterSubmit:function(response){
                        //这里是修改完毕返回的值 根据值上传文件和修改图片路径
                        var id=  response.responseText;
                        $.ajaxFileUpload({
                            type:"post",
                            url:"${pageContext.request.contextPath}/WheelPlanting/upload",
                            fileElementId:"picturePath",
                            data:{id:id},
                            success:function(){
                                //设置提示框
                                $("#whellplanting").trigger("reloadGrid");
                                $("#updateWarningBox").show();
                                setTimeout(function () {
                                    $("#updateWarningBox").hide()
                                },3000)
                            }
                        })
                        return response;
                    }
                },
                {
                    //添加完毕是否关闭弹出框
                    closeAfterAdd:true,
                    afterSubmit:function(response){
                        //response返回值
                        var id =  response.responseText;
                        $.ajaxFileUpload({
                            type:"post",
                            url:"${pageContext.request.contextPath}/WheelPlanting/upload",
                            fileElementId:"picturePath",
                            dataType:"text",
                            data:{id:id},
                            success:function(){
                                //根据返回值提示用户是成功或者失败
                                if(id==""){
                                    $("#addWarningBox").prop("class","alert alert-danger")
                                    $("#addWarningBox").text("添加失败")
                                }else{
                                    $("#whellplanting").trigger("reloadGrid");
                                    $("#addWarningBox").prop("class","alert alert-success")
                                }
                                $("#addWarningBox").show();
                                setTimeout(function () {
                                    $("#addWarningBox").hide();
                                },3000);


                            }
                        })
                        return response;
                    }
                },
                {
                    //删除后弹出框            删除的返回值
                    afterComplete:function(response){
                        //这里可以做各种操作
                        $("#addWarningBox").text("删除成功");
                    }


                })

    });
</script>
<%--轮播图表格--%>
<div class="col-md-10"  >
    <div class="page-header">
        <h1>轮播图管理</h1>
    </div>
    <ul class="nav nav-tabs">
        <li role="presentation"  class="active "><a href="#">轮播表</a></li>
        </li>
    </ul>
    <table  id="whellplanting">
        <div id="paper" style="height: 50px"></div>
    </table>
    <div id="addWarningBox" class="alert alert-success" role="alert" style="display: none">添加成功</div>
    <div id="updateWarningBox" class="alert alert-success" role="alert" style="display: none">修改成功</div>
</div>