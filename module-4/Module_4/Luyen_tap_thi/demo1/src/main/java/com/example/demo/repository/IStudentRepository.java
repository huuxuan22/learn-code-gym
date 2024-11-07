package com.example.demo.repository;


import com.example.demo.model.Student;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
