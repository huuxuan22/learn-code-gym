package Linkledist_ArrayList.LinkedList;

import Linkledist_ArrayList.ArrayList.Product;
import Linkledist_ArrayList.ArrayList.ProductManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Product> listProduct = new LinkedList<>();
        ProductManager productManager = new ProductManager(listProduct);
        System.out.println("1.thêm.\n" +
                "2. sửa\n" +
                "3. xóa\n" +
                "4. Hiển thị\n" +
                "5. Tìm kiếm\n" +
                "6. sắp xếp"+
                "7. thoát. "
        );
        System.out.println("dua ra lua chon cua ban. ");
        int luaChon = Integer.parseInt(sc.nextLine());
        while(luaChon != 7){
            switch (luaChon){// theem moi phan tu
                case 1:
                    productManager.add();
                    break;
                case 2:// cập nhật danh sách
                    System.out.println("Nhập vào id upDate: ");
                    int idUpdate = Integer.parseInt(sc.nextLine());
                    productManager.update(idUpdate);
                    break;
                case 3:// xóa theo id
                    System.out.println("Nhập vào id để xóa: ");
                    int idDelete = Integer.parseInt(sc.nextLine());
                    productManager.delete(idDelete);
                    break;
                case 4:
                    productManager.display();
                    break;
                case 5:
                    System.out.println("Nhập vào id để tìm kiếm: ");
                    int idSearch = Integer.parseInt(sc.nextLine());
                    productManager.search(idSearch);
                    break;
                case 6:
                    System.out.println("Danh sách sau khi xắp sếp: ");
                    productManager.sort();
                    productManager.display();
                    break;
            }
            System.out.println("Đưa ra lựa chọn của bạn");
            luaChon = Integer.parseInt(sc.nextLine());
        }
    }
}
