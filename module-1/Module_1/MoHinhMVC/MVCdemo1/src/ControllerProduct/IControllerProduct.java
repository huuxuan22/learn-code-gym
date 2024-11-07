package ControllerProduct;

import ModelProduct.Product;

import java.util.ArrayList;

public interface IControllerProduct {
    ArrayList<Product> getAll();
    void add(Product product);
}
