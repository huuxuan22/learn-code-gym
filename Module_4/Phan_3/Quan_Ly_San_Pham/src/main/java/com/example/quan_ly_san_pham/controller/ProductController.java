package com.example.quan_ly_san_pham.controller;


import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String homePage(Model model){
        model.addAttribute("List",productService.selectAll());
        return "/home";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id,RedirectAttributes redirectAttributes) {
        boolean flag = productService.delete(id);
        if (flag) {
            redirectAttributes.addFlashAttribute("success","Xóa thành công");
        } else {
            redirectAttributes.addFlashAttribute("success","Xóa không thành công");
        }
        return "redirect:/";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
        boolean flag = productService.add(product);
        if (flag){
            redirectAttributes.addFlashAttribute("messageAdd","Thêm mới thành công");
        }else {
            redirectAttributes.addFlashAttribute("messageAdd","Thêm mới không thành công");
        }
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "update";
    }

    @PostMapping("updateProduct")
    public String update(@ModelAttribute("product") Product product) {
        productService.update(product,product.getId());
        return "redirect:/";
    }
}
