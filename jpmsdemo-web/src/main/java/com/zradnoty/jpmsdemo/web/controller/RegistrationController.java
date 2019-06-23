package com.zradnoty.jpmsdemo.web.controller;

import com.zradnoty.jpmsdemo.auth.service.UserService;
import com.zradnoty.jpmsdemo.web.pojo.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(path = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
    @ResponseBody
    public String register(@RequestBody RegistrationForm registrationForm) {
        if (!userService.isUsernameReserved(registrationForm.getUsername())) {
            userService.registerUser(registrationForm.getName(), registrationForm.getUsername(), registrationForm.getPassword());
            return "Thank you, " + registrationForm.getName() + ", your registration was succesful!";
        } else {
            return "This username is alredy taken!";
        }
    }
}
