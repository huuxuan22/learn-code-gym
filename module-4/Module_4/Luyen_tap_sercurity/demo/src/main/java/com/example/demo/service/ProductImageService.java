package com.example.demo.service;

import com.example.demo.model.ProductImage;
import com.example.demo.repository.IProductImageRepo;
import com.example.demo.service.impl.IProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService implements IProductImageService {
    @Autowired
    private IProductImageRepo productImageRepo;
    @Override
    public Page<ProductImage> getAllProductImage(Pageable pageable) {
        return productImageRepo.findAll(pageable);
    }
}
