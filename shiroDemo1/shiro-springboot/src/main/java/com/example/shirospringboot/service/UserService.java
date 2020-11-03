package com.example.shirospringboot.service;

import com.example.shirospringboot.pojo.User;

public interface UserService {
    public User findUserByName(String username);
}
