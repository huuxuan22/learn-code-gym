package com.example.quan_ly_ky_tuc.service;

import com.example.quan_ly_ky_tuc.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserService {
    List<User> getAllUser();
    boolean findByIds(String accont);
    User findById(String accont);
}
