jQuery(function(){

    	jQuery('.document_popup_menu a').css('color','#fff');
	jQuery('.document_popup_menu a').hide();
	
	
	//팝업 공지 부분 시작
	jQuery(".ck-ad-pop .close").click(function(event){
		var container = jQuery(event.target).parents(".ck-ad-pop");
		container.hide();
		
		var days = container.find("input[type=checkbox]:checked").val();  //숨길 날 수
		
		// 숨길 날 수 지정이 하루, 일주일 둘다 체크되었을 경우 일주일로 지정
		if(container.find("input[type=checkbox]:checked").length>1){
			days=7;
		}
		if(days){
			var id = container.attr("id");
			var date = new Date();
			date.setDate( date.getDate() + parseInt(days, 10) );
			document.cookie = id + "=" + days + "; path=/; expires=" + date.toGMTString() + ";";
		}
		
		jQuery(".ck-ad-bg").hide();
	});
	
	jQuery(".ck-ad-pop").each(function(){
		var container = jQuery(this);
		if(container.is(":visible")){
			var name = this.id + "=";
			var cookies = document.cookie.split("; ");
			
			for(var i = 0, len = cookies.length; i < len; i++){
				if(cookies[i].indexOf(name) === 0){
					container.hide();
					if(container.attr("bg") === "true"){
						jQuery(".ck-ad-bg").hide();
					}
					break;
				}
			}
		}
	});
        
	//팝업 공지 부분 끝        
        
    jQuery("input[name=user_id]").focus();
    
    jQuery("#bt_banner_close-btn").click(function(){
        jQuery(".ck-bt-float-banner").hide();
    });
});

//설문조사 참여 시 일주일간 팝업 노출 안함
//function clickSurvey(){
//	jQuery('#close_week').attr("checked", true);
//	jQuery('.ck-ad-pop .close').click();
//}


//화면 액션 정의
/*jQuery(function($){
	jQuery(".pop-info .top img").click(function(event){
		CopykillerPopup.hideAlert();
	});
	jQuery(".menu2 a").click(function(){
		var isLoginRequired = jQuery(this).attr("login_required");
		if(isLoginRequired){
			CopykillerPopup.showAlert("로그인이 필요한 서비스입니다.");
			return false;
		}
		var notPermitted = jQuery(this).attr("not_permitted");
		if(notPermitted){
			CopykillerPopup.showAlert("사용권한이 없습니다.");
			return false;
		}
	});
});*/

jQuery(function($){
    jQuery(".pop-info .top img").click(function(event){
        CopykillerPopup.hideAlert();
    });

    jQuery(".menu2 a").click(function(){

        var mylang = jQuery("input[name=lang]").val();

        var isLoginRequired = jQuery(this).attr("login_required");

        if(isLoginRequired){
            if(mylang !== 'en') {
                CopykillerPopup.showAlert("로그인이 필요한 서비스입니다.");
            }
            else{
                CopykillerPopup.showAlert("This service requires a login");
            }
            window.setTimeout("location.href = '/';", 1600);
            return false;
        }

        var notPermitted = jQuery(this).attr("not_permitted");
        if(notPermitted){
            CopykillerPopup.showAlert("오늘 등록 가능한 문서를 모두 사용하였습니다.");

            // 2초 후, 카피킬러 페이지로 이동
            //window.setTimeout("location.href = '/?act=dispPaymentCkpoint';", 1600);
            return false;
        }

        var notUploaded = jQuery(this).attr("not_uploaded");

        if(notUploaded){
            CopykillerPopup.showAlert("오늘 등록 가능한 문서를 모두 사용하였습니다.");

            // 2초 후, 카피킬러 페이지로 이동
            //window.setTimeout("location.href = '/?act=dispPaymentCkpoint';", 1600);
            return false;
        }
    });
    /*jQuery("#family_site").on("click",function () {
        jQuery(this).toggleClass('click');
        jQuery("#family_site #menu").toggle();
    });*/
});

/*
jQuery(document).ready(function () {
    if(jQuery(".layout-main").height()<850){
        jQuery(".google_ad").hide()
    }
});*/
