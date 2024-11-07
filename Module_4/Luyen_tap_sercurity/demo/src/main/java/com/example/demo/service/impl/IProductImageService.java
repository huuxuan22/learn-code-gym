package com.example.demo.service.impl;

import com.example.demo.model.ProductImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductImageService {
    Page<ProductImage> getAllProductImage(Pageable pageable);
}
