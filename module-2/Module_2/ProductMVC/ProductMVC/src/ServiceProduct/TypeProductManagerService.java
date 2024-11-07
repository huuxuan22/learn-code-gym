package ServiceProduct;

import RepositoryProduct.ProductManagerRepository;
import RepositoryProduct.TypeProductManagerRepository;
import model.Class.TypeProduct;

import java.util.ArrayList;

public class TypeProductManagerService {
    private TypeProductManagerRepository typeProductManagerRepository;

    public TypeProductManagerService(TypeProductManagerRepository typeProductManagerRepository) {
        this.typeProductManagerRepository = typeProductManagerRepository;
    }
    public TypeProductManagerService(){}
    void  showAllId(){
        ArrayList<TypeProduct> temp = typeProductManagerRepository.getAll();
    }
}

