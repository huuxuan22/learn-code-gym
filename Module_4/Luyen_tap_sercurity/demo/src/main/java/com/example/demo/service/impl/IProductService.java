package com.example.demo.service.impl;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getAllProductService(Pageable pageable);
    void deleteById(Integer id);
}
