package com.example.quan_ly_ky_tuc.service;

import com.example.quan_ly_ky_tuc.model.User;
import com.example.quan_ly_ky_tuc.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepo iUserRepo;

    @Override
    public List<User> getAllUser() {
        return iUserRepo.findAll();
    }

    @Override
    public boolean findByIds(String accont) {
        return iUserRepo.findById(accont).isPresent();
    }

    @Override
    public User findById(String account) {
        return iUserRepo.findById(account).orElse(null);
    }
}
