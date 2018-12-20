package com.muhayu.syjeongboard.service;

import com.muhayu.syjeongboard.exception.UserException;
import com.muhayu.syjeongboard.model.User;
import com.sun.xml.internal.ws.resources.HttpserverMessages;

import javax.servlet.http.HttpSession;

public interface UserService {

    int insertUser(User user) throws UserException;

    User procLogin(String email, String password, HttpSession session) throws UserException;

    User selectUserByEmail(String email);

    User selectUserByNick(String nickname);

    User checkLogin(HttpSession session) throws UserException;

    boolean checkPassword(User user);

    void logout(HttpSession session);


}
