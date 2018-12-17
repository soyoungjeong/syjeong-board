package com.muhayu.syjeongboard.service;

import com.muhayu.syjeongboard.exception.UserException;
import com.muhayu.syjeongboard.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpSession;

public interface UserService {

    int userInsert(User user);

    User procLogin(String email, String password, HttpSession session);

    void selectUser(String email) throws UserException;

    User checkPassword(User user) throws UserException;

    void logout(HttpSession session);

    PasswordEncoder passwordEncoder();
    }
