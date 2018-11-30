jQuery(function(){

   	if (jQuery.browser.msie && parseInt(jQuery.browser.version, 10) === 7) {
	}
	else if (navigator.userAgent.indexOf('Safari') != -1 && navigator.userAgent.indexOf('Chrome') == -1) {
	}
	else if (document.documentMode == 7) {
	}
	else {
		Window.prototype.alert = function (message) {
			CopykillerLayout.showAlert(message);
		}
	}
	jQuery.extend(jQuery.fn.disableTextSelect = function() {
		return this.each(function(){
			if(jQuery.browser.mozilla){//Firefox
				jQuery(this).css('MozUserSelect','none');
			}else if(jQuery.browser.msie){//IE
				jQuery(this).bind('selectstart',function(){return false;});
			}else{//Opera, etc.

                jQuery(this).mousedown(function(){return false;});
			}
		});
        });
	//No text selection on elements with a class of 'noSelect'
	jQuery('.ck-no-select').disableTextSelect();


        try{
            if(xeValidatorMessage){
                    CopykillerLayout.showAlert(xeValidatorMessage);
            }
	}catch(e){}


});

show_waiting_message = false;

CopykillerLayout = {
	/**
	 * 반투명 배경을 가진 wait 화면 반환(전체 화면 크기에 맞게 설정)
	 */
	showTransparentBG: function(){
		var wait = jQuery(".pop-bg");
		wait.show();
	},

    showAlertAndLogin: function(message,url){
	    // url='/index.php?mid=myspace&document_srl=30213245';
	    var returnUrl=window.location.origin+url;
        returnUrl = encodeURIComponent(returnUrl);
        if(message.indexOf("아이디올바른") !== -1) {
            message = message.substring(3);
        } else if(message.indexOf("이메일 주소올바른") !== -1) {
            message = message.substring(6);
        }
        jQuery(".pop-info .big-msg").html(message);
        jQuery(".pop-info .outter").show();
        CopykillerLayout.showTransparentBG();
        jQuery(".pop-info .top img").click(function(event){
            CopykillerLayout.hideAlert();
            window.location.href="https://www.copykiller.com/login?"+"success_return_url="+returnUrl;
        });
    },
	// [x] 가 포함된 Alert 메시지 창 (소스 상에서, hide() 해줄 필요 없음)
	showAlert: function(message){
		if(message.indexOf("아이디올바른") !== -1) {
			message = message.substring(3);
		} else if(message.indexOf("이메일 주소올바른") !== -1) {
			message = message.substring(6);
		}

		jQuery(".pop-info .big-msg").html(message);
		jQuery(".pop-info .outter").show();
		CopykillerLayout.showTransparentBG();
	},

	// 시계가 돌아가는 Alert 메시지 창 (소스 상에서, hide() 필요)
	showWait: function(message){
		jQuery(".pop-wait .big-msg").html(message);
		jQuery(".pop-wait .outter").show();
		CopykillerLayout.showTransparentBG();
	},


	// 시계가 돌아가는 Alert 메시지 창 (소스 상에서, hide() 필요)
	showWaitWithoutBG: function(message , topPosition){
		jQuery(".pop-wait .big-msg").html(message);
		jQuery(".pop-wait .outter").show();

	},
	hideAlert: function(){
		jQuery(".pop-bg").hide();
		jQuery(".pop-info .outter").hide();
	},

	hideWait: function(){
		jQuery(".pop-bg").hide();
		jQuery(".pop-wait .outter").hide();
	}
};


//카피킬러 공통으로 사용하는 유틸함수 정의
CopykillerUtil = {
	/**
	 * 부적합한 char 코드를 제거한 후 반환
	 * @param {string} text
	 * @returns 생성결과
	 */
	stripInvalidXmlChars: function(text){
		if(text.length === 0){
			return text;
		}

		var strp = "";
		for (var i = 0; i < text.length; i++) {
			var code = text.charCodeAt(i);

			if (code == 0x9 || code == 0xA || code == 0xD ||
					(code >= 0x20 && code <= 0xD7FF) ||
					(code >= 0xE000 && code <= 0xFFFD) ||
					(code >= 0x10000 && code <= 0x10FFFF)) {
				strp += text.charAt(i);
			}
			else {
				strp += " ";
			}
		}

		return strp;
	},

	/**
	 * 숫자에 3자리마다 콤마 생성
	 * @param {type} number
	 * @returns {unresolved}
	 */
	formatNumber: function(number) {
		var reg = /(^[+-]?\d+)(\d{3})/;   // 정규식
		number += '';                     // 숫자를 문자열로 변환

		while (reg.test(number))
			number = number.replace(reg, '$1' + ',' + '$2');

		return number;
	}
};

function findIndexInData(data, property, value) {
    for(var i = 0, l = data.length ; i < l ; i++) {
        if(data[i][property] === value) {
            return i;
        }
    }
    return -1;
}