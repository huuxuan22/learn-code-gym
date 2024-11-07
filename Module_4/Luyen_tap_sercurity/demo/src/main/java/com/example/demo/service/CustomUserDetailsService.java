package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        User user =  userRepository.findUserByAccount(account);
        if (user != null) {
            List<SimpleGrantedAuthority> list = new ArrayList<>();
            for (Role role : user.getRoles()) {
                list.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            return new org.springframework.security.core.userdetails.User(user.getAccount()
                    , user.getPassWord(),
                    user.getRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getRoleName()))
                            .collect(Collectors.toList()));
        }
        else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}
