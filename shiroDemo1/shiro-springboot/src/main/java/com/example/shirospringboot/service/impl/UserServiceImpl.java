package com.example.shirospringboot.service.impl;

import com.example.shirospringboot.dao.UserMapper;
import com.example.shirospringboot.pojo.User;
import com.example.shirospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }
}
