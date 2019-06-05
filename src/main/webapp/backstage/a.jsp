<%@page isELIgnored="false"  contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HomePage</title>
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
    <script type="application/javascript">
        $(function () {
          $("#a").jqGrid({
              colNames:["id","标题"],
              cellEdit:false,                         //设置表格可编辑
              pager:"#aper",
              autowidth:true,                      //自适应度表格宽度
              editurl:"${pageContext.request.contextPath}/Album/edit",//增删改的URL
              url:"${pageContext.request.contextPath}/backstage/a.json",//加载数据的url
              datatype:"json",//url返回值类型
              styleUI: 'Bootstrap',
              colModel:[
                  {name:"id",align:"center",resizable:false},
                  {name:"name",align:"center",resizable:false,editable:true,edittype:"text"},
              ]
          }).jqGrid("navGrid","#aper")
        })
    </script>
</head>
<body>
<div id="aper"></div>
    <table id="a">
    </table>
</body>
</html>
