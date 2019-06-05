<%@page isELIgnored="false"  contentType="text/html; UTF-8" pageEncoding="UTF-8" %>

<script type="application/javascript">
    //删除轮播图
    function remove(object){
        var gr=$("#ArticleTable").jqGrid('getGridParam',"selrow");
        if(gr!=null)
            $("#ArticleTable").jqGrid("delGridRow",gr,{
                reloadAfterSubmit:false
            });
        else
            alert("请选择删除行！")

    }
    /**
     * //修改文章方法* function update(){
     *   var gr=$("#ArticleTable").jqGrid('getGridParam',"selrow");
     *   if(gr!=null)
     *         $("#ArticleTable").jqGrid("editGridRow",gr,{
     *             height:300,
     *              reloadAfterSubmit:false,
              closeAfterEdit:true
     *
     *
     *
     *       });
        else
            alert("请选择修改行！")
            }
        */




    $(function () {
        KindEditor.create('#editor_id',{
            uploadJson:"${pageContext.request.contextPath}/KindEditor/upload",
            filePostName:"img",
            allowFileManager:true,
            resizeType:0,
            afterBlur:function () {
                //把当前textarea 加上他后台能接收到 input框name为content 的值 不然接收不到
                this.sync()
            },
            fileManagerJson:"${pageContext.request.contextPath}/KindEditor/getAll"
        });
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/Article/select",
            dataType:"html",
            success:function (data) {
                $("#author").html(data);
            }
        })

        /*文章列表*/
        $("#ArticleTable").jqGrid({
            colNames:["id","状态","标题","作者","内容","创建时间","上师ID","操作"],
            page:1,
            rowNum:5,
            rowList:[1,5,10,15,30],
            cellEdit:false,                         //设置表格可编辑
            pager:"#ArticlePaper",                    //分页
            autowidth:true,                      //自适应度表格宽度
            editurl:"${pageContext.request.contextPath}/Article/edit",//增删改的URL
            multiselect:true,//支持多选框
            viewrecords:true,//显示数据总条数
            url:"${pageContext.request.contextPath}/Article/queryPaging",//加载数据的url
            datatype:"json",//url返回值类型
            styleUI: 'Bootstrap',
            colModel:[
                {name:"id",align:"center",resizable:false},
                {name:"status",align:"center",resizable:false,editable:true,edittype:"select",
                    formatter:function (cellvalue,options,rowsObject) {
                       if(cellvalue==1){
                      return "展示";
                       }
                       return "不展示";
                    },
                    editoptions:{
                    dataUrl:"${pageContext.request.contextPath}/WheelPlanting/select"
                    }
                },
                {name:"title",align:"center",resizable:false,editable:true,edittype:"text"},
                {name:"author",align:"center",resizable:false,edittype:"select",editable:true,
                    editoptions:{dataUrl:"${pageContext.request.contextPath}/Article/select"}
                },
                {name:"content",hidden:true},
                {name:"createDate",align:"center",resizable:false,edittype:"date"},
                {name:"guRuId",hidden:true},

                {name:"optios",
                    formatter:function (cellvalue,options,rowsObject) {
                        return"<a href='javascript:void(0)' class='btn btn-danger glyphicon glyphicon-remove' onclick='remove()'>删除</a>"+
                       "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                       "<a href='javascript:void(0)'  class='btn btn-warning glyphicon glyphicon-pencil' onclick=\"update('"+rowsObject.id+"')\">查看详情</a>"
                    }
                }
            ]
        }).jqGrid("navGrid","#ArticlePaper",
            //设置分页左边的图标增删改
            {search:false,add:false,edit:false,deltext:"批量删除"},
            //第一个框框修改
            {
                closeAfterEdit:true
            },{
                closeAfterAdd:true
            }
        )
    })
    /*  $("#ArticleTable").jqGrid('editGridRow',"new",{
          height:400,
          reloadAfterSubmit:true,
          closeAfterAdd:true
      });*/
    //修改信息
    function updateSubmit(id) {
        $("#id").val(id);
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/Article/edit?oper=edit",
            data:$("#addArticleForm").serialize(),
            dataType:"json",
            success:function () {
            }
        })
        $("#addArticlem").modal("hide");
        $("#ArticleTable").trigger("reloadGrid");
        
    }
    
    
    //查看详情
    function  update(id){
      /*  $.ajax({
            type:"post",
            url:"。这是是EL表达式{pageContext.request.contextPath}/Article/selectOneArticle",
            dataType:"json",
            data:{id:id},
            success:function (data) {
                $("#title").val(data.title);
                $("#status").val(data.status);
                $("#select").val(data.guRuId);
                KindEditor.html("#editor_id",data.content)
                $("#addArticlem").modal("show");
                $("#footer").html("<button type='button' class='btn btn-success' onclick=\"updateSubmit('"+data.id+"');\">修改</button>"+
                    " <button type='button' class='btn btn-warning' data-dismiss='modal'>取消</button>");
            }
        })*/
        var value= $("#ArticleTable").jqGrid("getRowData",id);
        $("#title").val(value.title);
        if(value.status=='展示'){
            $("#status").val(1);
        }else{
            $("#status").val(2);
        }
        $("#select").val(value.guRuId);
        KindEditor.html("#editor_id",value.content)
        $("#addArticlem").modal("show");
        $("#footer").html("<button type='button' class='btn btn-success' onclick=\"updateSubmit('"+value.id+"');\">修改</button>"+
            " <button type='button' class='btn btn-warning' data-dismiss='modal'>取消</button>")
    }
    //添加文章
    $("#addArticle").click(function () {
        $("#addArticlem").modal("show");
        $("#addArticleForm")[0].reset();
        KindEditor.html("#editor_id","");
        $("#footer").html("<button type='button' class='btn btn-success' onclick=\"addArticle();\">保存</button>"+
            " <button type='button' class='btn btn-warning' data-dismiss='modal'>取消</button>")

    });
            function addArticle() {
                $.ajax({
                    type:"post",
                    url:"${pageContext.request.contextPath}/Article/edit",
                    data:$("#addArticleForm").serialize(),
                    dataType:"json",
                    success:function () {
                    }
                })
                $("#addArticlem").modal("hide");
                $("#ArticleTable").trigger("reloadGrid");
            }
</script>
<div class="modal fade  bs-example-modal-lg" id="addArticlem"  role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加文章</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addArticleForm">
                    <input id="id" name="id" type="text" style="display: none"/>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-10">
                            <select class="form-control"  name="status" id="status">
                                <option value="1">展示</option>
                                <option value="2">不展示</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">标题</label>
                        <div class="col-sm-10">
                            <input class="form-control" name="title" id="title" placeholder="标题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">作者</label>
                        <div class="col-sm-10" id="author">

                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-10">
                        <textarea id="editor_id" name="content"  style="height: 300px;width: 700px">
                        </textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer" id="footer">

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<div class="col-md-10">
<div class="page-header">
    <h1>
        文章列表
    </h1>
</div>
    <ul class="nav nav-tabs">
        <li role="presentation"  class="active"><a href="#">文章表 </a></li>
        <li role="presentation"  ><a href="javascript:void(0);" type="button"  id="addArticle">添加文章</a></li>
    </ul>
    <table id="ArticleTable">
        <div id="ArticlePaper" style="height: 50px"></div>
    </table>
</div>
