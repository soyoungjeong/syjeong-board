package com.muhayu.syjeongboard.service.impl;

import com.muhayu.syjeongboard.mapper.UserMapper;
import com.muhayu.syjeongboard.model.User;
import com.muhayu.syjeongboard.service.UserService;
import com.muhayu.syjeongboard.exception.UserException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired UserMapper userMapper;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public int insertUser(User user) throws UserException{

        try {
            String email = user.getEmail();
            User signupUser = selectUser(email);
            if (signupUser != null) {
                throw new UserException("이미 가입한 회원입니다.");
            }

            String rawPassword = user.getPassword();
            String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
            user.setPassword(encodedPassword);

            return userMapper.insertUser(user);
        }
        catch (UserException e){
            throw e;
        }
    }


    @Override
    public User procLogin(String email, String password, HttpSession session) throws UserException {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        try {
            User loggedUser = selectUser(email);
            if(loggedUser == null){
                throw new UserException("아이디 또는 비밀번호가 틀렸습니다.");
            }

            boolean result = checkPassword(user);
            if (!result) {
                throw new UserException("아이디 또는 비밀번호가 틀렸습니다.");
            }

            session.setAttribute("user", loggedUser);

            return loggedUser;

        } catch (UserException e) {
            throw e;
        }
    }

    public User selectUser(String email){
        return userMapper.selectUser(email);
    }

    public boolean checkPassword(User user){
        User loggedUser = userMapper.selectUser(user.getEmail());
        String encodedPassword = loggedUser.getPassword();
        return passwordEncoder.matches(user.getPassword(), encodedPassword);
    }

    public void logout(HttpSession session){
        session.invalidate();
    }

}

