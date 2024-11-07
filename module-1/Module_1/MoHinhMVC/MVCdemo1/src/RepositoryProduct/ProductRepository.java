package RepositoryProduct;

import ModelProduct.Product;

import java.util.ArrayList;

public class ProductRepository implements IRepositoryProduct{
    // tạo ra một mảng giả để lưu dữ liệu
    private static ArrayList<Product> product = new ArrayList<>();
    static {
        product.add(new Product("1234","Tran Duong Huu Xuan",123145,"Tot"));
        product.add(new Product("2345","Ngo Vu Hoan Hung",4567,"Kha"));
        product.add(new Product("3214","Tran Duong Kim Hung",4356,"Kha"));
    }

    @Override
    public ArrayList<Product> getALL() {
        return product;
    }

    @Override
    public void add(Product products) {
        product.add(products);
    }
}
