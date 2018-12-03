function ckPopupInit(domain) {
    var pop_up_list = jQuery(".pop_up-content").filter(function () {
        return xGetCookie(jQuery(this).data('id')) !== "done";
    });
    var length = pop_up_list.length - 1;
    pop_up_list.each(function (index, value) {
        var mousePosition;
        var offset = [0, 0];
        var isDown = false;
        var popup = jQuery(this);
        var popUpWidth = popup.width();
        var popUpHeight = popup.height();
        var windowHeight = jQuery(window).height();
        var windowWidth = jQuery(window).width();
        var top;
        var width = 0;
        popup.on("mousedown", function (e) {
            isDown = true;
            offset = [
                popup[0].offsetLeft - e.clientX,
                popup[0].offsetTop - e.clientY
            ];
        });
        popup.on('mouseup', function () {
            isDown = false;
        });
        popup.on('mousemove', function (event) {
            event.preventDefault();
            if (isDown) {
                mousePosition = {
                    x: event.clientX,
                    y: event.clientY
                };
                jQuery(this).css("left", (mousePosition.x + offset[0]) + 'px');
                jQuery(this).css("top", (mousePosition.y + offset[1]) + 'px');
            }
        });

        // top = (windowHeight - popUpHeight) / 2;
        if (popUpHeight + 100 >= windowHeight) {
            top = 150;
        } else {
            top = (windowHeight - popUpHeight) / 2;
        }
        if (index % 2 === 0) {
            width = (windowWidth - popUpWidth) / 2 - (popUpWidth / 2) - 25;
        } else {
            width = (windowWidth - popUpWidth) / 2 + (popUpWidth / 2) + 25;
        }
        if (length === index && length % 2 === 0) {
            width = (windowWidth - popUpWidth) / 2;
        }
        popup.css("top", top + "px");
        popup.css("left", width + "px");
        popup.show();
        popup.find('button').on('click', function () {
            var popup_id = jQuery(this).data('id');
            if (jQuery('#' + popup_id).is(":checked")) {
                var expire = new Date();
                expire.setTime(expire.getTime() + (24 * 3600000));
                xSetCookie(popup_id, "done", expire, "/");
            }
            jQuery(this).parents('.pop_up-content').hide();
            if (typeof(ga) == 'function') {
                ga('send', {
                    hitType: 'event',
                    eventCategory: 'popup',
                    eventAction: 'close',
                    eventLabel: domain
                });
            }
        });
    });
}