package Repo;

import Repo.InterfaceRepository.IMotobikeRepo;
import model.Car;
import model.Motobike;
import util.WriteAndReadFile;

import java.util.ArrayList;

import static util.WriteAndReadFile.readFileToCSV;
import static util.WriteAndReadFile.writeFileToCSV;

public class MotobikeRepo implements IMotobikeRepo<Motobike> {
    public static final String PATH_FILE_MOTOBIKE = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\Motobike.CSV";
    public static final String PATH_FILE_STRING = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\HangSanXuat.CSV";

    @Override
    public ArrayList<Motobike> getAll() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<Motobike> motobikeList = new ArrayList<>();
        stringList = readFileToCSV(PATH_FILE_MOTOBIKE);
        String [] array = null;
        for (String line : stringList){
            array = line.split(",");
            try {
                motobikeList.add(new Motobike(array[0],array[1],array[2],array[3],Integer.parseInt(array[4])));
            }catch (Exception e){
                System.out.println("Error casting to motobike in getAll");
            }
        }
        return motobikeList;
    }

    @Override
    public void add(Motobike motobike) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add(motobike.getInforToCSV());
        WriteAndReadFile.writeFileToCSV(PATH_FILE_MOTOBIKE,stringList,true);
    }

    @Override
    public ArrayList<String> stringList() {
        return WriteAndReadFile.readFileToCSV(PATH_FILE_STRING);
    }


}
