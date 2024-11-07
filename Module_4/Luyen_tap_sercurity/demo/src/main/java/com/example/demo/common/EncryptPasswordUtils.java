package com.example.demo.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPasswordUtils {
    public static  String EncryptPassWordUtils(String passWord){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return  encoder.encode(passWord);
    }

    public static boolean ParseEncrypt(String passWord, String currentPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return  encoder.matches(currentPassword,passWord);
    }
}
