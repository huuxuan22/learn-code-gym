package RepositoryProduct;

import ModelProduct.Product;

import java.util.ArrayList;

public interface IRepositoryProduct {
    ArrayList<Product> getALL();
    void add(Product product);
}
