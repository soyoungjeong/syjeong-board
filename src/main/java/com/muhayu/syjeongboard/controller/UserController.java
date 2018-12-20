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
    public String procSignup(HttpServletRequest request, Model model){

        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");

        User user = new User();
        user.setEmail(email);
        user.setNickname(nickname);
        user.setPassword(password);

        try {
            userService.insertUser(user);

            return "redirect:/login";
        }
        catch(UserException e){
            model.addAttribute("msg", e.getMessage());
            return "/signup";
        }

    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login-proc")
    public String procLogin(HttpServletRequest request, HttpSession session, Model model) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        try{
            User user = userService.procLogin(email, password, session);

            if(user == null){
                throw new Exception();
            }
        }
        catch (Exception e){
            model.addAttribute("msg", e.getMessage());
            return "/login";
        }

        return "redirect:/board/list";

    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, Model model){
        userService.logout(session);
        model.addAttribute("msg", "로그아웃 했습니다.");
        return "login";
    }
}
