jQuery(document).ready(function () {
    jQuery("div.btnArea").hide();
});

//화면 이벤트 정의
jQuery(function ($) {

    jQuery(".copykiller_link img").click(function (event) {
        if (event.target.parentNode.tagName != "A") {
            CopykillerLayout.showAlert("로그인이 필요한 서비스입니다.");
        }
        ;
    });

    if ((typeof xeValidatorMessage != "undefined") && jQuery.browser.msie && parseInt(jQuery.browser.version, 10) === 7) {
        if (navigator.userAgent.indexOf("Trident") === -1) {
            CopykillerLayout.showAlert("Internet Explorer를 사용하시는 경우 <br>카피킬러는 Internet Explorer 8.0 <br>이상에서 최적의 서비스를 제공합니다.");
        }
    }

    //글자수세기
    jQuery('.text_count').click(function () {
        window.open('http://textcount.sawoo.com', '_blank', ' width=920,height=670');
    });

    //출처 생성기
    jQuery('.source_gen').click(function () {
        var data = jQuery(this).data("sso");
        if(data!==undefined) {
            window.open('http://citation.sawoo.com/ref/intro?sso=' + data, '_blank');
        }else{
            window.open('http://citation.sawoo.com/ref/intro', '_blank');
        }
    });
    //인용/출처 표기가이드
    jQuery('.ref_guide').click(function () {
        window.open('http://citation.sawoo.com/ref/guide/chicago', '_blank');
    });

    jQuery('#not_login_user_action').click(function () {
        CopykillerLayout.showAlert('로그인이 필요한 서비스입니다.');
    });
});