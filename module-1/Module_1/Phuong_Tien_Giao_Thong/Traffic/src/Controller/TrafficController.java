package Controller;

import Service.CarService;
import Service.Interface.ICarService;
import Service.Interface.IMotobikeService;
import Service.Interface.IStruckService;
import Service.MotobikeService;
import Service.StruckService;
import model.Car;
import model.Motobike;
import model.Struck;
import model.Vehicle;
import util.WriteAndReadFile;

import java.util.ArrayList;
import java.util.Scanner;

public class TrafficController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ICarService<Car> carService = new CarService();
    private static final MotobikeService motobikeService = new MotobikeService();
    private static  final StruckService struckService = new StruckService();
    public static final String PATH_FILE_CAR = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\Car.CSV";
    public static final String PATH_FILE_MOTOBIKE = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\Motobike.CSV";
    public static final String PATH_FILE_STRUCK = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\Struck.CSV";

    public static void Menu(){
        int choose = 0;
        do {
            displayMenu();
            System.out.println("make your choice");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    // thêm mới
                    addNew();
                    break;
                case 2:
                    // hiển thị
                    display();
                    break;
                case 3:
                    // xóa
                    delete();
                    break;
            }
        }while (choose != 4);
    }
    public static void displayMenu(){
        System.out.println("1. Add new amenities \n" +
                "2. display  amenities\n" +
                "3. delete amenities \n" +
                "4. exits ");
    }
    public static void addNew(){
        int choose = 0;
        do {
            System.out.println("1. add new Struck: \n" +
                    "2. add new Motobike \n" +
                    "3. add new Car \n" +
                    "4. exits.");
            System.out.println("Make your choice");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    // thêm mới xe tải
                    struckService.add();
                    break;
                case 2:
                    // thêm mới mô tô bike
                    motobikeService.add();
                    break;
                case 3:
                    carService.add();
                    break;
            }
        }while (choose!= 4);
    }
    public static void display(){
        int choose = 0;
        do {
            System.out.println("1. display Struck: \n" +
                    "2. display Motobike \n" +
                    "3. display Car \n" +
                    "4. exits.");
            System.out.println("Make your choice");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    // hiển thị xe tải
                    struckService.display();
                    break;
                case 2:
                    // hiển thị mô tô bike
                    motobikeService.display();
                    break;
                case 3:
                    carService.display();
                    break;
            }
        }while (choose!= 4);
    }

    public static void delete(){
        String choose ;
        System.out.println("Nhap vao bien kiem soat: ");
        String controlPlateDelete = scanner.nextLine();
        if (carService.checkCar(controlPlateDelete)){
            System.out.println("Bạn có muốn xóa không ? Yes || No");
            choose = scanner.nextLine();
            if (choose.equalsIgnoreCase("yes")){
                carService.delete(controlPlateDelete);
                System.out.println("Xoa thanh cong 1 car.");
            }
        }else if(struckService.checkStruck(controlPlateDelete)){
            System.out.println("Bạn có muốn xóa không ? Yes || No");
            choose = scanner.nextLine();
            if (choose.equalsIgnoreCase("yes")){
                struckService.delete(controlPlateDelete);
                System.out.println("Xoa thanh cong 1 struck.");
            }
        } else if (motobikeService.checkMotobike(controlPlateDelete)) {
            System.out.println("Bạn có muốn xóa không ? Yes || No");
            choose = scanner.nextLine();
            if (choose.equalsIgnoreCase("yes")) {
                motobikeService.delete(controlPlateDelete);
                System.out.println("xoa thanh cong 1 motobike.");
            }
        }else {
            System.out.println("KHông có trong danh sách " );
        }
    }
}
