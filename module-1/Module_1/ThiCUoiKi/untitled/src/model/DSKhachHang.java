package model;

import util.WriteAndReadFile;

import java.util.ArrayList;
import java.util.Scanner;

import static util.WriteAndReadFile.readFileToCSV;

public class DSKhachHang {
    private static final String Path_file_KhachHang = "D:\\Module_2\\ThiCUoiKi\\untitled\\src\\File\\KhachHang.TXT";
    private static final Scanner scanner = new Scanner(System.in);

    public static ArrayList<KhachHang> getAll(){
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<KhachHang> KhachList = new ArrayList<>();
        stringList = readFileToCSV(Path_file_KhachHang);
        String [] array = null;
        for (String line : stringList){
            array = line.split(",");
            try {
                //String maKhachHang, String hoTen, String ngayRaHoaDon, String SDT, String email, String quocTich, int soLuong, int donGia
                if (array.length == 8) {
                    //String controlPlate, String nameProduct, String yearManufacture, String orwer, int seatNumber, String vehicleType
                    KhachHangNN khachNuocNgoai = new KhachHangNN(array[0], array[1], array[2],array[3],array[4],array[5],Integer.parseInt(array[6]),Integer.parseInt(array[7]));
                    KhachList.add(khachNuocNgoai);
                }else{
                    //String maKhachHang, String hoTen,String ngayRaHoaDon, String SDT, String email, String doiTuongKH, int soLuong, int donGia, int dinhMuc
                    KhachHangVN khachTrongNuoc = new KhachHangVN(array[0],array[1],array[2],array[3],array[4],array[5],Integer.parseInt(array[6]),Integer.parseInt(array[7]),Integer.parseInt(array[8]));
                    KhachList.add(khachTrongNuoc);
                }
            }catch (Exception e){
                System.out.println("Error casting to car in getAll"+ e.getMessage());
            }
        }
        return KhachList;
    }
    public static void addKhachHang(KhachHang khachHang){
        ArrayList<String> stringList = new ArrayList<>();
        if (khachHang instanceof KhachHangVN){
            stringList.add(((KhachHangVN)khachHang).getInforToTXT());
        }else {
            stringList.add(((KhachHangNN)khachHang).getInforToTXT());
        }
        WriteAndReadFile.writeFileToCSV(Path_file_KhachHang,stringList,true);
    }
    public static void addKhacHangNN(){
        //String maKhachHang, String hoTen, String ngayRaHoaDon, String SDT, String email, String quocTich, int soLuong, int donGia
        System.out.println("Ma khach hang: ");
        String  maKhachHang = scanner.nextLine();
        System.out.println("ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.println("ngay Ra hoa don");
        String ngayRaHoaDOn = scanner.nextLine();
        System.out.println("SDT: ");
        String SDT = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("QUoc tich: ");
        String quocTich = scanner.nextLine();
        System.out.println("So Luong: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Don gia: ");
        int donGia = Integer.parseInt(scanner.nextLine());
        addKhachHang(new KhachHangNN(maKhachHang,hoTen,ngayRaHoaDOn,SDT,email,quocTich,soLuong,donGia));
    }
    public static void delete(){
        System.out.println("Nhập vào mã khách hàng để xóa: ");
        String maKhachHang = scanner.nextLine();
        ArrayList<KhachHang> khachHangList = getAll();
        ArrayList<KhachHang> khachhang = new ArrayList<>();
        for (int i=0;i<khachHangList.size();i++){
            if (!maKhachHang.equals(khachHangList.get(i).maKhachHang)){
                khachhang.add(khachHangList.get(i));
            }
        }
        ArrayList<String> stringList = new ArrayList<>();
        for (int i=0;i<khachhang.size();i++){
            stringList.add(khachHangList.get(i).getInforToTXT());
        }
        WriteAndReadFile.writeFileToCSV(Path_file_KhachHang,stringList,false);
    }
    public static void addKhachHangVn(){
        // //String maKhachHang, String hoTen,String ngayRaHoaDon, String SDT, String email, String doiTuongKH, int soLuong, int donGia, int dinhMuc
        System.out.println("Ma khach hang: ");
        String  maKhachHang = scanner.nextLine();
        System.out.println("ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.println("ngay Ra hoa don");
        String ngayRaHoaDOn = scanner.nextLine();
        System.out.println("SDT: ");
        String SDT = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Doi tuong khach hang: ");
        String doiTuongKh = scanner.nextLine();
        System.out.println("So luong: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Don gia: ");
        int donGia = Integer.parseInt(scanner.nextLine());
        System.out.println("Dinh muc: ");
        int dinhMuc = Integer.parseInt(scanner.nextLine());
        addKhachHang(new KhachHangVN(maKhachHang,hoTen,ngayRaHoaDOn,SDT,email,doiTuongKh,soLuong,donGia,dinhMuc));
    }
    public static void update(){
        ArrayList<KhachHang> khachHangsList = getAll();
        System.out.println("Nhập vào mã khách hàng để cập nhật: ");
        String maKhachHang = scanner.nextLine();
        boolean flag = true;
        for (int i=0;i<khachHangsList.size();i++){
            if(maKhachHang.equals(khachHangsList.get(i).getMaKhachHang())){
                if (khachHangsList.get(i) instanceof KhachHangVN){
                    System.out.println("Ma khach hang: ");
                    khachHangsList.get(i).setMaKhachHang(scanner.nextLine());
                    System.out.println("ho ten: ");
                    khachHangsList.get(i).setHoTen(scanner.nextLine());
                    System.out.println("ngay Ra hoa don");
                    khachHangsList.get(i).setNgayRaHoaDon(scanner.nextLine());
                    System.out.println("SDT: ");
                    khachHangsList.get(i).setSDT(scanner.nextLine());
                    System.out.println("Email: ");
                    khachHangsList.get(i).setEmail(scanner.nextLine());
                    System.out.println("Doi tuong khach hang: ");
                    ((KhachHangVN) khachHangsList.get(i)).setDoiTuongKH(scanner.nextLine());
                    System.out.println("So luong: ");
                    ((KhachHangVN) khachHangsList.get(i)).setSoLuong(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Don gia: ");
                    ((KhachHangVN) khachHangsList.get(i)).setDonGia(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Dinh muc: ");
                    ((KhachHangVN) khachHangsList.get(i)).setDinhMuc(Integer.parseInt(scanner.nextLine()));
                    flag = false;
                }else{
                    System.out.println("Ma khach hang: ");
                    khachHangsList.get(i).setMaKhachHang(scanner.nextLine());
                    System.out.println("ho ten: ");
                    khachHangsList.get(i).setHoTen(scanner.nextLine());
                    System.out.println("ngay Ra hoa don");
                    khachHangsList.get(i).setNgayRaHoaDon(scanner.nextLine());
                    System.out.println("SDT: ");
                    khachHangsList.get(i).setSDT(scanner.nextLine());
                    System.out.println("Email: ");
                    khachHangsList.get(i).setEmail(scanner.nextLine());
                    System.out.println("QUoc tich: ");
                    ((KhachHangNN)khachHangsList.get(i)).setQuocTich(scanner.nextLine());
                    System.out.println("So Luong: ");
                    ((KhachHangNN)khachHangsList.get(i)).setSoLuong(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Don gia: ");
                    ((KhachHangNN)khachHangsList.get(i)).setDonGia(Integer.parseInt(scanner.nextLine()));
                    flag = false;
                }
            }
            if (flag){
                System.out.println("Không có trong danh sách.");
            }else{
                ArrayList<String> stringList = new ArrayList<>();
                for (int j = 0;j<khachHangsList.size();j++){
                    stringList.add(khachHangsList.get(j).getInforToTXT());
                }
                WriteAndReadFile.writeFileToCSV(Path_file_KhachHang,stringList,false);
            }
        }
    }
    public static void search(){
        System.out.println("Nhập vào mã khách hàng: ");
        String maKhachHang = scanner.nextLine();
        ArrayList<KhachHang> khachHangsList = getAll();
        for (int i=0;i<khachHangsList.size();i++){
            if (maKhachHang.equals(khachHangsList.get(i).getMaKhachHang())){
                System.out.println(khachHangsList.get(i).toString());
            }
        }
    }
    public static void displayKhachHangVN(){
        ArrayList<KhachHang> khachHangsList = getAll();
        ArrayList<KhachHangVN> khachHangVNList = new ArrayList<>();
        for (int i=0;i<khachHangsList.size();i++){
            if (khachHangsList.get(i) instanceof  KhachHangVN){
                khachHangVNList.add((KhachHangVN) khachHangsList.get(i));
            }
        }
        System.out.println("=================DANH SÁCH KHÁCH HÀNG VN======================");
        for (int i=0;i<khachHangVNList.size();i++){
            System.out.println("Khách hàng thứ: "+ i);
            System.out.println("Ma khach hang: "+ khachHangVNList.get(i).getMaKhachHang());
            System.out.println("ho ten: "+khachHangVNList.get(i).getHoTen());
            System.out.println("ngay Ra hoa don"+khachHangVNList.get(i).getNgayRaHoaDon());
            System.out.println("SDT: "+khachHangVNList.get(i).getSDT());
            System.out.println("Email: "+khachHangVNList.get(i).getEmail());
            System.out.println("Doi tuong khach hang: "+khachHangVNList.get(i).getDoiTuongKH());
            System.out.println("So luong: "+khachHangVNList.get(i).getSoLuong());
            System.out.println("Don gia: "+khachHangVNList.get(i).getDonGia());
            System.out.println("Dinh muc: "+khachHangVNList.get(i).getDinhMuc());
            System.out.println("Tính thành tiền: "+ khachHangsList.get(i).tinhThanhTien());
            System.out.println("--------------------------");
        }
    }
    public static void displayKhachHangNN(){
        ArrayList<KhachHang> khachHangsList = getAll();
        ArrayList<KhachHangNN> khachHangNNList = new ArrayList<>();
        for (int i=0;i<khachHangsList.size();i++){
            if (khachHangsList.get(i) instanceof  KhachHangVN){
                khachHangNNList.add((KhachHangNN) khachHangsList.get(i));
            }
        }
        System.out.println("=================DANH SÁCH KHÁCH HÀNG VN======================");
        for (int i=0;i<khachHangNNList.size();i++){
            System.out.println("Khách hàng thứ: "+ i);
            System.out.println("Ma khach hang: "+ khachHangNNList.get(i).getMaKhachHang());
            System.out.println("ho ten: "+khachHangNNList.get(i).getHoTen());
            System.out.println("ngay Ra hoa don"+khachHangNNList.get(i).getNgayRaHoaDon());
            System.out.println("SDT: "+khachHangNNList.get(i).getSDT());
            System.out.println("Email: "+khachHangNNList.get(i).getEmail());
            System.out.println("Quốc tịch: "+khachHangNNList.get(i).getQuocTich());
            System.out.println("So luong: "+khachHangNNList.get(i).getSoLuong());
            System.out.println("Don gia: "+khachHangNNList.get(i).getDonGia());
            System.out.println("Thành tiền: "+khachHangNNList.get(i).tinhThanhTien());
            System.out.println("--------------------------");
        }
    }
}
