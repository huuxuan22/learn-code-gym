package Service;

import Repo.InterfaceRepository.IMotobikeRepo;
import Repo.MotobikeRepo;
import Service.Interface.IMotobikeService;
import model.Motobike;

import java.util.ArrayList;
import java.util.Scanner;

import static Service.CheckInput.checkInputCarCompany;
import static Service.CheckInput.checkInputMotobike;
import static util.WriteAndReadFile.writeFileToCSV;

public class MotobikeService implements IMotobikeService<Motobike> {
    public static final String PATH_FILE_MOTOBIKE = "D:\\Module_2\\Phuong_Tien_Giao_Thong\\Traffic\\src\\File\\Motobike.CSV";
    private final IMotobikeRepo<Motobike> motobikeRepo = new MotobikeRepo();
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public ArrayList<Motobike> getAll() {
        return motobikeRepo.getAll();
    }

    @Override
    public void add() {
        ArrayList<String> danhSach = motobikeRepo.stringList();
        System.out.println("Biển kiểm soát: ");
        String controlPlate = "";
        boolean flag = true;
        do {
            controlPlate = scanner.nextLine();
            if (checkInputMotobike(controlPlate)){
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
                System.out.println("sai định dạng ");
            }
        }while (flag);
        System.out.println("Năm sản xuất: ");
        String yearManufuture = scanner.nextLine();
        System.out.println("Chủ sở hữu: ");
        String orwer = scanner.nextLine();
        System.out.println("Cong suat: ");
        int payload = Integer.parseInt(scanner.nextLine());
        motobikeRepo.add(new Motobike(controlPlate,nameProduct,yearManufuture,orwer,payload));
    }

    @Override
    public void display() {
        ArrayList<Motobike> carList = motobikeRepo.getAll();
        System.out.println("===================DANH SÁCH MOTOBIKE===============");
        for (int i=0;i<carList.size();i++){
            System.out.println("môtobike: "+ (i+1));
            System.out.println("Biển kiểm soát: "+ carList.get(i).getControlPlate());
            System.out.println("Tên nhà sản xuất: "+ carList.get(i).getNameProduct());
            System.out.println("Năm sản xuất: "+ carList.get(i).getYearManufacture());
            System.out.println("Chủ sở hữu: "+ carList.get(i).getOrwer());
            System.out.println("Cong suat: "+ carList.get(i).getPayload());
            System.out.println("------------------------------");
        }
        System.out.println("===================================================");
    }

    @Override
    public void delete(String controlPlate) {
        ArrayList<Motobike> carList = motobikeRepo.getAll();
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
            writeFileToCSV(PATH_FILE_MOTOBIKE,stringList,false);
            System.out.println("xóa thành công");
        }else {
            System.out.println("Không có trong danh sách");
        }
    }

    @Override
    public boolean checkMotobike(String id) {
        ArrayList<Motobike> motobikeList = motobikeRepo.getAll();
        for (int i=0;i<motobikeList.size();i++){
            if (motobikeList.get(i).getControlPlate().equals(id)){
                return true;
            }
        }
        return false;
    }


}
