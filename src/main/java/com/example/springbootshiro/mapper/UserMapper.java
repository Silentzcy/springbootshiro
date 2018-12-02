package com.example.springbootshiro.mapper;

import com.example.springbootshiro.model.User;

public interface UserMapper {

    User findByName(String name);
    User findById(Integer id);
}
