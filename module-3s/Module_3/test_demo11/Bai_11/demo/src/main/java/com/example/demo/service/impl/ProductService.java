package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.IProdcutRepo;
import com.example.demo.repository.impl.ProductRepo;
import com.example.demo.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private final IProdcutRepo prodcutRepo = new ProductRepo();


    @Override
    public List<Product> findAll() {
        return prodcutRepo.findAll();
    }

    @Override
    public boolean add(Product student) {
        return prodcutRepo.add(student);
    }

    @Override
    public boolean delete(int id) {
         return prodcutRepo.delete(id);
    }

    @Override
    public Product findById(int id) {
        return prodcutRepo.findById(id);
    }

    @Override
    public void update(Product product) {
        prodcutRepo.update(product);
    }
}
