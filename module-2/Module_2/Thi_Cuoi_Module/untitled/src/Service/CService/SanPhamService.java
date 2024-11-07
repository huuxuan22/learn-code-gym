package Service.CService;

import Model.SanPham;
import Model.SanPhamNK;
import Model.SanPhamXK;
import Repo.CRepo.SanPhamRepo;
import Service.IService.ISanPhamService;
import Util.WriteAndReadFile;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPhamService implements ISanPhamService<SanPham> {
    private static final SanPhamRepo sanPhamRepo = new SanPhamRepo();
    private static final String Path_File_SanPhamXK = "D:\\Module_2\\Thi_Cuoi_Module\\untitled\\src\\File\\SanPhamXK.CSV";
    private static final String Path_File_SanPhamNK = "D:\\Module_2\\Thi_Cuoi_Module\\untitled\\src\\File\\SanPhamNK.CSV";
    private static final Scanner scanner = new Scanner(System.in);


    @Override
    public ArrayList<SanPhamNK> getAllNK() {
        return sanPhamRepo.getAllNK();
    }

    @Override
    public ArrayList<SanPhamXK> getAllXK() {
        return sanPhamRepo.getAllXK();
    }

    @Override
    public void addSPNK() {
        ArrayList<SanPhamNK> sanPhamNKS = getAllNK();
        int end = 0;
        end = 1+ sanPhamNKS.size();
        System.out.println("Id SP: id"+ end);
        String idSanPham = "id" + end;
        System.out.println("MÃ sản phầm: ");
        String maSanPham = scanner.nextLine();
        System.out.println("TEn san pham: ");
        String tenSP = scanner.nextLine();
        System.out.println("Giá bán: ");
        int giaBan = Integer.parseInt(scanner.nextLine());
        System.out.println("số luong: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhà sản xuát: ");
        String nhaSanXuat = scanner.nextLine();
        System.out.println("Giá nhập khẩu: ");
        int giaNhapKhau = Integer.parseInt(scanner.nextLine());
        System.out.println("Tỉnh thành: ");
        String tinhThanh = scanner.nextLine();
        System.out.println("Thuế nhập khẩu: ");
        int thue = Integer.parseInt(scanner.nextLine());
        sanPhamRepo.addSanPham(new SanPhamNK(idSanPham, maSanPham, tenSP, giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanh, thue));
    }

    @Override
    public void addSPXK() {
        ArrayList<SanPhamXK> sanPhamXKS = getAllXK();
        int end = 1+ sanPhamXKS.size();
        System.out.println("Id SP: id" + end);
        String idSanPham = "id"+end;
        System.out.println("MÃ sản phầm: ");
        String maSanPham = scanner.nextLine();
        System.out.println("TEn san pham: ");
        String tenSP = scanner.nextLine();
        System.out.println("Giá bán: ");
        int giaBan = Integer.parseInt(scanner.nextLine());
        System.out.println("số luong: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhà sản xuát: ");
        String nhaSanXuat = scanner.nextLine();
        System.out.println("Giá xuất khẩu: ");
        int giaXuatKhau = Integer.parseInt(scanner.nextLine());
        System.out.println("Quốc gia: ");
        String quocGia = scanner.nextLine();
        sanPhamRepo.addSanPham(new SanPhamXK(idSanPham, maSanPham, tenSP, giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGia));
    }

    @Override
    public void display() {
        ArrayList<SanPhamNK> sanPhamNKList = getAllNK();
        ArrayList<SanPhamXK> sanPhamXKList = getAllXK();
        System.out.println("Bạn muốn hiển thị xuất khẩu hay nhập khẩu: \n" +
                "1. Nhập khẩu \n" +
                "2. xuất khẩu ");
        int choose = Integer.parseInt(scanner.nextLine());
        if (choose == 1) {
            System.out.println("===========DANH SÁCH NHẬP KHẨU=============");
            for (int i = 0; i < sanPhamNKList.size(); i++) {
                System.out.println("Sant phẩm thứ: " + (i + 1));
                System.out.println("Id SP:" + sanPhamNKList.get(i).getIdSanPham());
                System.out.println("MÃ sản phầm: " + sanPhamNKList.get(i).getMaSanPham());
                System.out.println("TEn san pham: " + sanPhamNKList.get(i).getTenSanPham());
                System.out.println("Giá bán: " + sanPhamNKList.get(i).getGiaBan());
                System.out.println("số luong: " + sanPhamNKList.get(i).getSoLuong());
                System.out.println("Nhà sản xuát: " + sanPhamNKList.get(i).getNhaSanXuat());
                System.out.println("Giá nhập khẩu: " + sanPhamNKList.get(i).getGiaNhapKhau());
                System.out.println("Tỉnh thành: " + sanPhamNKList.get(i).getTinhThanh());
                System.out.println("Thuế nhập khẩu: " + sanPhamNKList.get(i).getThueNhapKhau());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("===========DANH SÁCH XUẤT KHẨU=============");
            for (int i = 0; i < sanPhamXKList.size(); i++) {
                System.out.println("Sant phẩm thứ: " + (i + 1));
                System.out.println("Id SP:" + sanPhamXKList.get(i).getIdSanPham());
                System.out.println("MÃ sản phầm: " + sanPhamXKList.get(i).getMaSanPham());
                System.out.println("TEn san pham: " + sanPhamXKList.get(i).getTenSanPham());
                System.out.println("Giá bán: " + sanPhamXKList.get(i).getGiaBan());
                System.out.println("số luong: " + sanPhamXKList.get(i).getSoLuong());
                System.out.println("Nhà sản xuát: " + sanPhamXKList.get(i).getNhaSanXuat());
                System.out.println("Giá nhập khẩu: " + sanPhamXKList.get(i).getGiaXuatKhau());
                System.out.println("Quốc gia nhập khẩu: " + sanPhamXKList.get(i).getQuocGia());
                System.out.println("---------------------");


            }
        }
    }

    @Override
    public void search() {

    }

    @Override
    public void delete() {
//        System.out.println("Nhập vào mã sản phẩm: ");
//        String maSanPham = scanner.nextLine();
//        ArrayList<SanPhamXK>sanPhamXKS = getAllXK();
//        ArrayList<SanPhamNK> sanPhamNKS = getAllNK();
//        ArrayList<SanPhamXK> sanPhamXKList = new ArrayList<>();
//        ArrayList<SanPhamNK> sanPhamNKList = new ArrayList<>();
//        ArrayList<String> listString = new ArrayList<>();
//        boolean flag = true;
//        for (int i  =0;i<sanPhamXKS.size();i++){
//            if (!maSanPham.equals(sanPhamNKS.get(i).getMaSanPham())){
//                sanPhamXKList.add(sanPhamXKS.get(i));
//            }else {
//                flag = false;
//            }
//        }
//        for (int i=0;i<sanPhamXKS.size();i++){
//            listString.add(sanPhamXKS.get(i).getInforToCSV());
//        }
//        WriteAndReadFile.writeFileToCSV(Path_File_SanPhamXK,listString,false);
//
//
//        /////
//        for (int i=0;i<sanPhamNKS.size();i++){
//            if (!maSanPham.equals(sanPhamNKS.get(i).getMaSanPham())){
//                sanPhamNKList.add(sanPhamNKS.get(i));
//            }else {
//                flag = false;
//            }
//        }
//        for (int i=0;i<sanPhamNKS.size();i++){
//            listString.add(sanPhamNKS.get(i).getInforToCSV());
//        }
//        WriteAndReadFile.writeFileToCSV(Path_File_SanPhamNK,listString,false);
//        if (flag){
//            System.out.println("Không tìm thấy.");
//        }
    }
}
