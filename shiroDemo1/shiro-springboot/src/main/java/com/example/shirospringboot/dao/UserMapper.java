package com.example.shirospringboot.dao;

import com.example.shirospringboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper {
    public User findUserByName(String username);
}
