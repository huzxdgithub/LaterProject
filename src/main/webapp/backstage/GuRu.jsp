<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<script >
$(function () {
    $("#GuruTable").jqGrid({
        colNames:["id","上师名称","图像","状态","创建时间"],
        page:1,
        rowNum:5,
        rowList:[1,5,10,15,30],
        cellEdit:false,                         //设置表格可编辑
        pager:"#GuruPager",                    //分页
        autowidth:true,                      //自适应度表格宽度
        editurl:"${pageContext.request.contextPath}/GuRu/edit",//增删改的URL
        multiselect:true,//支持多选框
        viewrecords:true,//显示数据总条数
        url:"${pageContext.request.contextPath}/GuRu/queryPaging",//加载数据的url
        datatype:"json",//url返回值类型
        styleUI: 'Bootstrap',
        colModel:[
            {name:"id",align:"center",resizable:false},
            {name:"guRuName",align:"center",resizable:false,editable:true,edittype:"text"},
            {name:"picturePath",align:"center",resizable:false,edittype:"file",editable:true,
                formatter:function(cellvalue,options,rowObject){
                    return "<img src='${pageContext.request.contextPath}/projectimg/audioCollection/"+rowObject.picturePath+"' width='40px' height='40px'></img>"
                }
            },
            {name:"status",align:"center",resizable:false,editable:true,edittype:"select",
                editoptions:{dataUrl:"/WheelPlanting/select"},
                formatter:function(cellvalue,options,rowObject){
                    if(cellvalue==1){
                        return"展示"
                    }
                return "不展示";
                }
            },
            {name:"createDate",align:"center",resizable:false,edittype:"date"}
        ]
    }).jqGrid("navGrid","#GuruPager",
        //设置分页左边的图标增删改
        {search:false,addtext:"添加",edittext:"修改",deltext:"删除"},
        //第一个框框修改
        {
            //修改
            closeAfterEdit:true,
            afterSubmit:function (response) {
                var id=response.responseText;
                if(id!=""){
                    $.ajaxFileUpload({
                        type:"post",
                        url:"${pageContext.request.contextPath}/GuRu/upload",
                        data:{id:id},
                        fileElementId:"picturePath",
                        success:function () {
                            $("#GuruTable").trigger("reloadGrid");
                        }
                    })
                }
                return response;
            }
        },{
        //添加
            closeAfterAdd:true,
            afterSubmit:function (response) {
                var id=response.responseText;
                $.ajaxFileUpload({
                    type:"url",
                    url:"${pageContext.request.contextPath}/GuRu/upload",
                    fileElementId:"picturePath",
                    data:{id:id},
                    success:function () {
                        $("#GuruTable").trigger("reloadGrid");
                    }
                })
                return response;
            }
        },
        {

        }
    )
})
</script>
<div class="col-md-10">
    <div class="page-header">
        <h1>上师列表</h1>
    </div>
    <ul class="nav nav-tabs">
        <li role="presentation"  class="active"><a href="#">上师表 </a></li>
    </ul>
    <table id="GuruTable">
        <div id="GuruPager"></div>
    </table>
</div>