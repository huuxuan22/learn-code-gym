package com.example.demo.repository;

import com.example.demo.model.DuAn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDuAnRepository extends JpaRepository<DuAn,Integer> {
    List<DuAn> findByTenDuAn(String name);
}
