package com.moudle.mapper;

import com.moudle.data.User;

import java.util.List;


public interface UserMapper {
    //登录
    public User find(User user);
    //注册
    public int insert(User user);
}
