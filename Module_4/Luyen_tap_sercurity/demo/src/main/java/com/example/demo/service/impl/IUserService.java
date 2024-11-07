package com.example.demo.service.impl;

import com.example.demo.model.User;

public interface IUserService {
    User findByAccount(String account);
    void addUser(User user);
}
