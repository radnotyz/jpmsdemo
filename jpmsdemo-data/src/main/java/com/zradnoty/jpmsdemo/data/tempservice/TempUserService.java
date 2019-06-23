package com.zradnoty.jpmsdemo.data.tempservice;

import com.zradnoty.jpmsdemo.data.model.User;
import com.zradnoty.jpmsdemo.data.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempUserService {
    
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
    
    public void saveUser(User user) {
        userRepository.save(user);
    }
    
}
