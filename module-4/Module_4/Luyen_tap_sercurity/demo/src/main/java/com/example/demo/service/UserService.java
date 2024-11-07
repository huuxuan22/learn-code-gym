package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User findByAccount(String account) {
        return userRepository.findUserByAccount(account);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
