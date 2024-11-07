package com.example.demo.config;

import com.example.demo.common.EncryptPasswordUtils;
import com.example.demo.model.Role;
//import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (roleRepository.findByName("ROLE_STUDENT") == null) {
            roleRepository.save(new Role("ROLE_STUDENT"));
        }

        if (roleRepository.findByName("ROLE_TEACHER") == null) {
            roleRepository.save(new Role("ROLE_TEACHER"));
        }

        //them admin
        if (userRepository.findByAccount("huuxuan:1202") == null) {
            User admin = new User();
            admin.setAccount("huuxuan:1202");
            // mã hóa mật khẩu
            admin.setPassWord(EncryptPasswordUtils.EncryptPasswordUtils("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_STUDENT"));
            // roles.add(roleRepository.findByName("ROLE_USER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        //Them user
        if (userRepository.findByAccount("NgoVuHoanHung123") == null) {
            User user = new User();
                user.setAccount("NgoVuHoanHung123");
            // mã hóa mật khẩu
            user.setPassWord(EncryptPasswordUtils.EncryptPasswordUtils("1234567"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_STUDENT"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
