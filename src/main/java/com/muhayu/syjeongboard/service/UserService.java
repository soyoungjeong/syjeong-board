package com.muhayu.syjeongboard.service;

import com.muhayu.syjeongboard.exception.UserException;
import com.muhayu.syjeongboard.model.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    int insertUser(User user) throws UserException;

    User procLogin(String email, String password, HttpSession session) throws UserException;

    User selectUser(String email);

    boolean checkPassword(User user);

    void logout(HttpSession session);


}
