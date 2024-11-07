package com.example.demo.controller;

import com.example.demo.model.TinTuc;
import com.example.demo.model.dto.TinTucDTO;
import com.example.demo.service.impl.ITinTucService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/")
public class TinTucController {
    @Autowired
    private ITinTucService tinTucService;
    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false,defaultValue = "0") int page){
        model.addAttribute("doanhMucList",tinTucService.getAllDoanhMuc());
        Pageable pageable = PageRequest.of(page,3);
        Page<TinTuc> studentPage = tinTucService.findAll(pageable);
        model.addAttribute("list",studentPage);
        model.addAttribute("currentPage",page);
        return "page";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idDelete") Integer id){
        tinTucService.deletedById(id);
        return "redirect:/";
    }


    @GetMapping("/addNew")
    public String addNew(Model model){
        model.addAttribute("doanhMucList",tinTucService.getAllDoanhMuc());
        model.addAttribute("tinTuc",new TinTucDTO());
        return "add-new";
    }

    @PostMapping("/addNew")
    public String addNew(@Valid @ModelAttribute("tinTuc") TinTucDTO tinTucDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        new TinTucDTO().validate(tinTucDTO,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("studentDTO",new TinTucDTO());
            model.addAttribute("doanhMucList",tinTucService.getAllDoanhMuc());
            return "add-new";
        }
        TinTuc tinTuc = new TinTuc();
        Date date = DateConvert.convertStringToSQLDate(tinTucDTO.getNgayDangTin(),"\"\\\\d{4}-\\\\d{2}-\\\\d{2}\"");
        tinTuc.setTieuDe(tinTucDTO.getTieuDe());
        tinTuc.setDoanhMuc(tinTucDTO.getDoanhMuc());
        tinTuc.setPhongVien(tinTucDTO.getPhongVien());
        tinTuc.setNgayDangTin((java.sql.Date) date);
        tinTuc.setNoiDung(tinTucDTO.getNoiDung());
        tinTucService.addNew(tinTuc);
        return "redirect:/";
    }
    @PostMapping("/search")
    public String search(@RequestParam("tenTieuDe") String tenTieuDe,Model model,
                         @RequestParam("tenDoanhMuc") String tenDoanhMuc,
                         @RequestParam(required = false,defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,3);
        Page<TinTuc> studentPage = tinTucService.search(tenTieuDe,pageable);
        model.addAttribute("list",studentPage);
        model.addAttribute("currentPage",page);
        return "search";
    }
}
