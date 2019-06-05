<%@page isELIgnored="false"  contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<script>

    $(function () {
        /*专辑列表*/
            $("#AlbumTable").jqGrid({
                colNames:["id","标题","评分","作者","播音员","集数","内容简介","创建时间","图片"],
                page:1,
                rowNum:5,
                rowList:[1,5,10,15,30],
                cellEdit:false,                         //设置表格可编辑
                pager:"#AlbumPaper",                    //分页
                autowidth:true,                      //自适应度表格宽度
                editurl:"${pageContext.request.contextPath}/Album/edit",//增删改的URL
                multiselect:true,//支持多选框
                viewrecords:true,//显示数据总条数
                url:"${pageContext.request.contextPath}/Album/queryPaging",//加载数据的url
                datatype:"json",//url返回值类型
                styleUI: 'Bootstrap',
                subGrid:true,
                subGridRowExpanded:function(subGridId,albumId){
                    addSubGrid(subGridId,albumId);
                },
                colModel:[
                    {name:"id",align:"center",resizable:false},
                    {name:"title",align:"center",resizable:false,editable:true,edittype:"text"},
                    {name:"score",align:"center",resizable:false,editable:true,edittype:"text"},
                    {name:"author",align:"center",resizable:false,editable:true,edittype:"text"},
                    {name:"broadcast",align:"center",resizable:false,editable:true,edittype:"text"},
                    {name:"count",align:"center",resizable:false,editable:true,edittype:"text"},
                    {name:"brief",align:"center",resizable:false,editable:true,edittype:"text"},
                    {name:"createDate",align:"center",resizable:false,edittype:"date"},
                    {name:"picturePath",align:"center",resizable:false,editable:true,edittype:"file",
                        formatter:function (cellvalue,options,rowsObject) {
                            return "<img src=${pageContext.request.contextPath}/projectimg/audioCollection/"+rowsObject.picturePath+" width=40px height=40px></img>";

                    }
                    }
                ]
            }).jqGrid("navGrid","#AlbumPaper",
                {addtext:"添加",deltext:"删除",edittext:"修改",search:false},
                {
                    //修改
                    closeAfterEdit:true,
                    afterSubmit:function(response){
                        //这里是修改完毕返回的值 根据值上传文件和修改图片路径
                        var id=  response.responseText;
                        if(id!=""){
                            $.ajaxFileUpload({
                                type:"post",
                                url:"${pageContext.request.contextPath}/Album/upload",
                                fileElementId:"picturePath",
                                data:{id:id},
                                success:function(){
                                    //设置提示框
                                    $("#AlbumTable").trigger("reloadGrid");
                                    $("#updateWarningBox").show();
                                    setTimeout(function () {
                                        $("#updateWarningBox").hide()
                                    },3000)
                                }
                            })
                         }
                        return response;
                    }
                },
                {
                    //添加
                    closeAfterAdd:true,
                    afterSubmit:function(response){
                        //response返回值
                        var id =  response.responseText;
                            if(id!=""){
                            $.ajaxFileUpload({
                                type:"post",
                                url:"${pageContext.request.contextPath}/Album/upload",
                                fileElementId:"picturePath",
                                dataType:"text",
                                data:{id:id},
                                success:function(){
                                    //根据返回值提示用户是成功或者失败
                                    if(id==""){
                                        $("#addWarningBox").prop("class","alert alert-danger")
                                        $("#addWarningBox").text("添加失败")
                                    }else{
                                        $("#AlbumTable").trigger("reloadGrid");
                                        $("#addWarningBox").prop("class","alert alert-success")
                                    }
                                    $("#addWarningBox").show();
                                    setTimeout(function () {
                                        $("#addWarningBox").hide();
                                    },3000);
                                }
                            })
                             }
                    return response;
                    }
                },
                {
                    //删除
                }
                )
    })
    /*子表格*/
    function addSubGrid(subGridId,albumId) {
        var subGridTableId= subGridId+"table";
        var subGridPagerId= subGridId+"pager";
        $("#"+subGridId).html(
            " <table id="+subGridTableId+">" +
            " <div style=\"height: 50px\" id=" + subGridPagerId + " ></div>" +
            " </table>"
        );
        $("#"+subGridTableId).jqGrid({
            colNames:["id","标题","大小","时长","创建时间","音频","操作"],
            page:1,
            rowNum:5,
            rowList:[1,5,10,15,30],
            cellEdit:false,                         //设置表格可编辑
            pager:"#"+subGridPagerId,                    //分页
            autowidth:true,                      //自适应度表格宽度
            editurl:"${pageContext.request.contextPath}/Chapter/edit?albumId="+albumId,//增删改的URL
            multiselect:true,//支持多选框
            viewrecords:true,//显示数据总条数
            url:"${pageContext.request.contextPath}/Chapter/queryPaging?id="+albumId,//加载数据的url
            datatype:"json",//url返回值类型
            styleUI: 'Bootstrap',
            colModel:[
                {name:"id",align:"center",resizable:false},
                {name:"title",align:"center",resizable:false,editable:true,edittype:"text"},
                {name:"size",align:"center",resizable:false,edittype:"text"},
                {name:"duration",align:"center",resizable:false,edittype:"text"},
                {name:"createDate",align:"center",resizable:false,edittype:"text"},
                {name:"audioFrequency",align:"center",resizable:false,editable:true,edittype:"file"},
                {name:"albumId",
                    formatter:function (cellvalue,options,rowsObject) {
                        return"<a href='#' onclick=\"playAudio('"+rowsObject.audioFrequency+"')\" class='glyphicon glyphicon-play-circle' >播放</a>" +
                            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a href='/Chapter/downLoad?filename="+rowsObject.audioFrequency+"'  class='glyphicon glyphicon-download'>下载</a>"
                    }
                }
            ]

        }).jqGrid("navGrid","#"+subGridPagerId,{addtext:"添加",deltext:"删除",edittext:"修改",search:false},
            {
                //修改
                closeAfterEdit:true,
                afterSubmit:function(response){
                    //这里是修改完毕返回的值 根据值上传文件和修改图片路径
                    var id=  response.responseText;
                    //根据返回值判断是否为""如果为空说明用户修改的时候没有做上传就不用上传这一步操作了
                    if(id!=""){
                        $.ajaxFileUpload({
                            type:"post",
                            url:"${pageContext.request.contextPath}/Chapter/upload",
                            fileElementId:"audioFrequency",
                            data:{id:id},
                            success:function(){
                                //设置提示框
                                $("#"+subGridTableId).trigger("reloadGrid");
                                $("#updateWarningBox").show();
                                setTimeout(function () {
                                    $("#updateWarningBox").hide()
                                },3000)
                            }
                        })
                    }
                    return response;
                }
            },
            {
                //添加
                closeAfterAdd:true,
                afterSubmit:function(response){
                    var id=response.responseText;
                    if(id!=""){
                    $.ajaxFileUpload({
                        type:"post",
                        url:"${pageContext.request.contextPath}/Chapter/upload",
                        fileElementId:"audioFrequency",
                        data:{id:id},
                        success:function () {
                            if(id==""){
                                $("#addWarningBox").prop("class","alert alert-danger")
                                $("#addWarningBox").text("添加失败")
                            }else{
                                $("#"+subGridTableId).trigger("reloadGrid");
                                $("#addWarningBox").text("添加成功")
                                $("#addWarningBox").prop("class","alert alert-success")
                            }
                            $("#addWarningBox").show();
                            setTimeout(function () {
                                $("#addWarningBox").hide();
                            },3000);
                        }
                    })
                    }
                    return response;
                }
            },
            {
                //删除
            })
    }
    //在线播放
    function playAudio(cellvalue){
        $("#playAudio").modal("show");
        $("#audio").prop("src","${pageContext.request.contextPath}/audiofrequency/"+cellvalue);
    }


</script>
<%--在线播放模态框   最主要标签audio 属性controls--%>
<div id="playAudio" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">音乐播放</h4>
            </div>
            <div class="modal-body">
            <audio id="audio"  src="" controls></audio>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<%--专辑列表--%>
<div class="col-md-10" >
    <div class="page-header">
        <h1>专辑列表管理</h1>
    </div>
    <ul class="nav nav-tabs">
        <li role="presentation"  class="active"><a href="#">专辑表 </a></li>
        </li>
    </ul>
    <table id="AlbumTable">
        <div id="AlbumPaper" style="height: 50px"></div>
    </table>
    <div id="addWarningBox" class="alert alert-success" role="alert" style="display: none">添加成功</div>
</div>