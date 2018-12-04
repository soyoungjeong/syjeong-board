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
        <form method="post" class="write_form">
            <div class="form-group">
                <label for="subject">제목</label>
                <input type="text" class="form-control" id="subject" name="subject">
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea class="form-control" id="content" name="content" row="5"></textarea>
            </div>
            <button type="submit" class="btn-primary">작성</button>
        </form>

    </div>


<script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
</body>
</html>