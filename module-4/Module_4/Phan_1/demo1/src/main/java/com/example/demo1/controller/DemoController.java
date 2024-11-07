package com.example.demo1.controller;


import com.example.demo1.model.Demo;
import com.example.demo1.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class DemoController {
    @Autowired
    private IDemoService demoService;
    @GetMapping()
    public String showList(Model model){
        List<Demo> demoList = demoService.selectAllDemo();
        model.addAttribute("list",demoList);
        return "home";
    }
    @GetMapping("create")
    public String addNewDemo(){
        return "create";
    }
}
