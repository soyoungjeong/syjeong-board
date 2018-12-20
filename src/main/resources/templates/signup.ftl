<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>signup</title>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
    <style>
        .container {margin-top:200px;}
        .col-md-3 {display:table; width:400px; height:100%; position:relative; left:350px;}
        .signup-box well {display:table-cell; text-align: center;}
        .text-center {position:relative; left:120px;}
        .btn{width:200px; text-align: center; position :relative; left:30px;}
        .well {background-color: white;}
        .no-border {border:0; border-bottom:2px solid lightgrey; box-shadow:none; border-radius:0;}
        input:focus, input[type]:focus{border-color:lightskyblue; box-shadow:none; outline:0 none;}
        input:-webkit-autofill {-webkit-box-shadow: 0 0 0 30px white inset; -webkit-text-fill-color: black !important;}
        legend {border:0; text-align:center; font-weight:bold; padding-top:20px; padding-bottom:60px;}
    </style>
</head>
<body>
    <div class="container">
            <div id="signup_box" class="col-md-3">
                <div class="signup-box well">
                <form role="signup" name="signup" class="form-horizontal" method="post" action="/signup-proc">
                    <legend>회원가입</legend>
                    <div class="form-group">
                        <label class="col-sm-1 col-xs-offset-1 control-label"><span class="glyphicon glyphicon-envelope"></span></label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control no-border" id="email" name="email" placeholder="Email"><br />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 col-xs-offset-1 control-label"><span class="glyphicon glyphicon-user"></span></label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control no-border" id="nickname" name="nickname" placeholder="Nickname" ><br />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 col-xs-offset-1 control-label"><span class="glyphicon glyphicon-lock"></span></label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control no-border" id="password" name="password" placeholder="Password"><br />
                        </div>
                    </div>
                    <div class="btn">
                        <input type="button" id="btnSignup" class="btn btn-primary" value="Sign up" />
                    </div>
                    <br/>
                    <span class="text-center"><a href="/login" class="text-sm">로그인 하러가기</a></span>
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
            $("#btnSignup").click(function () {
                var userEmail = $("#email").val();
                var userPw = $("#password").val();
                var userNick = $("#nickname").val();
                if (userEmail == "") {
                    alert("이메일을 입력하세요.");
                    $("#email").focus();
                    return;
                }
                if (userNick == "") {
                    alert("닉네임을 입력하세요.");
                    $("#email").focus();
                    return;
                }
                if (userPw == "") {
                    alert("비밀번호를 입력하세요.");
                    $("#password").focus();
                    return;
                }
                document.signup.action = "/signup-proc";
                document.signup.submit();
            });
        });
    </script>
</body>
</html>