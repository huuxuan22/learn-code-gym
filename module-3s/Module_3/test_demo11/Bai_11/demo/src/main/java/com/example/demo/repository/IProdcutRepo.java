package com.example.demo.repository;

import com.example.demo.model.Product;

import java.util.List;

public interface IProdcutRepo {
    boolean add(Product product);
    List<Product> findAll();
    boolean delete(int id);
    Product findById(int id);
    void update(Product product);
}
