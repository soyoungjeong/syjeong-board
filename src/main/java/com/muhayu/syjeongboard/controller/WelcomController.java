package com.muhayu.syjeongboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomController {
    @RequestMapping(value="/")
    public String welcom() {
        return "testpage/main";
    }
}
