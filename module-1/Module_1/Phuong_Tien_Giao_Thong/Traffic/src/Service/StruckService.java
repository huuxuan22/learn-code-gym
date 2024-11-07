package Service;

import Repo.InterfaceRepository.IStruckRepo;
import Repo.StruckRepo;
import Service.Interface.IStruckService;
import model.Car;
import model.Struck;

import java.util.ArrayList;
import java.util.Scanner;

import static Service.CheckInput.chechInputStruck;
import static Service.CheckInput.checkInputCarCompany;
import static util.WriteAndReadFile.writeFileToCSV;

public class StruckService implements IStruckService<Struck> {
    public static final String PATH_FILE_STRUCK = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\Struck.CSV";
    private final IStruckRepo<Struck> struckRepo =  new StruckRepo();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public ArrayList<Struck> getAll() {
        return struckRepo.getAll();
    }

    @Override
    public void add() {
        ArrayList<String> danhSach = struckRepo.stringList();
        System.out.println("Biển kiểm soát: ");
        String controlPlate;
        boolean flag = true;
        do {
            controlPlate = scanner.nextLine();
            if (chechInputStruck(controlPlate)){
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
                flag =false;
            }else {
                System.out.println("Sai định dạng");
            }
        }while (flag);
        System.out.println("Năm sản xuất: ");
        String yearManufuture = scanner.nextLine();
        System.out.println("Chủ sở hữu: ");
        String orwer = scanner.nextLine();
        System.out.println("Trong tai: ");
        int wattage = Integer.parseInt(scanner.nextLine());
        struckRepo.add(new Struck(controlPlate,nameProduct,yearManufuture,orwer,wattage));
    }

    @Override
    public void display() {
        ArrayList<Struck> carList = struckRepo.getAll();
        System.out.println("===================DANH SÁCH STRUCK===============");
        for (int i=0;i<carList.size();i++){
            System.out.println("Struck: "+ (i+1));
            System.out.println("Biển kiểm soát: "+ carList.get(i).getControlPlate());
            System.out.println("Tên nhà sản xuất: "+ carList.get(i).getNameProduct());
            System.out.println("Năm sản xuất: "+ carList.get(i).getYearManufacture());
            System.out.println("Chủ sở hữu: "+ carList.get(i).getOrwer());
            System.out.println("trong tai: "+ carList.get(i).getWattage());
            System.out.println("--------------------------------");
        }
        System.out.println("===================================================");
    }

    @Override
    public void delete(String controlPlate) {
        ArrayList<Struck> struckList = struckRepo.getAll();
        ArrayList<String> stringList = new ArrayList<>();
        boolean flag = true;
        for (int i=0;i<struckList.size();i++){
            if (controlPlate.equals(struckList.get(i).getControlPlate())){
                struckList.remove(i);
                flag = false;
            }
        }
        if (!flag){
            for (int i=0;i<struckList.size();i++){
                stringList.add(struckList.get(i).getInforToCSV());
            }
            writeFileToCSV(PATH_FILE_STRUCK,stringList,false);
            System.out.println("xóa thành công");
        }else {
            System.out.println("Không có trong danh sách");
        }
    }

    @Override
    public boolean checkStruck(String id) {
        ArrayList<Struck> struckList = struckRepo.getAll();
        for (int i=0;i<struckList.size();i++){
            if (struckList.get(i).getControlPlate().equals(id)){
                return true;
            }
        }
        return false;
    }
}
