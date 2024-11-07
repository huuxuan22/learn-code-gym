package ViewProduct;

import ModelProduct.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUDProduct {
    public Scanner sc;
    // phương thức thêm thông tin của 1 người
    public void ADD(ArrayList<Product> product){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao id");
        String id =sc.nextLine();
        System.out.println("Nhap vao ten: ");
        String name = sc.nextLine();
        System.out.println("gia:");
        int donGia = Integer.parseInt(sc.nextLine());
        System.out.println("danh gia san pham: ");
        String danhGia = sc.nextLine();
        product.add(new Product(id,name,donGia,danhGia));
    }
    public void DISPLAY(ArrayList<Product> product){
        int i=1;
        for (Product products : product){
            System.out.println("thong tin cua nhan vien thu: "+ i);
            System.out.println(products.toString());
            i++;// tăng số lượng đếm theo phần tử lên
        }
    }
    public void UPDATE(ArrayList<Product> product,String idUpdate){
        for (Product products : product){
            if (products.getId().equals(idUpdate)){
                Scanner sc = new Scanner(System.in);
                System.out.println("Sửa lại tên: ");
                String ten = sc.nextLine();
                System.out.println("Sửa lại id: ");
                String id = sc.nextLine();
                System.out.println("Sửa lại giá: ");
                int gia = Integer.parseInt(sc.nextLine());
                System.out.println("Sửa lại đánh giá: ");
                String danhGia = sc.nextLine();
                products.setId(id);
                products.setName(ten);
                products.setGia(gia);
                products.setDanhGia(danhGia);
            }
        }
    }
    public ArrayList<Product> DELETE(ArrayList<Product> products, String tenMuonXoa){
       for (int i=0;i<products.size();i++){
           if (products.get(i).getName().equals(tenMuonXoa)){
               products.remove(i);
           }
       }return products;
    }
    public boolean findToName(ArrayList<Product> products,String nameFind){
        boolean flag = false;
        for (Product product:products){
            if(product.getName().equals(nameFind)){
                flag = true;
            }
        }
        return flag;
    }
}
