package com.example.springbootshiro.service.impl;

import com.example.springbootshiro.mapper.UserMapper;
import com.example.springbootshiro.model.User;
import com.example.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByName(String name){

        return userMapper.findByName(name);
    }

}
