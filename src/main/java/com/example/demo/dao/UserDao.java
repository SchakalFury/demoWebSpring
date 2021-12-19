package com.example.demo.dao;

import com.example.demo.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    User getUserByIdNamed(Long id);

}
