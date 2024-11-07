package com.example.demo.reporitory;

import com.example.demo.model.DoanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoanhMucRepo extends JpaRepository<DoanhMuc,Integer> {
}
