package com.example.demo2.repo;

import com.example.demo2.model.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChiTietDonHang extends JpaRepository<ChiTietDonHang,Integer> {
}
