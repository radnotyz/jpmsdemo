package com.zradnoty.jpmsdemo.web.controller;

import com.zradnoty.jpmsdemo.auth.service.AuthService;
import com.zradnoty.jpmsdemo.web.pojo.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @Autowired
    AuthService authService;
    
    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
    @ResponseBody
    public String login(@RequestBody Credentials credentials) {
        String userFullName = authService.authenticateUser(credentials.getUsername(), credentials.getPassword());
        return (userFullName == null) ? "Invalid login attempt with credentials: {username: " + credentials.getUsername() + ", password: " + credentials.getPassword() + "}" :  "Valid user! Logging in...";
    }
    
    @RequestMapping(path = "/logout", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String logout() {
        return "Logout attempt.";
    }
}
