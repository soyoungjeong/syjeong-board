package com.muhayu.syjeongboard.controller;

import com.muhayu.syjeongboard.model.User;
import com.muhayu.syjeongboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/signup")
    public String signup(){
        return "signup";
    }

    @RequestMapping(value = "/signupProc")
    public String signupProc(HttpServletRequest request){

        User user = new User();

        user.setEmail(request.getParameter("email"));
        user.setNickname(request.getParameter("nickname"));
        user.setPassword(request.getParameter("password"));

        userService.userInsert(user);

        return "redirect:/login";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/loginProc")
    public String logincheck(HttpServletRequest request, HttpSession session) {

        User loguser = new User();
        loguser.setEmail(request.getParameter("email"));
        loguser.setPassword(request.getParameter("password"));

        boolean result = userService.logincheck(loguser, session);
        if (result == true){
            return "redirect:/board/list";
        }
        else{
            //에러 메세지 추가.
            return "redirect:/login";
        }

    }
}
