package com.example.demo.repository.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.IProdcutRepo;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProdcutRepo {
    private  static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"Nước ruwrq chén",3244,"Huu xuan"));
        products.add(new Product(2,"Nước ruwrq chén",3244,"Hoan hung"));
        products.add(new Product(3,"Nước ruwrq chén",3244,"Thanh thuong"));
        products.add(new Product(4,"Nước ruwrq chén",3244,"Duy khanh"));
        products.add(new Product(5,"Nước ruwrq chén",3244,"Trung tuan"));
        products.add(new Product(6,"Nước ruwrq chén",3244,"Thi Nhan"));
    }

    @Override
    public boolean add(Product product) {
        products.add(product);
        // kết nối database
        return true;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public boolean delete(int id) {
        for (Product product: products){
            if (product.getIdProduct() == id){
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product product) {
        for (int i=0;i<products.size();i++){
            if (products.get(i).equals(product)){
                products.get(i).setIdProduct(product.getIdProduct());
                products.get(i).setNameProduct(product.getNameProduct());
                products.get(i).setPrice(product.getPrice());
                products.get(i).setProducer(product.getProducer());
            }
        }

    }
}
