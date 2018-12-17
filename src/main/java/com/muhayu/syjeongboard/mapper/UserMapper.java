package com.muhayu.syjeongboard.mapper;


import com.muhayu.syjeongboard.model.User;
import org.apache.ibatis.annotations.Mapper;

import javax.servlet.http.HttpSession;


@Mapper
public interface UserMapper {

    int userInsert(User user);

    User checkPassword(User user);

    User selectUser(String email);


}
