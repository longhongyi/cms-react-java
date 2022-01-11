package com.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.moudle.mapper.UserMapper;
import com.utils.SqlManager;
import com.moudle.data.User;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map userLogin(@RequestBody Map params) throws IOException {
        UserMapper userMapper= SqlManager.getSqlMapper(UserMapper.class);
        Map map=new HashMap<>();
        String username=(String)params.get("username");
        String password=(String)params.get("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user=userMapper.find(user);
        if(user==null){
            map.put("status","failed");
            map.put("message","用户不存在！");
        }else{
            if(password.compareTo(user.getPassword())!=0){
                map.put("status","failed");
                map.put("message","密码错误！");
            }else{
                map.put("status","success");
                map.put("data",user);
            }
        }
        return map;
    }

    @RequestMapping("/register")
    public Map userRegister(@RequestBody Map params) throws IOException {
        UserMapper userMapper= SqlManager.getSqlMapper(UserMapper.class);
        Map map=new HashMap<>();
        String username=(String) params.get("username");
        String password=(String) params.get("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        int rowNum=userMapper.insert(user);
        if(rowNum==0||user.getId()==0){
            map.put("status","failed");
            User existedUser=userMapper.find(user);
            if(0==username.compareTo(existedUser.getUsername())){
                map.put("message","注册失败，用户名已存在！");
            }else{
                map.put("message","注册失败，发生未知原因，请联系管理员！");
            }
        }else{
            map.put("status","success");
            map.put("data",user);
        }
        return map;
    }
}
