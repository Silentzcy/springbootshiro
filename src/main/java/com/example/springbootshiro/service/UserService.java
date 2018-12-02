package com.example.springbootshiro.service;

import com.example.springbootshiro.mapper.UserMapper;
import com.example.springbootshiro.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    public User findByName (String name);
    public User findById(Integer id);

}
