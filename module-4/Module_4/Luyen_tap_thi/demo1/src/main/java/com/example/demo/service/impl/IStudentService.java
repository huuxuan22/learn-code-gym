package com.example.demo.service.impl;

import com.example.demo.model.Class;
import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);
    void delete(Student student);
    Student findById(Integer id);
    List<Class> findAll();
    void save(Student student);
    Page<Student> find(String valueSearch, Pageable pageable);
}
