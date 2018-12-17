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
        .container{width:600px;}
        input {margin:5px;}
    </style>
</head>
<body>
<#include "../header.ftl">
<div class="container">
    <form action="" method="post">
    <table class="table">
        <tr>
            <th class="info" width="100px">제목</th>
            <td colspan="3" class="title">${detail.title}</td>
        </tr>
        <tr>
            <th class="info" width="100px">작성자</th>
            <td width="200px"></td>
            <th class="info" width="100px">작성일</th>
            <td calss="date" width="200px">${detail.date}</td>
        </tr>
        <tr>
            <td colspan="4" height="400px">${detail.content}</td>
        </tr>

    </table>
        <input type="hidden" name="index" value="${detail.index}">
        <input type="button" id="delete" class="btn btn-default pull-right" onclick="location.href='/board/delete/${detail.index}'" value="삭제">
        <input type="submit" class="btn btn-default pull-right" value="수정">
        <input type="button" class="btn btn-default pull-right" onclick="location.href='/board/list'" value="목록">
    </form>
    <script>
        $(document).ready(function(){
            $("#delete").on("click", function() {
                alert("정말 삭제하시겠습니까?");
            })
        })

    </script>
<script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
</body>
</html>