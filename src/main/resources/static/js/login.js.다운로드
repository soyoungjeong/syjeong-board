/* After Login */
function completeLogin(ret_obj, response_tags, params, fo_obj) {
    var url = current_url.setQuery('act', '');
    location.href = url;
}

jQuery(function ($) {
    // focus userid input box
    if (!$(document).scrollTop()) {
        try {
            $('#fo_login_widget > input[name=user_id]').focus();
        } catch (e) {
        }
        ;
    }

    var labelEmail = $("#label_email");
    var inputID = $("input[name=user_id]");

    if (inputID.length !== 0) {

        if (inputID.val().trim() != '') {
            labelEmail.hide();
        }

        labelEmail.click(function (event) {
            labelEmail.hide();
            inputID.focus();
        });

        inputID.focus(function (event) {
            labelEmail.hide();
        });

        inputID.blur(function (event) {
            if (inputID.val().trim() == '') {
                labelEmail.show();
            }
        });


        var labelPassword = $("#label_password");
        var inputPassword = $("input[name=password]");


        if (inputPassword.val().trim() != '') {
            labelPassword.hide();
        }

        labelPassword.click(function (event) {
            labelPassword.hide();
            inputPassword.focus();
        });

        inputPassword.focus(function (event) {
            labelPassword.hide();
        });

        inputPassword.blur(function (event) {
            if (inputPassword.val().trim() == '') {
                labelPassword.show();
            }
        });
    }
});

function checker() {
    var email = jQuery("#fo_login_widget input[name='user_id']").val();
    if (!verifyEmail(email)) {
        CopykillerLayout.showAlert("올바른 메일 주소가 아닙니다.");
        return false;
    }
    if (jQuery("#fo_login_widget input[name=password]").val().length === 0) {
        CopykillerLayout.showAlert("비밀번호 값은 필수입니다.");
        return false;
    }
    return true;
}

function verifyEmail(email) {
    var regex = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    return (email != '' && email != 'undefined' && regex.test(email));
}

jQuery(document).ready(function () {
	jQuery('input[name="user_id"]').blur();
});
