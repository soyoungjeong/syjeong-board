package com.muhayu.syjeongboard.service;

import com.muhayu.syjeongboard.exception.UserException;
import com.muhayu.syjeongboard.model.User;
import com.sun.xml.internal.ws.resources.HttpserverMessages;

import javax.servlet.http.HttpSession;

public interface UserService {

    int insertUser(User user) throws UserException;

    User procLogin(HttpSession session, String email, String password) throws UserException;

    User getLoginUser(HttpSession session) throws UserException;

    User selectUserByEmail(String email);

    User selectUserByNick(String nickname);

    boolean isUserPasswordMatch(User user);

    void logout(HttpSession session);


}
