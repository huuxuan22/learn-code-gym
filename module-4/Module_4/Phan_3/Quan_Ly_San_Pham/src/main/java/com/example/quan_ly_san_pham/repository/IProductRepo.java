package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductRepo {
    public List<Product> selectAll();
    public boolean delete(int id);
    public boolean add(Product product);
    public boolean update(Product product,int id);
    public List<Product> searchByName(String name);
    public Product findByID(int id);
}
