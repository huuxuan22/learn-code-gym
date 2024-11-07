package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/login","/"})
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String loginForm(){
        return "login";
    }


}