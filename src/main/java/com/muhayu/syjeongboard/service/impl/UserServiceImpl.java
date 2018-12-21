package com.muhayu.syjeongboard.service.impl;

import com.muhayu.syjeongboard.mapper.UserMapper;
import com.muhayu.syjeongboard.model.User;
import com.muhayu.syjeongboard.service.UserService;
import com.muhayu.syjeongboard.exception.UserException;
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
            String nickname = user.getNickname();

            User selectUserByEmail = selectUserByEmail(email);
            if (selectUserByEmail != null) {
                throw new UserException("이미 가입한 이메일입니다.");
            }

            User selectUserByNick = selectUserByNick(nickname);
            if (selectUserByNick != null) {
                throw new UserException("이미 가입한 닉네임입니다.");
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
    public User procLogin(HttpSession session, String email, String password) throws UserException {

        try {
            User loggedUser = selectUserByEmail(email);
            if(loggedUser == null){
                throw new UserException("아이디 또는 비밀번호가 틀렸습니다.");
            }

            User user = new User(email, password);
            if(!isUserPasswordMatch(user)){
                throw new UserException("아이디 또는 비밀번호가 틀렸습니다.");
            }

            session.setAttribute("user", loggedUser);

            return loggedUser;

        } catch (UserException e) {
            throw e;
        }
    }

    public User selectUserByEmail(String email){
        return userMapper.selectUserByEmail(email);
    }

    public User selectUserByNick(String nickname){
        return userMapper.selectUserByNick(nickname);
    }

    public boolean isUserPasswordMatch(User user){
        User loggedUser = userMapper.selectUserByEmail(user.getEmail());
        String encodedPassword = loggedUser.getPassword();
        return passwordEncoder.matches(user.getPassword(), encodedPassword);
    }

    public void logout(HttpSession session){
        session.invalidate();
    }

    @Override
    public User getLoginUser(HttpSession session) throws UserException{
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new UserException("로그인이 필요합니다.");
        }
        return user;

    }

}

