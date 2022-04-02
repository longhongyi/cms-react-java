package com.service.impl;

import com.datasource.entities.User;
import com.datasource.mappers.UserMapper;
import com.service.inte.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private User user;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Map validateUser(String username,String password){
        Map map=new HashMap<>();
        user.setUsername(username);
        user.setPassword(password);
        User userFind=userMapper.find(user);
        if(userFind==null){
            map.put("status","failed");
            map.put("message","用户不存在！");
        }else{
            if(password.compareTo(userFind.getPassword())!=0){
                map.put("status","failed");
                map.put("message","密码错误！");
            }else{
                //登录成功，创建token
                String nowTime=String.valueOf(System.currentTimeMillis());
                String random=String.valueOf((int)(Math.random()*1000));
                String token= DigestUtils.md5DigestAsHex((username+password+nowTime+random).getBytes());
                String userId=String.valueOf(userFind.getId());
                stringRedisTemplate.opsForValue().set("userId_"+userId,token,Duration.ofSeconds(60*60*24));

                map.put("status","success");
                map.put("data",userFind);
                map.put("token",token);
            }
        }
        return map;
    }

    @Override
    public Map userRegister(String username,String password){
        Map map=new HashMap<>();
        user.setUsername(username);
        user.setPassword(password);
        User existedUser=userMapper.find(user);

        if(existedUser!=null&&0==username.compareTo(existedUser.getUsername())) {
            map.put("status", "failed");
            map.put("message", "注册失败，用户名已存在！");
        }else{
            try{
                userMapper.insert(user);
                map.put("status","success");
                map.put("data",user);
            }catch (Exception e){
                map.put("status", "failed");
                map.put("message","注册失败，发生未知原因，请联系管理员！");
                return map;
            }
        }
        return map;
    }
}
