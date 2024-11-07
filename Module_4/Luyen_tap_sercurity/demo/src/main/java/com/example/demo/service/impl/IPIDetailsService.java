package com.example.demo.service.impl;

import com.example.demo.model.ProductImageDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPIDetailsService {
    Page<ProductImageDetails> getAllPID(Pageable pageable);
    int deleteByIdProduct(String  idProduct);
}
