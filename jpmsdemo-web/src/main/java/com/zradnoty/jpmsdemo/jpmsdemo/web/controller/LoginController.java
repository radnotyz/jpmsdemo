package com.zradnoty.jpmsdemo.jpmsdemo.web.controller;

import com.zradnoty.jpmsdemo.jpmsdemo.web.auth.Credentials;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
    @ResponseBody
    public String login(@RequestBody Credentials credentials) {
        return "Login attempt with credentials: {username: " + credentials.getUsername() + ", password: " + credentials.getPassword() + "}";
    }
    
    @RequestMapping(path = "/logout", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String logout() {
        return "Logout attempt.";
    }
}
