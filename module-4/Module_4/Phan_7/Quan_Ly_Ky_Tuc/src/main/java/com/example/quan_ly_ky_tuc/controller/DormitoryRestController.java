package com.example.quan_ly_ky_tuc.controller;

import com.example.quan_ly_ky_tuc.dto.StudentDTO;
import com.example.quan_ly_ky_tuc.model.Student;
import com.example.quan_ly_ky_tuc.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DormitoryRestController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public ResponseEntity showList(@CookieValue(value = "counter",
            defaultValue = "0") Long counter,
                           Model model,
                           @RequestParam(required = false,defaultValue = "0") int page){



        Pageable pageable =  PageRequest.of(page,2);
        Page<Student> list = studentService.showList(pageable);
//            model.addAttribute("cookie",counter);
        model.addAttribute("list",list);
        model.addAttribute("currentPage",page);

//            List<Student> studentList = iStudentService.showList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Student> add(@RequestBody StudentDTO studentDTO){
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        studentService.add(student);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public  ResponseEntity<Student> update(@PathVariable("id") int id,@RequestBody StudentDTO studentDTO){
        Student student = new Student();
        Student existStudent = studentService.findById(id);
        if (existStudent == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(studentDTO,existStudent);
        studentService.update(existStudent);
        return  new ResponseEntity<>(existStudent,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> delete(@PathVariable("id") int id,@RequestBody StudentDTO studentDTO){
        Student student = studentService.findById(id);
//        System.out.println(student.getStudentId());
        if (student == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(studentDTO,student);
        studentService.delete(student);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
}
