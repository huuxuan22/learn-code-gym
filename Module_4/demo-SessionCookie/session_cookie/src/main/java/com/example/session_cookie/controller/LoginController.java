package com.example.session_cookie.controller;

import com.example.session_cookie.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@SessionAttributes("user")
@RequestMapping("/")
public class LoginController {

    @ModelAttribute("user")
    public User getUser(@CookieValue(value = "name", required = false, defaultValue = "") String name,
                        @CookieValue(value = "email", required = false, defaultValue = "") String email) {
        return new User(name, email);
    }

    @GetMapping("")
    public ModelAndView showFormLogin(@ModelAttribute("user") User user) {
        if (!Objects.equals(user.getName(), "") && !Objects.equals(user.getEmail(), "")) {
            return new ModelAndView("/show-info", "user", new User(user.getName(), user.getEmail()));
        }
        return new ModelAndView("/login-form", "user", new User(user.getName(), user.getEmail()));
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user,
                        @RequestParam(value = "remember-me", required = false, defaultValue = "false") boolean remember,
                        HttpServletResponse httpServletResponse) {
        if (remember) {
            Cookie cookieName = new Cookie("name", user.getName());
            Cookie cookieEmail = new Cookie("email", user.getEmail());
            cookieName.setMaxAge(60);
            cookieEmail.setMaxAge(60);
            httpServletResponse.addCookie(cookieEmail);
            httpServletResponse.addCookie(cookieName);
        }
        return "/show-info";
    }

    @GetMapping("show")
    public String showInfo(@ModelAttribute("user") User user) {
        return "/show-info-2";
    }
}
