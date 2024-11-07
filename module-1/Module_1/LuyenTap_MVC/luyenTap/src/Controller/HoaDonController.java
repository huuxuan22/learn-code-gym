package Controller;

import Model.HoaDon.HoaDon;
import Model.KhachHang.KhachHang;
import Repo.IRepository.IKhachHangRepo;
import Service.CService.HoaDonService;
import Service.CService.KhachHangService;
import Service.IService.IHoaDonService;
import Service.IService.IKhachHangService;

import java.util.Scanner;

public class HoaDonController {
    private static final IHoaDonService<HoaDon> hoaDonService =  new HoaDonService();
    private static final IKhachHangService<KhachHang> khachHangServie =  new KhachHangService();
    public static void MenuService(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            System.out.println("1. Thêm mới khách hàng.\n" +
                    "2. Hiện thị thông tin khách hàng\n" +
                    "3. Tìm kiếm khách hàng\n" +
                    "4. Thêm mới hóa đơn\n" +
                    "5. Chỉnh sửa hóa đơn\n" +
                    "6. Hiện thị thông tin chi tiết hóa đơn\n" +
                    "7. Thoát" );
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    //thêm mới
                    int choose1 = 0;
                    do {
                        System.out.println("1. khách hàng trong nước\n" +
                                "2. Khach hàng ngoài nước\n" +
                                "3. thoát");
                        choose1 = Integer.parseInt(scanner.nextLine());
                        switch (choose1){
                            case 1:
                                khachHangServie.addKhachTrongNuoc();
                                break;
                            case 2:
                                khachHangServie.addKhachNgoaiNuoc();
                                break;
                        }
                    }while(choose1!= 3);

                    break;
                case 2:
                    // hiển thị
                    khachHangServie.displayKhachHang();
                    break;
                case 3:
                    // tìm kiếm
                    khachHangServie.timKiemKhachHang();
                    break;
                case 4:
                    // thêm mới
                    hoaDonService.addHoaDon();
                    break;
                case 5:
                    // chỉnh sửa
                    hoaDonService.updateHoaDon();
                    break;
                case 6:
                    // hiển thị hóa đơn
                    hoaDonService.displayHoaDon();
                    break;
            }
        }while(choose != 7);

    }


}
