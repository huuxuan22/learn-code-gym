package Service.CService;

import Model.KhachHang.KhachHang;
import Model.KhachHang.KhachNuocNgoai;
import Model.KhachHang.KhachTrongNuoc;
import Repo.CRepository.KhachHangRepo;
import Repo.IRepository.IKhachHangRepo;
import Service.IService.IKhachHangService;
import util.WriteAndReadFile;

import java.util.ArrayList;
import java.util.Scanner;

public class KhachHangService implements IKhachHangService<KhachHang> {
    private final Scanner scanner = new Scanner(System.in);
    public  IKhachHangRepo<KhachHang> KhachHangRepo =  new KhachHangRepo();
    public static String PATH_FILE_KHACHHANG = "D:\\Module_2\\LuyenTap_MVC\\luyenTap\\src\\File\\KhachHang";
    @Override
    public ArrayList<KhachHang> getAll() {
       return KhachHangRepo.getAll();
    }

    @Override
    public void add(KhachHang khachHang) {
        KhachHangRepo.add(khachHang);
    }


    @Override
    public void addKhachTrongNuoc() {
        //String maKhachHang, String hoTen, String loaiKhach, int dinhMuc
        System.out.println("Mã khashc hàng: ");
        String maKhachHang = scanner.nextLine();
        System.out.println("Họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.println("Loại Khách hàng: ");
        String loaiKhach = scanner.nextLine();
        System.out.println("ĐỊnh mức: ");
        int dinhMuc = Integer.parseInt(scanner.nextLine());
        KhachHangRepo.add(new KhachTrongNuoc(maKhachHang,hoTen,loaiKhach,dinhMuc));
    }

    @Override
    public void addKhachNgoaiNuoc() {
        //hoTen + "," + maKhachHang + ","+quocTich
        System.out.println("HỌ tên: ");
        String hoTen  = scanner.nextLine();
        System.out.println("Mã khách hàng: ");
        String maKhachHang = scanner.nextLine();
        System.out.println("Quốc tich: ");
        String quocTich = scanner.nextLine();
        KhachHangRepo.add(new KhachNuocNgoai(hoTen,maKhachHang,quocTich));
    }

    @Override
    public void displayKhachHang() {
        ArrayList<KhachHang> khachHangList = getAll();
        int count = 0;
        System.out.println("================DANH SÁCH KHÁCH HÀNG==================");
        for (int i=0;i<khachHangList.size();i++){
            if (khachHangList.get(i) instanceof KhachNuocNgoai){
                System.out.println("Khách hàng thứ: "+ (i+1));
                System.out.println("họ tên: "+ khachHangList.get(i).getHoTen());
                System.out.println("Mã khách hàng: "+ khachHangList.get(i).getMaKhachHang());
                System.out.println("quốc tịch: "+ (((KhachNuocNgoai)khachHangList.get(i)).getQuocTich()));
                System.out.println("-------------------------");
            }else{
                System.out.println("Khách hàng thứ: "+ (i+1));
                System.out.println("Mã khashc hàng: "+ khachHangList.get(i).getMaKhachHang());
                System.out.println(("họ tên: "+ khachHangList.get(i).getHoTen()));
                System.out.println(("Loại khách: "+ ((KhachTrongNuoc)khachHangList.get(i)).getLoaiKhach()));
                System.out.println(("Định mức: "+ ((KhachTrongNuoc)khachHangList.get(i)).getDinhMuc()));
                System.out.println("-------------------------");
            }
        }
    }

    @Override
    public void timKiemKhachHang() {
        ArrayList<KhachHang> khachHangsList = getAll();
        System.out.println("Nhập vào mã khashc hàng: ");
        String maKhachHang = scanner.nextLine();
        boolean flag = true;
        for (int i=0;i<khachHangsList.size();i++){
            if (maKhachHang.equals(khachHangsList.get(i).getMaKhachHang())){
                if (khachHangsList.get(i) instanceof KhachNuocNgoai ){
                    System.out.println("Họ tên: "+ khachHangsList.get(i).getHoTen());
                    System.out.println("max  khách hàng: "+ khachHangsList.get(i).getMaKhachHang());
                    System.out.println("Quốc tích: "+ ((KhachNuocNgoai) khachHangsList.get(i)).getQuocTich());
                    flag = false;
                }else {
                    System.out.println("Họ tên: "+ khachHangsList.get(i).getHoTen());
                    System.out.println("max  khách hàng: "+ khachHangsList.get(i).getMaKhachHang());
                    System.out.println("Loại khách hàng: "+ ((KhachTrongNuoc)khachHangsList.get(i)).getLoaiKhach());
                    System.out.println("Định mức: "+ ((KhachTrongNuoc)khachHangsList.get(i)).getDinhMuc());
                    flag = false;
                }
            }
        }
        if (flag){
            System.out.println("Không tìm thấy khsahc hàng");
        }
    }


}
