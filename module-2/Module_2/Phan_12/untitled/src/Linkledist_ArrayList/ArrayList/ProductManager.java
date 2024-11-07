package Linkledist_ArrayList.ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManager {
    private LinkedList<Product> listProduct = new LinkedList<>();


    public ProductManager(LinkedList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public LinkedList<Product> getProducts() {
        return listProduct;
    }

    public void add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id mới: ");
        int idMoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Tên mới: ");
        String tenMoi = scanner.nextLine();
        Product product = new Product(idMoi,tenMoi);
        listProduct.add(product);
    }
    public void update(int idUpdate){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id mới: ");
        int idMoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Tên mới: ");
        String tenMoi = scanner.nextLine();
        Product product = new Product(idMoi,tenMoi);
        boolean flag = true;
        for (int i=0;i<listProduct.size();i++){
            if (listProduct.get(i).getId() == idUpdate){
                listProduct.get(i).setId(idMoi);
                listProduct.get(i).setName(tenMoi);
                flag = false;
            }
        }
        if (flag){
            System.out.println("không tìm thấy id.");
        }
    }
    public void delete(int idDelete){
        boolean flag = true;
        for (int i=0;i<listProduct.size();i++){
            if (listProduct.get(i).getId() == idDelete){
                listProduct.remove(i);
                flag = false;
            }
        }
        if (flag){
            System.out.println("Không tìm thấy id để xóa.");
        }
    }
    public void display(){
        for (int i=0;i<listProduct.size();i++){
            System.out.println(listProduct.get(i).toString());
        }
    }
    public void sort(){
        for (int i=0;i<listProduct.size()-1;i++){
            for (int j=i+1;j<listProduct.size()-i-1;j++){
                if (listProduct.get(j).getId() > listProduct.get(j+1).getId()){
                    Product temp = listProduct.get(j);
                    listProduct.set(j, listProduct.get(j+1));
                    listProduct.set(j+1,temp);
                }
            }
        }
    }
    public void search(int idSearch){
        boolean flag = true;
        for (int i=0;i<listProduct.size();i++){
            if (listProduct.get(i).getId() == idSearch){
                System.out.println(listProduct.get(i).toString());
                flag = false;
            }
        }
        if (flag){
            System.out.println("Không có trong danh sách.");
        }
    }
}
