package Repo;

import Repo.InterfaceRepository.IStruckRepo;
import model.Motobike;
import model.Struck;
import util.WriteAndReadFile;

import java.util.ArrayList;

import static util.WriteAndReadFile.readFileToCSV;
import static util.WriteAndReadFile.writeFileToCSV;

public class StruckRepo implements IStruckRepo<Struck> {
    public static final String PATH_FILE_STRUCK = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\Struck.CSV";
    public static final String PATH_FILE_STRING = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\HangSanXuat.CSV";
    @Override
    public ArrayList<Struck> getAll() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<Struck> struckList = new ArrayList<>();
        stringList = readFileToCSV(PATH_FILE_STRUCK);
        String [] array = null;
        for (String line : stringList){
            array = line.split(",");
            try {
                struckList.add(new Struck(array[0],array[1],array[2],array[3],Integer.parseInt(array[4])));
            }catch (Exception e){
                System.out.println("Error casting to struck in getAll");
            }
        }
        return struckList;
    }

    @Override
    public void add(Struck struck) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add(struck.getInforToCSV());
        WriteAndReadFile.writeFileToCSV(PATH_FILE_STRUCK,stringList,true);
    }

    @Override
    public ArrayList<String> stringList() {
        return WriteAndReadFile.readFileToCSV(PATH_FILE_STRING);
    }


}
