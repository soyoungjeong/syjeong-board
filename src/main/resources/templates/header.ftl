<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css"/>
</head>
<body>
    <nav class="navbar navbar-inverse">
        <a href="/board/list" class="navbar-brand">BOARD</a>
           <ul class="nav navbar-nav">
               <li class="active">
                   <a>${user.nickname}님이 로그인 중입니다.</a>
               </li>
               <li>
                   <a href="/logout">logout</a>
               </li>
           </ul>
    </nav>

    <script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
</body>
</html>