package ControllerProduct;

import RepositoryProduct.TypeProductManagerRepository;
import ServiceProduct.TypeProductManagerService;

public class TypeProductManagerController {
    private TypeProductManagerService typeProductManagerService;

    public TypeProductManagerController(TypeProductManagerService typeProductManagerService) {
        this.typeProductManagerService = typeProductManagerService;
    }
    TypeProductManagerController(){

    }
}
