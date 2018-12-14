package com.muhayu.syjeongboard.service;

import com.muhayu.syjeongboard.exception.UserException;
import com.muhayu.syjeongboard.model.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    int userInsert(User user);

    User procLogin(String email, String password, HttpSession session) throws UserException;

    void selectUser(String email) throws UserException;

    void checkPassword(User user) throws UserException;

    }
