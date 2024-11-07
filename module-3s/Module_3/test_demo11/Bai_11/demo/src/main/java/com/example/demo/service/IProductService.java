package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean add(Product student);
    boolean delete(int id);
    Product findById(int id);
    void update(Product product);
}
