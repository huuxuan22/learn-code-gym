package ServiceProduct;

import ModelProduct.Product;
import RepositoryProduct.ProductRepository;

import java.util.ArrayList;

public class ServiceProduct implements IServiceProduct{
    private ProductRepository productRepository = new ProductRepository();
    @Override
    public ArrayList<Product> getAll() {
        return productRepository.getALL();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }
}
