package com.zradnoty.jpmsdemo.auth.service;

import com.zradnoty.jpmsdemo.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    @Autowired
    UserService userService;
    
    public String authenticateUser(String username, String password) {
        User user = userService.findUser(username, password);
        if (user == null) {
            return null;
        }
        return user.getName();
    }
    
}
