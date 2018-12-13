package com.muhayu.syjeongboard.mapper;


import com.muhayu.syjeongboard.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    int userInsert(User user);

    User userExist(User user);

    User userView(User user);


}
