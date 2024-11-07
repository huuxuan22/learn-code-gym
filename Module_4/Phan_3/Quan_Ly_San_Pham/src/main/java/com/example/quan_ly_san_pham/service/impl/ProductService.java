package com.example.quan_ly_san_pham.service.impl;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.repository.IProductRepo;
import com.example.quan_ly_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo iProductRepo;
    @Override
    public List<Product> selectAll() {
        return iProductRepo.selectAll();
    }

    @Override
    public boolean delete(int id) {
        return iProductRepo.delete(id);
    }

    @Override
    public boolean add(Product product) {
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getMoTa());
        return iProductRepo.add(product);
    }

    @Override
    public boolean update(Product product,int id) {
        return iProductRepo.update(product,id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return null;
    }

    @Override
    public Product findById(int id) {
        return iProductRepo.findByID(id);
    }
}
