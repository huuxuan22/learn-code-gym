package Service;

import Repo.CarRepository;
import Repo.InterfaceRepository.ICarRepo;
import Service.Interface.ICarService;
import model.Car;

import java.util.ArrayList;
import java.util.Scanner;

import static Service.CheckInput.checkInputCar;
import static Service.CheckInput.checkInputCarCompany;
import static util.WriteAndReadFile.writeFileToCSV;

public class CarService implements ICarService<Car> {
    public static final String PATH_FILE_CAR = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\Car.CSV";
    private final ICarRepo<Car> carRepository = new CarRepository();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public ArrayList<Car> getAll() {
        return carRepository.getAll();
    }

    @Override
    public void add(Car car) {

    }

    @Override
    public ArrayList<String> stringList() {
        return null;
    }

    @Override
    public void add() {
        ArrayList<String> danhSach = carRepository.stringList();
        System.out.println("Biển kiểm soát: ");
        String controlPlate;
        boolean flag = true;
        do {
            controlPlate = scanner.nextLine();
            if (checkInputCar(controlPlate)){
                flag = false;
            }else {
                System.out.println("Sai định dạng");
            }
        }while (flag);
        System.out.println("---------DANH SACH NHA SAN XUAT-------");
        for (String string : danhSach){
            System.out.println(string);
        }
        System.out.println("chon nhaf sản xuất: ");
        String nameProduct;
        flag = true;
        do {
            nameProduct = scanner.nextLine();
            if (checkInputCarCompany(nameProduct)){
                flag = false;
            }else {
                System.out.println("Sai định dạng");
            }
        }while (flag);
        System.out.println("Năm sản xuất: ");
        String yearManufuture = scanner.nextLine();
        System.out.println("Chủ sở hữu: ");
        String orwer = scanner.nextLine();
        System.out.println("Số chỗ ngồi: ");
        int seatNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Kiểu xe: ");
        String vehicleType = scanner.nextLine();
        carRepository.add(new Car(controlPlate,nameProduct,yearManufuture,orwer,seatNumber,vehicleType));
    }

    @Override
    public void display() {
        ArrayList<Car> carList = carRepository.getAll();
        System.out.println("===================DANH SÁCH CAR===============");
        for (int i=0;i<carList.size();i++){
            System.out.println("car: "+ (i+1));
            System.out.println("Biển kiểm soát: "+ carList.get(i).getControlPlate());
            System.out.println("Tên nhà sản xuất: "+ carList.get(i).getNameProduct());
            System.out.println("Năm sản xuất: "+ carList.get(i).getYearManufacture());
            System.out.println("Chủ sở hữu: "+ carList.get(i).getOrwer());
            System.out.println("Số chỗ ngồi: "+ carList.get(i).getSeatNumber());
            System.out.println("Kiểu xe: "+ carList.get(i).getVehicleType());
            System.out.println("---------------------------------------");
        }
        System.out.println("===============================================");
    }


    @Override
    public void delete(String controlPlate) {
        ArrayList<Car> carList = carRepository.getAll();
        ArrayList<String> stringList = new ArrayList<>();
        boolean flag = true;
        for (int i=0;i<carList.size();i++){
            if (controlPlate.equals(carList.get(i).getControlPlate())){
                carList.remove(i);
                flag = false;
            }
        }
        if (!flag){
            for (int i=0;i<carList.size();i++){
                stringList.add(carList.get(i).getInforToCSV());
            }
            writeFileToCSV(PATH_FILE_CAR,stringList,false);
        }
    }

    @Override
    public boolean checkCar(String id) {
        ArrayList<Car> carList = carRepository.getAll();
        for (int i=0;i<carList.size();i++){
            if (carList.get(i).getControlPlate().equals(id)){
                return true;
            }
        }
        return false;
    }
}
