<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>signup</title>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css" />
    <style>
        .container {margin-top:200px;}
        .col-md-3 {display:table; width:400px; height:100%; position:relative; left:350px;}
        .signup-box well {display:table-cell; text-align: center;}
        .text-center {position:relative; left:120px;}
    </style>
</head>
<body>

    <div class="container">
            <div id="signup_box" class="col-md-3">
                <div class="signup-box well">
                <form role="signup" class="signup" method="post" action="/signup-proc">
                    <legend>회원가입</legend>
                    <div class="form-group">
                        <label for="email">E-mail</label>
                        <input type="text" class="form-control" id="email" name="email" placeholder=""><br />
                    </div>
                    <div class="form-group">
                        <label for="nick">Nickname</label>
                        <input type="text" class="form-control" id="nickname" name="nickname" placeholder="" ><br />
                    </div>
                    <div class="form-group">
                        <label for="id">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password"><br />
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-default btn-signup-submit btn-block m-t-md" value="Sign up" />
                    </div>
                    <span class="text-center"><a href="/login" class="text-sm">로그인 하러가기</a></span>
                </form>
                </div>
            </div>
    </div>

    <script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
</body>
</html>