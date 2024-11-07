package model;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            System.out.println("========================MENU=====================");
            System.out.println("1. them moi khach hang\n" +
                    "2. xóa khách hàng theo mã \n" +
                    "3. Cập nhật \n" +
                    "4. tìm kiếm theo mã khách hàng \n" +
                    "5. thống kê theo khách hàng.\n" +
                    "6. Thoát");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    // thêm mới :
                    System.out.println("1. Khách hàng VN \n" +
                            "2. Khách hàng nước ngoài");
                    int chooses = Integer.parseInt(scanner.nextLine());
                    switch (chooses){
                        case 1:
                            DSKhachHang.addKhachHangVn();
                            break;
                        case 2:
                            DSKhachHang.addKhacHangNN();
                            break;
                    }
                    break;
                case 2:
                    // xóa
                    DSKhachHang.delete();
                    break;
                case 3:
                    //cập nhật
                    DSKhachHang.update();
                    break;
                case 4:
                    // tìm kiếm
                    DSKhachHang.search();
                    break;
                case 5:
                    // thống kê
                    System.out.println("1. hiển thị khách hàng vn\n" +
                            "2. hiển thị khashc hàng nước ngoài");
                    int chooses1 = Integer.parseInt(scanner.nextLine());
                    switch (chooses1){
                        case 1:
                            DSKhachHang.displayKhachHangNN();
                            break;
                        case 2:
                            DSKhachHang.displayKhachHangVN();
                            break;

                    }
                    break;
            }
        }while (choose != 6);
    }
}
