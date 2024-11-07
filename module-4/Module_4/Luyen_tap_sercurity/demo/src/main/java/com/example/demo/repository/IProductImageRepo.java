package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductImageRepo extends JpaRepository<ProductImage,Integer> {
}
