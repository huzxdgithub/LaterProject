<%@page isELIgnored="false"  contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/lang/zh-CN.js"></script>
    <script type="application/javascript">

        KindEditor.ready(function (K) {
            K.create('#editor_id',{
                uploadJson:"${pageContext.request.contextPath}/KindEditor/upload",
                filePostName:"img",
                allowFileManager:true,
                fileManagerJson:"${pageContext.request.contextPath}/KindEditor/getAll"
            });
        })
    </script>
</head>
<body>
<textarea id="editor_id" style="height: 500px;width: 1200px">
&lt; strong&gt;HTML内容&lt;/strong&gt;
</textarea>
</body>
</html>