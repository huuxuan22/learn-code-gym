package com.example.demo2.repo;

import com.example.demo2.model.DonDatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDonDatHangRepo extends JpaRepository<DonDatHang,Integer> {
}
