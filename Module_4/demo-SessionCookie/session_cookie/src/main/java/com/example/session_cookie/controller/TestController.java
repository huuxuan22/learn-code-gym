package com.example.session_cookie.controller;

import com.example.session_cookie.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("")
    public ModelAndView showInfo(@SessionAttribute("user") User user) {
        return new ModelAndView("show-info-2","user",user);
    }
}
