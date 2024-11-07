package Service.CService;

import Model.HoaDon.HoaDon;
import Repo.CRepository.HoaDonRepo;
import Repo.IRepository.IHoaDonRepo;
import Service.IService.IHoaDonService;
import util.WriteAndReadFile;

import java.util.ArrayList;
import java.util.Scanner;

public class HoaDonService implements IHoaDonService<HoaDon> {
    public static final String Path_File_HoaDon = "D:\\Module_2\\LuyenTap_MVC\\luyenTap\\src\\File\\HoaDon.CSV";

    public IHoaDonRepo<HoaDon> hoaDonRepo = new HoaDonRepo();
    protected Scanner scanner = new Scanner(System.in);

    @Override
    public void addHoaDon() {
        //String maHoaDon, String maKhachHang, String ngayRaHoaDon, int soLuong, int donGia, int thanhTien
        System.out.println("Mã hóa đơn: ");
        String hoaDon = scanner.nextLine();
        System.out.println("Mã khách hàng: ");
        String maKhachHang = scanner.nextLine();
        System.out.println("Ngay ra hoa don: ");
        String ngayRa = scanner.nextLine();
        System.out.println("Số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Don gia: ");
        int donGia = Integer.parseInt(scanner.nextLine());
        int thanhTien = donGia*soLuong;
        System.out.println("Thành tiền: "+ thanhTien);
        hoaDonRepo.add(new HoaDon(hoaDon,maKhachHang,ngayRa,soLuong,donGia,thanhTien));
    }

    @Override
    public void displayHoaDon() {
        ArrayList<HoaDon> hoaDonList = getAll();
        int count = 0;
        System.out.println("================DANH SÁCH KHASHC HÀNG===============");
        for (HoaDon hoaDon : hoaDonList){
            System.out.println("Hóa đơn thứ: "+(count+1));
            System.out.println("Mã hóa đơn: "+ hoaDon.getMaHoaDon());
            System.out.println("Mã khashc hàng: "+ hoaDon.getMaKhachHang());
            System.out.println("Ngay ra hoa don: "+ hoaDon.getNgayRaHoaDon());
            System.out.println("Số lượng: "+ hoaDon.getSoLuong());
            System.out.println("Don gia: "+ hoaDon.getDonGia());
            System.out.println("Thành tiền: "+ hoaDon.getThanhTien());
            count++;
            System.out.println("------------------------");
        }
    }

    @Override
    public void updateHoaDon() {
        System.out.println("Nhập vào mã hóa đơn: ");
        String maHoaDOn = scanner.nextLine();
        ArrayList<HoaDon> hoaDonsList = getAll();
        for (int i=0;i<hoaDonsList.size();i++){
            if (maHoaDOn.equals(hoaDonsList.get(i).getMaHoaDon())){
                System.out.println("Mã hóa đơn: ");
                hoaDonsList.get(i).setMaHoaDon(scanner.nextLine());
                System.out.println("Mã khashc hàng: ");
                hoaDonsList.get(i).setMaKhachHang(scanner.nextLine());
                hoaDonsList.get(i).setNgayRaHoaDon(scanner.nextLine());
                System.out.println("Số lượng: ");
                hoaDonsList.get(i).setSoLuong(Integer.parseInt(scanner.nextLine()));
                System.out.println("Don gia: ");
                hoaDonsList.get(i).setDonGia(Integer.parseInt(scanner.nextLine()));
                System.out.println("Thành tiền: ");
                hoaDonsList.get(i).setThanhTien(hoaDonsList.get(i).getDonGia()*hoaDonsList.get(i).getSoLuong());
            }
            ArrayList<String > stringList = new ArrayList<>();
            for (HoaDon hoaDon: hoaDonsList){
                stringList.add(hoaDon.getInforToCSV());
            }
            WriteAndReadFile.writeFileToCSV(Path_File_HoaDon,stringList,false);
        }
    }

    @Override
    public ArrayList<HoaDon> getAll() {
        return hoaDonRepo.getAll();
    }

    @Override
    public void add(HoaDon hoaDon) {
        hoaDonRepo.add(hoaDon);
    }
}
