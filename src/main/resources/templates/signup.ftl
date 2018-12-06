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

    </style>
</head>
<body>

    <div class="container">
            <div id="signup_box" class="col-md-3">
                <div class="signup-box well">
                <form role="signup" class="signup" method="post" action="/login" th:object="${userform}">
                    <legend>회원가입</legend>
                    <div class="form-group">
                        <label for="email">E-mail</label>
                        <input type="text" class="form-control" id="email" placeholder=""><br />
                    </div>
                    <div class="form-group">
                        <label for="nick">Nickname</label>
                        <input type="text" class="form-control" id="nickname" placeholder="" ><br />
                    </div>
                    <div class="form-group">
                        <label for="id">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Password"><br />
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-default btn-signup-submit btn-block m-t-md" value="Sign up" />
                    </div>
                </form>
                </div>
            </div>
    </div>

    <script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
</body>
</html>