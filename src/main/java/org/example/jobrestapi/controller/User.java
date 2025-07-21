package org.example.jobrestapi.controller;

import org.example.jobrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public String registerUser(@RequestBody org.example.jobrestapi.model.User user) {
        userService.SaveUser(user);
        return "User registered successfully";
    }
}
