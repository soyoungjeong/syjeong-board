package com.muhayu.syjeongboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomController {
    @RequestMapping(value="/")
    public String main() {

        String a = "";
        String[] str = new String[]{"a","b"};

        //FilenameUtils.
        //->List -> Map
        return "main";
    }


    @RequestMapping(value="/board/list")
    public String list() { return "list"; }

    @RequestMapping(value="/board/write")
    public String write() { return "write"; }
}
