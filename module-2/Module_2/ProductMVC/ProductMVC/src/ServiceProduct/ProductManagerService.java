package ServiceProduct;

import RepositoryProduct.ProductManagerRepository;

public class ProductManagerService {
    private ProductManagerRepository ProductManagerRepository;

    public ProductManagerService() {
    }

    public ProductManagerService(ProductManagerRepository typeProductManagerRepository) {
        this.ProductManagerRepository = typeProductManagerRepository;
    }

}
