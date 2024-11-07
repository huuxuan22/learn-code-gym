package com.example.ung_dung_nge_nhac.controller;

import com.example.ung_dung_nge_nhac.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MusicAppController {
    @Autowired
    private IMusicAppService musicAppService;
    @GetMapping()
    public String showList(Model model){
        model.addAttribute("list",musicAppService.selectAllSong());
        return "home";
    }
}
