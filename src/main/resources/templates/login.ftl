<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css" />
    <style>
        .container {margin-top:200px;}
        .col-md-3 {display:table; width:400px; height:100%; position:relative; left:350px;}
        .login-box well {display:table-cell; text-align: center;}
        .text-center {position:relative; left:120px;}

    </style>
</head>
<body>

<div class="container">
    <div id="login_box" class="col-md-3">
        <div class="login-box well">
            <form role="login" class="login" method="post">
                <legend>로그인</legend>
                <div class="form-group">
                    <label for="email">E-mail</label>
                    <input type="text" class="form-control" id="email" placeholder=""><br />
                </div>
                <div class="form-group">
                    <label for="id">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Password"><br />
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-default btn-login-submit btn-block m-t-md" value="log in" />
                </div>
                <span class="text-center"><a href="" class="text-sm">회원가입 하러가기</a></span>
            </form>
        </div>
    </div>
</div>

<script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
</body>
</html>