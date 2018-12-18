<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css"/>
    <script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
    <style>
        .container {
            margin-top: 200px;
        }

        .col-md-3 {
            display: table;
            width: 400px;
            height: 100%;
            position: relative;
            left: 350px;
        }

        .login-box well {
            display: table-cell;
            text-align: center;
        }

        .text-center {
            position: relative;
            left: 120px;
        }

        .btn{
            width:200px;
            text-align: center;
            position :relative;
            left:30px;
        }

    </style>
</head>
<body>
<div class="container">
    <div id="login_box" class="col-md-3">
        <div class="login-box well">
            <form class="form-horizontal" role="login" name="login" method="post">
                <legend>로그인</legend>
                <div class="form-group">
                    <label class="col-sm-1 col-xs-offset-1 control-label"><span class="glyphicon glyphicon-user"></span></label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" placeholder="Email"><br/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 col-xs-offset-1 control-label"><span class="glyphicon glyphicon-lock"></span></label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password"><br/>
                    </div>
                </div>
                <div class="btn">
                    <input type="button" id="btnLogin" class="btn btn-primary" value="Log in"/>
                </div>
                <br/>
                <span class="text-center"><a href="/signup" class="text-sm">회원가입 하러가기</a></span>
            </form>
        </div>
    </div>
</div>

<script>
    var message = '${msg?if_exists}';
    if(message!=""){
    alert(message)
    }
</script>
<script>
    $(document).ready(function () {
        $("#btnLogin").click(function () {
            var userEmail = $("#email").val();
            var userPw = $("#password").val();
            if (userEmail == "") {
                alert("이메일을 입력하세요.");
                $("#email").focus();
                return;
            }
            if (userPw == "") {
                alert("비밀번호를 입력하세요.");
                $("#password").focus();
                return;
            }
            document.login.action = "/login-proc";
            document.login.submit();
        });
    });
</script>
</body>
</html>