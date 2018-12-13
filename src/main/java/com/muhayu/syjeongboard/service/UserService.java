package com.muhayu.syjeongboard.service;

import com.muhayu.syjeongboard.model.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public interface UserService {

    int userInsert(User user);

    boolean logincheck(User user, HttpSession session);

    User userView(User user);

    boolean userExist(User user);
}
