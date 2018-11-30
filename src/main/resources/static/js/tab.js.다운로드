//문서 탭 2013
function document_tab(param, btn, obj, img, event) {
    var param = jQuery(param);
    var btn = param.find(btn);
    var obj = jQuery(obj);
    var elem = 0;

    var lcv = location.href;
    lcv = lcv.split("?ttab=");

    if (lcv[1]) {
        elem = lcv[1];
    }

    obj.hide().eq(elem).show();

    if (img == true) {
        var currBtn = btn.eq(0).find("img");
        currBtn.attr("src", currBtn.attr("src").replace(".gif", "_ov.gif"));
    } else {
        btn.removeClass("tab_ov");
        btn.eq(elem).addClass("tab_ov");
    }

    btn.bind(event, function () {
        var t = jQuery(this);
        if (img == true) {
            var timg = t.find("img");
            var imgSrc = timg.attr("src");
            imgSrc = imgSrc.substr(imgSrc.lastIndexOf("_"));

            if (imgSrc != "_ov.gif") {
                for (var i = 0; i < obj.size(); i++) {
                    var res = btn.eq(i).find("img");
                    res.attr("src", res.attr("src").replace("_ov.gif", ".gif"));
                }
                ;

                timg.attr("src", timg.attr("src").replace(".gif", "_ov.gif"));
            }
        }

        btn.removeClass("tab_ov");
        t.addClass("tab_ov");
        elem = t.index();
        obj.stop(true, true).hide();
        obj.eq(elem).stop(true, true).show();

        return false;
    });

    var m;

    param.find("a[rel=all]").click(function () {
        var t = jQuery(this);
        var n = 0;

        obj.stop(true, true).hide();

        m = setInterval(function () {
            obj.eq(n).stop(true, true).show();
            n++;

            if (n > obj.size() - 1) {
                clearInterval(m);
                n = 0;
            }
        }, 50);

        return false;
    });
}


function document_group(param, btn, obj, img, event) {
    var param = jQuery(param);
    var btn = param.find(btn);
    var obj = param.find(obj);
    var elem1 = 0;
    var elem2 = 0;

    var lcv = location.href;
    lcv = lcv.split("?ttab=");

    if (lcv[1]) {
        elem = lcv[1];
    }

    obj.hide().eq(elem2).show();
    btn.removeClass("tab_ov");
    btn.parent().eq(elem1).find(">a").eq(elem2).addClass("tab_ov");

    btn.bind(event, function () {
        var t = jQuery(this);

        btn.removeClass("tab_ov");
        t.addClass("tab_ov");

        obj.parent().eq(elem1).find(">.obj").eq(elem2).hide();

        elem1 = t.parent().index();
        elem2 = t.index();

        obj.parent().eq(elem1).find(">.obj").eq(elem2).show();
        return false;
    });
}


// 롤오버 rel="ov" 로 사용
jQuery(function () {
    var obj = jQuery("a[rel=ov]");
    obj.bind("mouseover focus mouseout blur", function () {
        var t = jQuery(this);
        var img = t.find(">img");
        var src = img.attr("src");
        var format = src.substr(src.lastIndexOf("."));

        src = src.substr(src.lastIndexOf("_"));

        if (src != "_ov" + format) {
            img.attr("src", img.attr("src").replace(format, "_ov" + format));
        } else {
            img.attr("src", img.attr("src").replace("_ov" + format, format));
        }
    });
});