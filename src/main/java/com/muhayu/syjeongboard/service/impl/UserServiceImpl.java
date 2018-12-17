package com.muhayu.syjeongboard.service.impl;


import com.muhayu.syjeongboard.mapper.UserMapper;
import com.muhayu.syjeongboard.model.User;
import com.muhayu.syjeongboard.service.UserService;
import com.muhayu.syjeongboard.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired UserMapper userMapper;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public int userInsert(User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        user.setPassword(encodedPassword);

        return userMapper.userInsert(user);
    }


    @Override
    public User procLogin(String email, String password, HttpSession session) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        try {
            selectUser(email);

            User loggedUser = checkPassword(user);

            session.setAttribute("user", loggedUser);

        } catch (Exception e) {
            return null;
        }
        return user;
    }

    public void selectUser(String email) throws UserException {
        User user = userMapper.selectUser(email);
        if (user == null) {
            throw new UserException("존재하지 않는 아이디 입니다.");
        }
    }


    public User checkPassword(User user) throws UserException {
        User loggedUser = userMapper.checkPassword(user);
        if (loggedUser == null) {
            throw new UserException("비밀번호가 틀렸습니다.");
        }
        return loggedUser;
    }

    public void logout(HttpSession session){
        session.invalidate();
    }
// procLogin
// emailaddress로 사용자 정보가 존재하는지 확인 ??
// 비밀번호가 일차하는지 확인 ??
// 세션에 정보를 저장한다


    public PasswordEncoder passwordEncoder(){
        return this.passwordEncoder;
    }
}

