package RepositoryProduct;

import model.Class.Product;
import model.Class.TypeProduct;
import model.Interface.IManager;
import model.Interface.Isort;

import java.util.ArrayList;

public class TypeProductManagerRepository implements Isort, IManager {
    private ArrayList<TypeProduct> typeProducts;

    public TypeProductManagerRepository(ArrayList<TypeProduct> typeProducts) {
        this.typeProducts = typeProducts;
    }

    @Override
    public void add(Object o) {
        typeProducts.add((TypeProduct) o);
    }

    @Override
    public TypeProduct search(int id) {
        for (TypeProduct typeProduct : typeProducts){
            if (typeProduct.getId()==id){
                return typeProduct;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        for (int i=0;i<typeProducts.size();i++){
            if (typeProducts.get(i).getId() == id){
                typeProducts.remove(i);
            }
        }
    }

    @Override
    public ArrayList<TypeProduct> search(String name) {
        ArrayList<TypeProduct> productSearch = new ArrayList<>();
        for (TypeProduct productBrowser : typeProducts){
            if(productBrowser.getName().equals(name)){
                productSearch.add(productBrowser);
            }
        }
        return productSearch;
    }

    @Override
    public ArrayList<TypeProduct> getAll() {
        return typeProducts;
    }

    @Override
    public void displayAll() {
        System.out.println(typeProducts);
    }

    @Override
    public void sortByID() {
        for (int i=0;i<typeProducts.size()-1;i++){
            for (int j=i+1;j<typeProducts.size()-1-i;j++){
                if (typeProducts.get(j).getId() > typeProducts.get(j+1).getId()){
                    TypeProduct temp = typeProducts.get(i);
                    typeProducts.set(j,typeProducts.get(j+1));
                    typeProducts.set(j+1,temp);
                }
            }
        }
    }

    @Override
    public void sortByID(boolean reserve) {
        if (!reserve){
            for (int i=0;i<typeProducts.size()-1;i++){
                for (int j=i+1;j<typeProducts.size()-1-i;j++){
                    if (typeProducts.get(j).getId() > typeProducts.get(j+1).getId()){
                        TypeProduct temp = typeProducts.get(i);
                        typeProducts.set(j,typeProducts.get(j+1));
                        typeProducts.set(j+1,temp);
                    }
                }
            }
        }else{
            for (int i=0;i<typeProducts.size()-1;i++){
                for (int j=i+1;j<typeProducts.size()-1-i;j++){
                    if (typeProducts.get(j).getId() < typeProducts.get(j+1).getId()){
                        TypeProduct temp = typeProducts.get(i);
                        typeProducts.set(j,typeProducts.get(j+1));
                        typeProducts.set(j+1,temp);
                    }
                }
            }
        }
    }
}
