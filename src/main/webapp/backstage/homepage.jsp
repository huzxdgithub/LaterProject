<%@page isELIgnored="false"  contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HomePage</title>
    <script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/lang/zh-CN.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" />
    <meta name="viewport"  content="width=device-width, initial-scale=1">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/bootstrap.css">
    <script  src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/boot/js/bootstrap.min.js"></script>
    <!--引入jqgrid-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jqgrid/css/css/cupertino/jquery-ui-1.8.16.custom.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jqgrid/jqGrid_BootStrap/css/trirand/ui.jqgrid-bootstrap.css"/>
    <script src="${pageContext.request.contextPath}/jqgrid/jqGrid_BootStrap/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="${pageContext.request.contextPath}/jqgrid/js/i18n/grid.locale-cn.js"></script>
    <script src="${pageContext.request.contextPath}/boot/js/ajaxfileupload.js"></script>

    <script src="${pageContext.request.contextPath}/echarts/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/echarts/china.js"></script>
    <script type="application/javascript">
        $(function () {
            $("#logout").click(function () {
                $.ajax({
                    type:"GET",
                    url:"${pageContext.request.contextPath}/Admin/logout",
                    success:function () {
                        location.href="${pageContext.request.contextPath}/login/login.jsp";
                    }
                })
            })
        })
    </script>
</head>
<body>
    <%--导航条--%>
    <div class="container-fluid ">
        <nav class="navbar navbar-default">
            <div class="container-fluid" >
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">持名法州管理系统</a>
                </div>
                <div  class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">欢迎<span class="text-primary">:<shiro:principal></shiro:principal></span></a></li>
                        <li><a  href="javascript:void(0);" id="logout">退出登陆&nbsp;<span class="glyphicon glyphicon-log-out"></span></a>
                       </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>


    <div class="container-fluid">
        <div class="row">
            <%--手风琴--%>
            <div class="col-md-2">
                <div class="panel-group" id="accordion" >
                    <shiro:hasRole name="super">
                        <div class="panel panel-default">
                            <div class="panel-heading" >
                                <h3 class="panel-title">
                                    <a  role="button" data-toggle="collapse" href="#collapseOne" data-parent="#accordion" >
                                        用户管理
                                    </a>
                                </h3>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" >
                                <div class="panel-body">
                                    <ul class="nav nav-pills">
                                        <li role="presentation" ><a href="javascript:$('#homepage').load('User.jsp')">用户列表</a></li>

                                    </ul>
                                    <ul class="nav nav-pills">
                                        <li role="presentation" ><a href="javascript:$('#homepage').load('userEcharts.jsp')">用户图表</a></li>
                                    </ul>
                                    <ul class="nav nav-pills">
                                        <li role="presentation" ><a href="javascript:$('#homepage').load('userMap.jsp')">用户地区分布图</a></li>
                                    </ul>
                                    <ul class="nav nav-pills">
                                        <li role="presentation" ><a href="javascript:$('#homepage').load('userEcharts1.jsp')">用户月走势图</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </shiro:hasRole>
                    <div class="panel panel-default" >
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <a href="#guru" role="button" data-toggle="collapse" data-parent="#accordion" >上师管理</a>
                            </h3>
                        </div>
                        <div id="guru" class="panel-collapse collapse" >
                            <div class="panel-body">
                                <ul class="nav nav-pills">
                                    <li role="presentation"><a href="javascript:$('#homepage').load('GuRu.jsp')">上师列表</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title">
                                <a href="#Article" role="button" data-toggle="collapse" data-parent="#accordion" >文章管理</a>
                            </div>
                        </div>
                        <div id="Article" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul class="nav nav-pills">
                                    <li ><a href="javascript:$('#homepage').load('Article.jsp')">文章列表</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title">
                                <a href="#Album"  data-toggle="collapse" data-parent="#accordion" >专辑管理</a>
                            </div>
                        </div>
                        <div class="panel-collapse collapse" id="Album">
                            <div class="panel-body">
                                <ul class="nav nav-pills">
                                    <li><a href="javascript:$('#homepage').load('Album.jsp')" >专辑列表</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title">
                                <a href="#RotationChart" data-toggle="collapse" data-parent="#accordion" >轮播图管理</a>
                        </div>
                        <div class="panel-collapse collapse" id="RotationChart">
                            <div class="panel-body">
                                <ul class="nav nav-pills">
                                    <li><a href="javascript:$('#homepage').load('WheelPlanting.jsp')" >轮播图列表</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
                <%--首页--%>
            <div class="col-md-10" id="homepage">
                <div class="jumbotron" >
                    <h3>欢迎来到持名法州后台管理系统</h3>
                </div>
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="${pageContext.request.contextPath}/img/shouye.jpg" alt="..." style="width: 100%">
                            <div class="carousel-caption">
                                ...
                            </div>
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/img/shouye.jpg" alt="..." style="width: 100%"  >
                        </div>

                    </div>
                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
        <br/>
            <%--页脚--%>
        <div class="panel panel-default">
            <div class="panel-footer" style="text-align: center">@持名法州</div>
        </div>
    </div>
</body>
</html>
