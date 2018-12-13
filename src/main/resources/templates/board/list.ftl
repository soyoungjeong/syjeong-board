<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport">
    <title>list</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css" />

    <style>
        table {margin-top:200px;}
        .container {width:600px;}
    </style>
</head>
<body>
<div class="container">
    <form action="/board/write" method="get">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th style="width:20%">작성일</th>
        </tr>
        </thead>
            <#list result as item>
            <tr onclick="location.href='/board/view/${item.index}'">
                <td>${item.index}</td>
                <td>${item.title}</td>
                <td>정소영</td>
                <td>${item.date}</td>
            </tr>
            </#list>
    </table>

        <button type="submit" class="btn btn-default pull-right">글쓰기</button>
    </form>
</div>

<script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
</body>
</html>