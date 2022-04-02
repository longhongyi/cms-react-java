package com.controller;

import com.service.inte.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map userLogin(@RequestBody Map params) throws IOException {
        String username=(String)params.get("username");
        String password=(String)params.get("password");
        Map map=userService.validateUser(username,password);
        return map;
    }

    @RequestMapping("/register")
    public Map userRegister(@RequestBody Map params) throws IOException {
        String username=(String) params.get("username");
        String password=(String) params.get("password");
        Map map=userService.userRegister(username,password);
        return map;
    }
}
