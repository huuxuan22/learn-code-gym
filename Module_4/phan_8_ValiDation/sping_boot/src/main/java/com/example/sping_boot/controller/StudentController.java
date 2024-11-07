package com.example.sping_boot.controller;

import com.example.sping_boot.model.Student;
import com.example.sping_boot.model.StudentDTO;
import com.example.sping_boot.service.ICodeGymClassService;
import com.example.sping_boot.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
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

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodeGymClassService iCodeGymClassService;

    @GetMapping()
    public String showList(Model model, @RequestParam(required = false, defaultValue = "0") int page) { // handle method
        Sort sort = Sort.by("name").descending();
        // Page là trang hiện tại
        // Pagesize là số lượng record mỗi trang
        // sort là trường cần sắp xếp.
        Pageable pageable = PageRequest.of(page, 5, sort);
        Page<Student> list = iStudentService.showList(pageable);
        // Tương tự request.setAttribute()
        model.addAttribute("list", list);
        return "result";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("listCodeGymClass", iCodeGymClassService.findAll());
        model.addAttribute("student", new StudentDTO());
        return "create";
    }

    @PostMapping("create")
    public String add(@Valid @ModelAttribute("student") StudentDTO studentDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes, Model model) {
        new StudentDTO().validate(studentDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("listCodeGymClass", iCodeGymClassService.findAll()); 
            return "create";
        } 
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        iStudentService.add(student);
        redirectAttributes.addFlashAttribute("msg", "Thành Công");
        return "redirect:/";
    }

}
