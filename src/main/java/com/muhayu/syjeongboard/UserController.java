package com.muhayu.syjeongboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping(value="/signup")
    public String singup() {
        return "signup";
    }

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }
}
