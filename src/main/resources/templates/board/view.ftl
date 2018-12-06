<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport">
    <title>view</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css" />

    <style>
        table {margin-top:200px;}
        table tr th {text-align: center;}
        .container{width:700px;}
        input {margin:5px;}
    </style>
</head>
<body>
<div class="container">
    <table class="table">
        <tr>
            <th class="info" width="100px">제목</th>
            <td colspan="3" class="title"></td>
        </tr>
        <tr>
            <th class="info" width="100px">작성자</th>
            <td></td>
            <th class="info" width="100px">작성일</th>
            <td calss="date"></td>
        </tr>

        <tr>
            <td colspan="4" height="400px"></td>
        </tr>

    </table>
    <input type="button" class="btn btn-default pull-right" value="삭제">
    <input type="button" class="btn btn-default pull-right" value="수정">
    <input type="button" class="btn btn-default pull-right" value="목록">
</div>
<script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
</body>
</html>