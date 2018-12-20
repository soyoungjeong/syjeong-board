<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport">
    <title>write</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
    <style>
        .container {width:600px; margin-top:200px;}
    </style>
</head>
<body>
<#include "../header.ftl">
    <div class="container">
        <form role="write" class="doc" name="writedoc" method="post">
            <h2><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>글쓰기</h2><br/>
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" class="form-control" id="title" name="title">
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea class="form-control" id="content" name="content" row="5"></textarea>
            </div>
            <input type="button" id="btnWrite" class="btn btn-default pull-right" value="작성" />
        </form>
    </div>
<script>
    $(document).ready(function () {
        $("#btnWrite").click(function () {
            var title = $("#title").val();
            var content = $("#content").val();
            if (title == "") {
                alert("제목을 입력하세요.");
                $("#title").focus();
                return;
            }
            if (content == "") {
                alert("내용을 입력하세요.");
                $("#content").focus();
                return;
            }
            document.writedoc.action = "/board/write-proc";
            document.writedoc.submit();
        });
    });
</script>
</body>
</html>