package ViewProduct;

import ControllerProduct.ControllerProduct;
import ModelProduct.Product;

import java.util.ArrayList;

public class ViewProduct implements IViewProduct {
    private final ControllerProduct controllerProduct = new ControllerProduct();

    @Override
    public ArrayList<Product> getAll() {
        return controllerProduct.getAll();
    }

    @Override
    public void add(Product product) {

        controllerProduct.add(product);
    }
}
