package com.example.demo2.controller;

import com.example.demo2.model.MatHang;
import com.example.demo2.repo.IMatHangRepo;
import com.example.demo2.service.IMatHangService;
import com.example.demo2.service.MatHangService;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private IMatHangService matHangService;

    @GetMapping()
    public String showList(@CookieValue(value = "counter",defaultValue = "0")Long counter,
                            Model model,
                            @RequestParam(required = false,defaultValue = "0") int page){
        counter++;
        Cookie cookie = new Cookie("counter",counter.toString());

        Pageable pageable = PageRequest.of(page,2);
        Page<MatHang> list = matHangService.showList(pageable);
        model.addAttribute("list",list);
        model.addAttribute("currentPage",page);

        return "home";
    }
}
