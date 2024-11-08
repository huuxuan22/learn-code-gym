package com.example.sping_boot.service;


import com.example.sping_boot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> showList(Pageable pageable);
    void add(Student student);
}
