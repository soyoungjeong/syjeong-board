package com.muhayu.syjeongboard.controller;

import com.muhayu.syjeongboard.exception.UserException;
import com.muhayu.syjeongboard.model.User;
import com.muhayu.syjeongboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/signup-proc")
    public String signupProc(HttpServletRequest request){


        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");

        User user = new User();
        user.setEmail(email);
        user.setNickname(nickname);
        user.setPassword(password);

        userService.userInsert(user);

        return "redirect:/login";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login-proc")
    public String loginProc(HttpServletRequest request, HttpSession session, Model model) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");



        User user = userService.procLogin(email, password, session);
        if(user != null) {
            return "redirect:/board/list";
        }
        model.addAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
        return "/login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, Model model){
        userService.logout(session);
        model.addAttribute("msg", "로그아웃 했습니다.");
        return "/login";
    }
}
