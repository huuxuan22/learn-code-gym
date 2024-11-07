package ViewProduct;

import ModelProduct.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static final int ADD = 1;
    static final int DELETE = 2;
    static final int UPDATE = 3;
    static final int DISPLAY = 4;
    static final int FIND = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CRUDProduct crudProduct = new CRUDProduct();
        ArrayList<Product> products = new ArrayList<>();
        int choose = 1;
        do {
            switch (choose) {
                case ADD:
                    System.out.println("Nhập vào thông tin.");
                    crudProduct.ADD(products);
                    break;
                case DISPLAY:
                    crudProduct.DISPLAY(products);
                    break;
                case UPDATE:
                    System.out.println("Nhap vao id de cap nhat: ");
                    String idUpdate = sc.nextLine();
                    crudProduct.UPDATE(products,idUpdate);
                    break;
                case DELETE:
                    System.out.println("Nhap vao ten de xoa");
                    String tenDEXoa = sc.nextLine();
                    products = crudProduct.DELETE(products,tenDEXoa);
                    System.out.println("thong tin sau khi xoa: "+ products.toString());
                    break;
                case FIND:
                    System.out.println("Nhap vao ten tim kiem");
                    String nameFind = sc.nextLine();
                    if(crudProduct.findToName(products,nameFind))
                        System.out.println("tim thay");
                    else  {
                        System.out.println("Khong tim thay");
                    }
                    break;
            }
            System.out.println("dua ra lua chon 1:thêm 2:xóa 3:cập nhật 4:hiển thị 5:tìm kiếm theo tên 6:thoat");
            choose = Integer.parseInt(sc.nextLine());
        }
            while (choose != 6);
    }
}
