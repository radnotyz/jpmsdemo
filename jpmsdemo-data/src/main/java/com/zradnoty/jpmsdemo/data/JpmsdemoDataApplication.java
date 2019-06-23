package com.zradnoty.jpmsdemo.data;

import com.zradnoty.jpmsdemo.data.model.User;
import com.zradnoty.jpmsdemo.data.tempservice.TempUserService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpmsdemoDataApplication {
    
    @Autowired
    TempUserService userService;
    
    @PostConstruct
    public void fuckYou() {
        User user = new User("Alfred Hitchcock", "alfred", "vertigo");
        userService.saveUser(user);
        
        System.out.println("FUCK:" + userService.listUsers().get(0));
    }
    
    public static void main(String[] args) {
        SpringApplication.run(JpmsdemoDataApplication.class, args);
        
    }
    
}
