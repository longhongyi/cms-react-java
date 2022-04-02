package com.datasource.mappers;

import com.datasource.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    //登录
    User find(User user);
    //注册
    int insert(User user);
}
