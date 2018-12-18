package com.muhayu.syjeongboard.mapper;


import com.muhayu.syjeongboard.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insertUser(User user);

    User selectUser(String email);


}
