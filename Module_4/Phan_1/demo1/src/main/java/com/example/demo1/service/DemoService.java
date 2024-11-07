package com.example.demo1.service;

import com.example.demo1.model.Demo;
import com.example.demo1.repository.DemoRepo;
import com.example.demo1.repository.IDemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DemoService implements IDemoService{
    @Autowired
    private IDemoRepo demoRepo;
    @Override
    public List<Demo> selectAllDemo() {
        return demoRepo.selectAllDemo();
    }
}
