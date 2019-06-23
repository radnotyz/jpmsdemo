package com.zradnoty.jpmsdemo.auth.service;

import com.zradnoty.jpmsdemo.data.model.User;
import java.util.ArrayList;
import java.util.List;
import com.zradnoty.jpmsdemo.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public List<User> listUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach((user) -> {
            System.out.println(user);
            users.add(user);
        });
        return users;
    }
    
    public void registerUser(String name, String username, String password) {
        if (name != null && username != null && password != null) {
            userRepository.save(new User(name, username, password));
        }
    }
    
    public User findUser(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }
    
    public boolean isUsernameReserved(String username) {
        return userRepository.findByUsername(username) != null;
    }
    
}
