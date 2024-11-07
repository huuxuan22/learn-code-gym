package com.example.demo.controller;

import com.example.demo.exception.ExceptionWeb;
import com.example.demo.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@SessionAttributes("user")
@RequestMapping("/")
public class DemoController {
    @ModelAttribute("user")
    public User getUser(@CookieValue(value = "account",required = false,defaultValue = "") String account,
                        @CookieValue(value = "password,",required = false,defaultValue = "")String passWord){
        return  new User(account,passWord);
    }

    @GetMapping("")
    public ModelAndView showFormUpdate(@ModelAttribute("user") User user) {
        if (!Objects.equals(user.getAccount(), "") && !Objects.equals(user.getPassWord(), "")) {
            return new ModelAndView("/result", "user", new User(user.getAccount(), user.getPassWord()));
        }
        return new ModelAndView("login", "user", new User(user.getAccount(),user.getPassWord()));
    }

    @PostMapping("/login")
    public String showResult(@ModelAttribute("user") User user,
                             @RequestParam(value="remember-me",required = false,defaultValue = "") boolean remember,
                             HttpServletResponse httpServletResponse){
        if (remember) {
            Cookie cookieAccount = new Cookie("account",user.getAccount());
            Cookie cookiePassWord = new Cookie("password",user.getPassWord());
            cookieAccount.setMaxAge(12);
            cookiePassWord.setMaxAge(12);
            httpServletResponse.addCookie(cookieAccount);
            httpServletResponse.addCookie(cookiePassWord);
        }
        return "result";
    }
    @ExceptionHandler(ExceptionWeb.class)
    public String Err(){
        return "loi";
    }

}
