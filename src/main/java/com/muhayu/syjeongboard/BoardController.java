package com.muhayu.syjeongboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/board")
public class BoardController {


    @RequestMapping(value="/list")
    public String list() {
        return "board/list";
    }

    @RequestMapping(value="/login")
    public String write() {
        return "board/write";
    }

}
