package com.example.demo.controllers;

import com.example.demo.dao.UserDaoImpl;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {

    private UserDaoImpl userDao;
    @Autowired
    public UserController(UserDaoImpl userDao) {
    this.userDao = userDao;
    }




    @GetMapping("/get-all-users")
    @PreAuthorize("hasAuthority('users:read')")
    public String getAllUser(Model model) {
        List<User> users = userDao.getAllUser();
        model.addAttribute("users", users);
        return "all-users";
    }
    @GetMapping("/get-user-id")
    @PreAuthorize("hasAuthority('users:read')")
    public String getUsersById(@RequestParam(name = "id", required = false, defaultValue = "") Long id, Model model){
        User user = userDao.getUserByIdNamed(id);
        model.addAttribute("user", user);
        return "user-id";
    }

}
