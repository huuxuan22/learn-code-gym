package com.example.demo.service.impl;

import com.example.demo.model.DoanhMuc;
import com.example.demo.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITinTucService {
    Page<TinTuc> findAll(Pageable pageable);
    void deletedById(Integer id);
    List<DoanhMuc> getAllDoanhMuc();
    TinTuc addNew(TinTuc tinTuc);
    Page<TinTuc> search(String valueSearch,Pageable pageable);
    Page<TinTuc> searchTinTuc(String values,Pageable pageable);
}
