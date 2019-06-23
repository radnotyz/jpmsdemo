package com.zradnoty.jpmsdemo.data.repository;

import com.zradnoty.jpmsdemo.data.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    
    public User findByUsernameAndPassword(String username, String password);
    public User findByUsername(String username);
    
}