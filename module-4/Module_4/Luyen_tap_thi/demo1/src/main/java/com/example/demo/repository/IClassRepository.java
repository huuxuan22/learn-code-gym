package com.example.demo.repository;

import com.example.demo.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClassRepository extends JpaRepository<Class,Integer> {
    @Query (nativeQuery = true,value = "")
}
