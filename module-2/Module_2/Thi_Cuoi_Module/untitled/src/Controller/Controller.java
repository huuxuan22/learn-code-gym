package Controller;

import Model.SanPham;
import Service.CService.SanPhamService;
import Service.IService.ISanPhamService;

import java.util.Scanner;

public class Controller {
    public static Scanner scanner = new Scanner(System.in);
    private static final ISanPhamService<SanPham> sanPhamService = new SanPhamService();
    public static void Menu(){
        int choose ;
        do {
            System.out.println("===============MENU================");
            System.out.println("1. Them moi\n" +
                    "2. xoa\n" +
                    "3. xem danh sach\n" +
                    "4. Tim kiem \n" +
                    "5. thoat");
            System.out.println("Đưa ra lựa chọn: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    // them moi
                    int chooses;
                    do {
                        System.out.println("1. Sản phẩm xuất khẩu \n" +
                                "2. Sản phẩm nhập khẩu \n" +
                                "3. Thoát. ");
                         chooses = Integer.parseInt(scanner.nextLine());
                         switch (chooses){
                             case 1:
                                 sanPhamService.addSPXK();
                                 break;
                             case 2:
                                 sanPhamService.addSPNK();
                                 break;
                         }
                    }while (chooses!= 3);
                    break;
                case 2:
                    // xoa
                    sanPhamService.delete();
                    break;
                case 3:
                    sanPhamService.display();
                    break;
                case 4:
                    // tim kiem
                    break;
                case 5:
                    // thoat
                    break;
            }
        }while (choose !=5);
    }
}
