package com.example.quan_ly_san_pham.repository.impl;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.repository.IProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepo implements IProductRepo {
    private static List<Product> productList = null;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Cường","Đẹp trai"));
        productList.add(new Product(2,"Cường","Đẹp trai"));
        productList.add(new Product(3,"Cường","Đẹp trai"));
        productList.add(new Product(4,"Cường","Đẹp trai"));
        productList.add(new Product(5,"Cường","Đẹp trai"));
        productList.add(new Product(6,"Cường","Đẹp trai"));
    }

    @Override
    public List<Product> selectAll() {
        return productList;
    }

    @Override
    public boolean delete(int id) {
        int i = 0;
        for (Product product : productList) {
            if (id == product.getId()){
                break;
            }
            i++;
        }
        return productList.remove(productList.get(i));
    }

    @Override
    public boolean add(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean update(Product product,int id) {
        int i = 0;
        boolean flag = true;
        for (Product products : productList) {
            if (id == products.getId()){
                break;
            }
            i++;
        }
        if (i>=(productList.size()-1)) {
            flag = false;
        } else {
            productList.remove(i);
            productList.add(product);
        }


        return flag;
    }

    @Override
    public List<Product> searchByName(String name) {
        return null;
    }

    @Override
    public Product findByID(int id) {
        int i = 0;
        for (Product product : productList) {
            if (id == product.getId()){
                break;
            }
            i++;
        }
        return productList.get(i);
    }
}
