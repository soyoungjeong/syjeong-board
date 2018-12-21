package com.muhayu.syjeongboard.mapper;


import com.muhayu.syjeongboard.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    int insertUser(User user);

    User selectUserByEmail(String email);

    User selectUserByNick(String nickname);
}
