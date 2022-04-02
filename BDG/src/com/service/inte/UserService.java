package com.service.inte;

import java.util.Map;

public interface UserService {
    //登录
    Map validateUser(String username, String password);

    
   Map userRegister(String username, String password);
}
