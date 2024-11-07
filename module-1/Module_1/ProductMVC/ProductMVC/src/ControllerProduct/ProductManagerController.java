package ControllerProduct;

import RepositoryProduct.ProductManagerRepository;
import ServiceProduct.ProductManagerService;

public class ProductManagerController {
    private ProductManagerRepository productManagerService;

    public ProductManagerController(ProductManagerRepository productManagerService) {
        this.productManagerService = productManagerService;
    }
    public ProductManagerController(){

    }
}
