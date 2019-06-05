<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script>
    $(function () {
        $("#userTable").jqGrid({
            colNames:["id","手机号","密码","头像","法名","姓名","性别","省份","市区"],
            page:1,
            rowNum:5,
            rowList:[1,5,10,15,30],
            cellEdit:false,                         //设置表格可编辑
            pager:"#userPager",                    //分页
            autowidth:true,                      //自适应度表格宽度
          // editurl:"/GuRu/edit",//增删改的URL
            multiselect:true,//支持多选框
            viewrecords:true,//显示数据总条数
            url:"${pageContext.request.contextPath}/User/queryPaging",//加载数据的url
            datatype:"json",//url返回值类型
            styleUI: 'Bootstrap',
            colModel:[
                {name:"id",align:"center",resizable:false},
                {name:"phone",align:"center",resizable:false,editable:true,edittype:"text"},
                {name:"password",align:"center",resizable:false,editable:true,edittype:"text"},
                {name:"picturePath",align:"center",resizable:false,edittype:"file",editable:true,
                    formatter:function(cellvalue,options,rowObject){
                        return "<img src='${pageContext.request.contextPath}/projectimg/audioCollection/"+rowObject.picturePath+"' width='40px' height='40px'></img>"
                    }
                },
                {name:"legalName",align:"center",resizable:false,editable:true,edittype:"text"},
                {name:"name",align:"center",resizable:false,editable:true,edittype:"text"},
                {name:"sex",align:"center",resizable:false,editable:true,edittype:"text"},
                {name:"province",align:"center",resizable:false,editable:true,edittype:"text"},
                {name:"city",align:"center",resizable:false,editable:true,edittype:"text"},
            ]
        }).jqGrid("navGrid","#userPager",
            {add:false,search:false,del:false,edit:false}

            )
    })
    function Export() {
        location.href="${pageContext.request.contextPath}/User/Export";
       /* $.ajax({
            type:"post",
            url:"/User/Export",
            success:function () {

            }
        })*/
    }
</script>
<div class="col-md-10">
    <div class="page-header">
        <h1>用户管理</h1>
    </div>
    <ul class="nav nav-tabs">
        <li role="presentation"  class="active"><a href="#">用户表 </a></li>
        <li role="presentation"  ><a href="#" onclick="Export();">导出用户表 </a></li>
        <li role="presentation"  ><a href="#upload"  data-toggle="modal">导入用户表 </a> </li>
    </ul>
<table id="userTable">

<div id="userPager"></div>
</table>
</div>
<div class="modal fade" id="upload" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">导入xls文件</h4>
            </div>
            <form method="post" action="/User/upload" enctype="multipart/form-data" id="uploadUser">
            <div class="modal-body">
            <input type="file" name="file" id="file" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <input type="submit" class="btn btn-primary" value="导入"/>
            </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->