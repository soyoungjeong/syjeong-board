package com.muhayu.syjeongboard.service.impl;


import com.muhayu.syjeongboard.mapper.UserMapper;
import com.muhayu.syjeongboard.model.User;
import com.muhayu.syjeongboard.service.UserService;
import com.muhayu.syjeongboard.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    public int userInsert(User user) {
        return userMapper.userInsert(user);
    }


    @Override
    public User procLogin(String email, String password, HttpSession session) throws UserException{

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        try {
            selectUser(email);

            checkPassword(user);

            session.setAttribute("userInfo", user);

        } catch (Exception e){
            System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
            e.printStackTrace();
            return null;
        }
        return user;
    }

    public void selectUser(String email) throws UserException{
        User user = userMapper.selectUser(email);
        if(user==null){
            throw new UserException("존재하지 않는 아이디 입니다.");
        }
    }


    public void checkPassword(User user) throws UserException{
        User loggedUser = userMapper.checkPassword(user);
        if(loggedUser == null){
            throw new UserException("비밀번호가 틀렸습니다.");
        }

    }


// procLogin
// emailaddress로 사용자 정보가 존재하는지 확인 ??
// 비밀번호가 일차하는지 확인 ??
// 세션에 정보를 저장한다
}

