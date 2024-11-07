package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.dto.StudentDTO;
import com.example.demo.service.impl.IStudentService;
import com.example.demo.utils.DateConverter;
import com.example.demo.utils.DateConverts;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false,defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Student> studentPage = studentService.findAll(pageable);
        model.addAttribute("list",studentPage);
        return "page";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
       Student student = studentService.findById(id);
       studentService.delete(student);
       return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        Student student = studentService.findById(id);
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student,studentDTO);
        model.addAttribute("studentDTO",studentDTO);
        model.addAttribute("classList",studentService.findAll());
        return "form-update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        new StudentDTO().validate(studentDTO,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("studentDTO",studentDTO);
            model.addAttribute("classList",studentService.findAll());
            return "form-update";
        }
        String a = studentDTO.getNgaySinh();
        Date date = DateConverts.convertStringToSQLDate(a,"yyyy-MM-dd");
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setNgaySinh(date);
        student.setCanCuocCongDan(studentDTO.getCanCuocCongDan());
        student.setClazz(studentDTO.getClazz());
        student.setMsv(studentDTO.getMsv());
        student.setTen(studentDTO.getTen());
        studentService.save(student);
        return "redirect:/";
    }
    @GetMapping("/addNew")
    public String addNew(Model model) {
        model.addAttribute("studentDTO",new StudentDTO());
        model.addAttribute("classList",studentService.findAll());
        return "fomr-addNew";
    }

    @PostMapping("/addNew")
    public String addNew(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        new StudentDTO().validate(studentDTO,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("studentDTO",new StudentDTO());
            model.addAttribute("classList",studentService.findAll());
            return "fomr-addNew";
        }
        String a = studentDTO.getNgaySinh();
        Date date = DateConverts.convertStringToSQLDate(a,"yyyy-MM-dd");
        Student student = new Student();
        student.setNgaySinh(date);
        student.setCanCuocCongDan(studentDTO.getCanCuocCongDan());
        student.setClazz(studentDTO.getClazz());
        student.setMsv(studentDTO.getMsv());
        student.setTen(studentDTO.getTen());
        studentService.save(student);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam("valueSearch") String valueSearch,Model model){

    }
}
