package ServiceProduct;

import ModelProduct.Product;

import java.util.ArrayList;

public interface IServiceProduct {
    ArrayList<Product> getAll();
    void add(Product product);
}
