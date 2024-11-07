package ViewProduct;

import ModelProduct.Product;

import java.util.ArrayList;

public interface IViewProduct {
    ArrayList<Product> getAll();
    void add(Product product);
}
