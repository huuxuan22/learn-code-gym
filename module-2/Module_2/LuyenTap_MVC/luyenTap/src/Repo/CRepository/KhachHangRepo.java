package Repo.CRepository;

import Model.KhachHang.KhachHang;
import Model.KhachHang.KhachNuocNgoai;
import Model.KhachHang.KhachTrongNuoc;
import Repo.IRepository.IKhachHangRepo;
import util.WriteAndReadFile;

import java.util.ArrayList;

import static util.WriteAndReadFile.readFileToCSV;

public class KhachHangRepo implements IKhachHangRepo<KhachHang> {
    public static final String PATH_FILE_KHACHHANG = "D:\\Module_2\\LuyenTap_MVC\\luyenTap\\src\\File\\KhachHang";
    @Override
    public ArrayList<KhachHang> getAll() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<KhachHang> KhachList = new ArrayList<>();
        stringList = readFileToCSV(PATH_FILE_KHACHHANG);
        String [] array = null;
        for (String line : stringList){
            array = line.split(",");
            try {
                if (array.length == 3) {
                    //String controlPlate, String nameProduct, String yearManufacture, String orwer, int seatNumber, String vehicleType
                    KhachNuocNgoai khachNuocNgoai = new KhachNuocNgoai(array[0], array[1], array[2]);
                    KhachList.add(khachNuocNgoai);
                }else{
                    KhachTrongNuoc khachTrongNuoc = new KhachTrongNuoc(array[0],array[1],array[2],Integer.parseInt(array[3]));
                    KhachList.add(khachTrongNuoc);
                }
            }catch (Exception e){
                System.out.println("Error casting to car in getAll"+ e.getMessage());
            }
        }
        return KhachList;
    }

    @Override
    public void add(KhachHang object) {
        ArrayList<String> stringList = new ArrayList<>();
        if (object instanceof KhachTrongNuoc){
            stringList.add(((KhachTrongNuoc)object).getInforToCSV());
        }else {
            stringList.add(((KhachNuocNgoai)object).getInforToCSV());
        }
        WriteAndReadFile.writeFileToCSV(PATH_FILE_KHACHHANG,stringList,true);
    }
}
