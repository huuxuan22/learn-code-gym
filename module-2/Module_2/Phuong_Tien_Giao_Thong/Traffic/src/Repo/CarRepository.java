package Repo;

import Repo.InterfaceRepository.ICarRepo;
import Repo.InterfaceRepository.IVehicleRepo;
import model.Car;
import util.WriteAndReadFile;

import java.util.ArrayList;

import static util.WriteAndReadFile.readFileToCSV;
import static util.WriteAndReadFile.writeFileToCSV;

public class CarRepository implements ICarRepo<Car> {
    public static final String PATH_FILE_CAR = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\Car.CSV";
    public static final String PATH_FILE_STRING = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\HangSanXuat.CSV";
    @Override
    public ArrayList<Car> getAll() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<Car> carList = new ArrayList<>();
        stringList = readFileToCSV(PATH_FILE_CAR);
        String [] array = null;
        for (String line : stringList){
            array = line.split(",");
            try {
                //String controlPlate, String nameProduct, String yearManufacture, String orwer, int seatNumber, String vehicleType
                Car car = new Car(array[0],array[1],array[2],array[3],Integer.parseInt(array[4]),array[5]);
                carList.add(car);
            }catch (Exception e){
                System.out.println("Error casting to car in getAll"+ e.getMessage());
            }
        }
        return carList;
    }

    @Override
    public void add(Car car) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add(car.getInforToCSV());
        WriteAndReadFile.writeFileToCSV(PATH_FILE_CAR,stringList,true);
    }

    @Override
    public ArrayList<String> stringList() {
        return WriteAndReadFile.readFileToCSV(PATH_FILE_STRING);
    }
}
