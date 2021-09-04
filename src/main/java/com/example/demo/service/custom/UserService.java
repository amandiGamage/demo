package com.example.demo.service.custom;

import com.example.demo.model.User;
import com.example.demo.service.SuperService;

import java.util.Optional;

public interface UserService extends SuperService<User> {
    public Optional<User> findByUserName(String username);
}
