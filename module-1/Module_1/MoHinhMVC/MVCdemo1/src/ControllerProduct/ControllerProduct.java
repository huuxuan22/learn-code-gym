package ControllerProduct;

import ModelProduct.Product;
import ServiceProduct.ServiceProduct;

import java.util.ArrayList;

public class ControllerProduct implements IControllerProduct {
    private ServiceProduct serviceProduct = new ServiceProduct();
    @Override
    public ArrayList<Product> getAll() {
        return serviceProduct.getAll();
    }

    @Override
    public void add(Product product) {
        serviceProduct.add(product);
    }
}
