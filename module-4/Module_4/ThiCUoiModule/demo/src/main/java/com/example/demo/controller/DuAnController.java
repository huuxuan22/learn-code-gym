package com.example.demo.controller;

import com.example.demo.model.DoanhNghiep;
import com.example.demo.model.DuAn;
import com.example.demo.model.dto.DuAnDTO;
import com.example.demo.service.impl.IDuAnService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

@Controller
@RequestMapping("")
public class DuAnController {
    @Autowired
    private IDuAnService duAnService;
    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false,defaultValue = "0")int page){
        Sort sort = Sort.by("id_doanh_nghiep").descending();
        Pageable pageable = PageRequest.of(page,3);
        Page<DuAn> duAnList = duAnService.findAll(pageable);
        model.addAttribute("list",duAnList);
        model.addAttribute("currentPage",page);
        return "home";
    }
    @GetMapping("/addNew")
    public String add(Model model){
        model.addAttribute("duAnDTO",new DuAnDTO());
        model.addAttribute("listDoanhNghiep",duAnService.findAllDoanhNghiep());
        return "add-new";
    }

    @PostMapping("/addNew")
    public String add(@Valid @ModelAttribute("duAnDTO") DuAnDTO duAnDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes,
                      Model model) {
        new DuAnDTO().validate(duAnDTO,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("duAnDTO",new DuAnDTO());
            model.addAttribute("listDoanhNghiep",duAnService.findAllDoanhNghiep());
            return "add-new";
        }
        String a = duAnDTO.getNgayDangKi();
        Date date = DateConvert.convertStringToSQLDate(a,"yyyy-MM-dd");
        DuAn duAn = new DuAn();
//        String maDuAn, String tenDuAn, Long kinhPhi, String moTaDuAn, Integer thoiGianDangKi, Date ngayDangKi, DoanhNghiep
//        doanhNghiep
        duAn.setMaDuAn(duAnDTO.getMaDuAn());
        duAn.setTenDuAn(duAnDTO.getTenDuAn());
        duAn.setKinhPhi(duAnDTO.getKinhPhi());
        duAn.setMaDuAn(duAnDTO.getMoTaDuAn());
        duAn.setThoiGianDangKi(duAnDTO.getThoiGianDangKi());
        duAn.setNgayDangKi(date);
        duAn.setDoanhNghiep(duAnDTO.getDoanhNghiep());
        duAnService.save(duAn);
        return "redirect:/";

    }
    @PostMapping("/search")
    public String search(@RequestParam("search") String valueSearch,Model model, @RequestParam(required = false,defaultValue = "0")int page){
        Pageable pageable = PageRequest.of(page,3);
        Page<DuAn> duAnList = duAnService.findByTenDuAn(valueSearch);
        model.addAttribute("list",duAnList);
        model.addAttribute("currentPage",page);
        return "home";
    }
}
