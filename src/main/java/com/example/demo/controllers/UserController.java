package com.example.demo.controllers;

import com.example.demo.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserController {

    private UserDaoImpl userDao;
    @Autowired
    public UserController(UserDaoImpl userDao) {

        this.userDao = userDao;
    }
    @GetMapping("/get-all-users")
    public void getAllUser() {
        userDao.getAllUser();
    }
    @GetMapping("/get-user-id")
    public void getUserByIdNamed() {
        int id = 4;
        userDao.getUserByIdNamed(id);
    }

}
