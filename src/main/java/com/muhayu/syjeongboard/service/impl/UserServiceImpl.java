package com.muhayu.syjeongboard.service.impl;


import com.muhayu.syjeongboard.mapper.UserMapper;
import com.muhayu.syjeongboard.model.User;
import com.muhayu.syjeongboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    private final JdbcTemplate jdbcTemplate;

    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int userInsert(User user) {
        return userMapper.userInsert(user);
    }

    @Override
    public boolean logincheck(User loguser, HttpSession session) {
        boolean result = userExist(loguser);
        if (result) {
            User user2 = userView(loguser);
            session.setAttribute("email", user2.getEmail());
            session.setAttribute("nickname", user2.getNickname());
        }
        return result;

    }

    public User userView(User user) {
        return userMapper.userView(user);
    }


    public boolean userExist(User loguser) {

        //Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(String.format("select * from user where user.email='%s' and user.password='%s'", loguser.getEmail(), loguser.getPassword()));
        User user1 = userMapper.userExist(loguser);
        if(user1 != null){
            return true;
        }

        else{
            return false;
        }
    }
}

