package Repo.CRepository;

import Model.HoaDon.HoaDon;
import Model.KhachHang.KhachHang;
import Repo.IRepository.IHoaDonRepo;
import util.WriteAndReadFile;

import java.util.ArrayList;

import static util.WriteAndReadFile.readFileToCSV;

public class HoaDonRepo implements IHoaDonRepo<HoaDon> {
    public static final String Path_File_HoaDon = "D:\\Module_2\\LuyenTap_MVC\\luyenTap\\src\\File\\HoaDon.CSV";


    @Override
    public ArrayList getAll() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<HoaDon> carList = new ArrayList<>();
        stringList = readFileToCSV(Path_File_HoaDon);
        String [] array = null;
        for (String line : stringList){
            array = line.split(",");
            try {
                HoaDon hoaDon = new HoaDon(array[0],array[1],array[2],Integer.parseInt(array[3]),Integer.parseInt(array[4]),Integer.parseInt(array[5]));
                carList.add(hoaDon);
            }catch (Exception e){
                System.out.println("Error casting to car in getAll"+ e.getMessage());
            }
        }
        return carList;
    }

    @Override
    public void add(HoaDon object) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add(((HoaDon)object).getInforToCSV());
        WriteAndReadFile.writeFileToCSV(Path_File_HoaDon,stringList,true);
    }
}
