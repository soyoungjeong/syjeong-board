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
    <table class="table table-hover">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th style="width:10%">작성일</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>안녕하세요</td>
                <td>정소영</td>
                <td>2018.12.03</td>
            </tr>

            <tr>
                <td>2</td>
                <td>안녕하세요</td>
                <td>정소영</td>
                <td>2018.12.03</td>
            </tr>

            <tr>
                <td>3</td>
                <td>안녕하세요</td>
                <td>정소영</td>
                <td>2018.12.03</td>
            </tr>
        </tbody>
    </table>

    <input type="button" class="btn btn-default pull-right" value="글쓰기">
</div>

<script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
</body>
</html>