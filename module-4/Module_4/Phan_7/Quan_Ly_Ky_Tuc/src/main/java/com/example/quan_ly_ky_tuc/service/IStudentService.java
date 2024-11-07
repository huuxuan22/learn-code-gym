package com.example.quan_ly_ky_tuc.service;

import com.example.quan_ly_ky_tuc.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
//    public List<Student> showList();
    public Student findById(int id);
    public Student update(Student student);
    public void delete(Student student);
    public void add(Student student);
    public Page<Student> searchByName(String name,Pageable pageable);
    Page<Student> showList(Pageable pageable);
    Page<Student> search(String param1,Pageable pageable);
}
