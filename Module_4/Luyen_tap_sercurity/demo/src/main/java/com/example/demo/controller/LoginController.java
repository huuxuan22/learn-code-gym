package com.example.demo.controller;

import com.example.demo.common.EncryptPasswordUtils;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.CustomUserDetailsService;
import com.example.demo.service.impl.IRoleService;
import com.example.demo.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController("/api/login")
public class LoginController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/createAccount")
    public ResponseEntity createStaff(@RequestBody User users){
        String passWord = users.getPassWord();
        String account = users.getAccount();
        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();
        customUserDetailsService.loadUserByUsername(account);
        if (userService.findByAccount(account) != null){
            users.setPassWord(EncryptPasswordUtils.EncryptPassWordUtils(passWord));
            List<Role> roleList = new ArrayList<>();
            roleList.add(roleService.findByRoleName("admin"));
            users.setRoles(roleList);
            userService.addUser(users);
            return  ResponseEntity.status(HttpStatus.CREATED).body("Tạo tài khoản thành công");
        }
        return  ResponseEntity.status(HttpStatus.CONFLICT).body("Tài khoản đã tồn tại");
    }
}
