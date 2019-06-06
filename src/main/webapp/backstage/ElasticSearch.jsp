<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<script>
    $(function () {
        var term = '${param.term}';
        console.log(term);
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/Article/searchTitleAndContent",
            data: {term: term},
            dataType: "json",
            success: function (data) {
                console.log(data)
                $.each(data, function (idx, val) {
                    $("#elasticsearch").append('<div class="media">\n' +
                        '  <div class="media-left">\n' +
                        '    <a href="#">\n' +
                        '      <img class="media-object" width="40px"  src="${pageContext.request.contextPath}/projectimg/img/01.jpg" alt="...">\n' +
                        '    </a>\n' +
                        '  </div>\n' +
                        '  <div class="media-body">\n' +
                        '    <h4 class="media-heading">' + val.title + '</h4>\n' +
                        val.author + "<br/>" +
                        val.createDate + "<br/>" +
                        val.content + "<br/>" +
                        '  </div>\n' +
                        '</div>')
                })
            }
        })
    })
</script>
<div id="elasticsearch">

</div>