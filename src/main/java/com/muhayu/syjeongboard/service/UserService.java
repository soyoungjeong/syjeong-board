package com.muhayu.syjeongboard.service;

import com.muhayu.syjeongboard.exception.UserException;
import com.muhayu.syjeongboard.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpSession;

public interface UserService {

    int userInsert(User user);

    User procLogin(String email, String password, HttpSession session) throws UserException;

    User selectUser(String email);

    boolean checkPassword(User user);

    void logout(HttpSession session);

    PasswordEncoder passwordEncoder();

    void checkUser(String email) throws UserException;
}
