package com.example.demo2.repo;

import com.example.demo2.model.MatHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatHangRepo extends JpaRepository<MatHang,Integer> {
    Page<MatHang> findAll(Pageable pageable);
}
