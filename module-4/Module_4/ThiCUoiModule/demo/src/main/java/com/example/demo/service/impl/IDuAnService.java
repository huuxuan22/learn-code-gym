package com.example.demo.service.impl;

import com.example.demo.model.DoanhNghiep;
import com.example.demo.model.DuAn;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDuAnService {
    Page<DuAn> findAll(Pageable pageable);
    List<DoanhNghiep> findAllDoanhNghiep();
    void save(DuAn duAn);
    Page<DuAn> findByTenDuAn(String name);

}
