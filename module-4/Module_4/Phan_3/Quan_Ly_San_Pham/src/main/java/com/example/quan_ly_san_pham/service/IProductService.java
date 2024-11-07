package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> selectAll();
    public boolean delete(int id);
    public boolean add(Product product);
    public boolean update(Product product,int id);
    public List<Product> searchByName(String name);
    public Product findById(int id);
}
