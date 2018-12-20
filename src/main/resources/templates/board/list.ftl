<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport">
    <title>list</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
    <style>
        .container {margin-top:200px; width:600px;}
        #write {margin-right:10px;}
    </style>
</head>
<body>
<#include "../header.ftl">
<div class="container">
    <form action="/board/check-delete" method="get">
        <h2><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>내가 쓴 글</h2><br/>
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
            <tr>
                <td><input type="checkbox" name="check" value="${item.index}">${item.index}</td>
                <td onclick="location.href='/board/view/${item.index}'">${item.title}</td>
                <td>${item.writer}</td>
                <td>${item.date}</td>
            </tr>
            </#list>
    </table>
        <input type="submit" id="delete" class="btn btn-default pull-right" value="삭제">
        <input type="button" id="write" class="btn btn-default pull-right" onclick="location.href='/board/write'" value="글쓰기">
    </form>
</div>
<script>
    $(document).ready(function(){
        $("#delete").on("click", function() {
            alert("정말 삭제하시겠습니까?");
        })
    })
</script>
</body>
</html>