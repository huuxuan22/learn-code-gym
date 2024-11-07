package RepositoryProduct;

import model.Class.Product;
import model.Interface.IManager;
import model.Interface.ISortPrice;
import model.Interface.Isort;

import java.util.ArrayList;

public class ProductManagerRepository implements IManager<Product>, ISortPrice, Isort {
    private ArrayList<Product> listProducts = new ArrayList<>();
    public ProductManagerRepository(){

    }

    public ProductManagerRepository(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    // thêm 1 sản phẩm vào trong danh sách
    @Override
    public void add(Product product) {
        listProducts.add(product);
    }

    // tìm kiếm danh sách theo id
    @Override
    public Product search(int id) {
        for (Product product: listProducts){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    // xóa thông tin của 1 sản phẩm theo id
    @Override
    public void remove(int id) {
        for (int i=0;i<listProducts.size();i++){
            if (listProducts.get(i).getId() == id){
                listProducts.remove(i);
            }
        }
    }

    // tìm kiếm sản phẩm theo tên
    @Override
    public ArrayList<Product> search(String name) {
        ArrayList<Product> productSearch = new ArrayList<>();
        for (Product productBrowser : listProducts){
            if(productBrowser.getName().equals(name)){
                productSearch.add(productBrowser);
            }
        }
        return productSearch;
    }

    // lấy tất cả thông tin có trong danh sách
    @Override
    public ArrayList<Product> getAll() {

        return listProducts;
    }

    // hển thị tất cả danh sách
    @Override
    public void displayAll() {
        System.out.println(listProducts.toString());
    }

    // sắp xếp danh sách theo giá cả
    @Override
    public void sortByPrice() {
        for (int i=0;i<listProducts.size()-1;i++){
            for (int j=i+1;j<listProducts.size()-1-i;j++){
                if (listProducts.get(j).getPrice() > listProducts.get(j+1).getPrice()){
                    Product temp = listProducts.get(i);
                    listProducts.set(j,listProducts.get(j+1));
                    listProducts.set(j+1,temp);
                }
            }
        }
    }

    @Override
    public void sortByPrice(boolean reserve) {
        if (!reserve){
            for (int i = 0; i< r -1; i++){
                for (int j=i+1;j<reserve.size()-1-i;j++){
                    if (reserve.get(j).getPrice() > reserve.get(j+1).getPrice()){
                        Product temp = reserve.get(i);
                        reserve.set(j,reserve.get(j+1));
                        reserve.set(j+1,temp);
                    }
                }
            }
        }else{
            for (int i=0;i<reserve.size()-1;i++){
                for (int j=i+1;j<reserve.size()-1-i;j++){
                    if (reserve.get(j).getPrice() < reserve.get(j+1).getPrice()){
                        Product temp = reserve.get(i);
                        reserve.set(j,reserve.get(j+1));
                        reserve.set(j+1,temp);
                    }
                }
            }
        }
    }

    @Override
    public void sortByID() {
        for (int i=0;i<products.size()-1;i++){
            for (int j=i+1;j<products.size()-1-i;j++){
                if (products.get(j).getId() > products.get(j+1).getId()){
                    Product temp = products.get(i);
                    products.set(j,products.get(j+1));
                    products.set(j+1,temp);
                }
            }
        }
    }

    @Override
    public void sortByID(boolean reserve) {
        if (!reserve){
            for (int i=0;i<products.size()-1;i++){
                for (int j=i+1;j<products.size()-1-i;j++){
                    if (products.get(j).getId() > products.get(j+1).getId()){
                        Product temp = products.get(i);
                        products.set(j,products.get(j+1));
                        products.set(j+1,temp);
                    }
                }
            }
        }else{
            for (int i=0;i<products.size()-1;i++){
                for (int j=i+1;j<products.size()-1-i;j++){
                    if (products.get(j).getId() < products.get(j+1).getId()){
                        Product temp = products.get(i);
                        products.set(j,products.get(j+1));
                        products.set(j+1,temp);
                    }
                }
            }
        }
    }
}
