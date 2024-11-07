package Service.FacilityServvice;

import Repository.FacilityRepository.FacilityRepository;
import Service.InterfaceService.IFacilityService;
import Repository.InterfaceRepository.IFacilityRepository;
import model.Facility.Facility;
import model.Facility.House;
import model.Facility.Room;
import model.Facility.Villa;

import java.text.ParseException;
import java.util.*;

import static Service.FacilityServvice.CheckInputFacilityService.*;

public class FacilityService implements IFacilityService<Facility> {
    public static final IFacilityRepository<Facility> facilityRepository =new FacilityRepository();
    private final Scanner scanner = new Scanner(System.in);


    @Override

    public void add() {
    }

    @Override
    public void update(String maDichVu)  {

    }

    @Override
    public void delete(String maDichVu)  {
        try {
            facilityRepository.delete(maDichVu);
        } catch (ParseException e) {
            System.out.println("sai ở method delete trong FacilityService");
        }
    }

    @Override
    public ArrayList<Facility> getAll() {
        return null;
    }


    @Override
    public void display() {
        LinkedHashMap<Facility,Integer> facilityList = new LinkedHashMap<>();
        try{
            facilityList =  facilityRepository.getAllLinkedHashMap();
        }catch (Exception e){
            System.out.println("Sai ở chỗ display trong FacilityService"+ e.getMessage());
        }
        Iterator<Map.Entry<Facility,Integer>> iterator = facilityList.entrySet().iterator();
        int pos = 0;
        System.out.println("------------------Danh Sách FACILITY------------------");
        while(iterator.hasNext()){
            System.out.println("-----------------------------------------------------");
            System.out.println("Dịch vụ Facility thứ: "+ (pos + 1));
            Map.Entry<Facility,Integer> entry = iterator.next();
            Facility facility = entry.getKey();
            int count = entry.getValue();
            System.out.println("FACILITY" + "\t\t\t\t\t\t"+"Số lần");
            //String maDichVu, String tenDichVu, int dienTichSuDung, double chiPhi, int soLuongNguoi, String kieuThue, String dichVuMienPhi
            if (facility instanceof Room){
                System.out.println("-----------------------------------------------------");
                System.out.println("Mã dịch vụ: "+ facility.getMaDichVu() + "\t\t\t\t\t"+count);
                System.out.println("Tên dịch vụ: "+ facility.getTenDichVu());
                System.out.println("Diện tích sử dụng: " + facility.getDienTichSuDung());
                System.out.println("CHI phí: "+ facility.getChiPhi());
                System.out.println("Số lượng người: "+ facility.getSoLuongNguoi());
                System.out.println("Kiểu thuê: "+ facility.getKieuThue());
                System.out.println("Dịch vụ miễn phí: "+ ((Room) facility).getDichVuMienPhi());
            }else if (facility instanceof House){
                System.out.println("-----------------------------------------------------");
                // String kieuThue, String tieuChuanPhong, int soTang
                System.out.println("Mã dịch vụ: "+ facility.getMaDichVu() + "\t\t\t\t\t"+count);
                System.out.println("Tên dịch vụ: "+ facility.getTenDichVu());
                System.out.println("Diện tích sử dụng: " + facility.getDienTichSuDung());
                System.out.println("CHI phí: "+ facility.getChiPhi());
                System.out.println("Số lượng người: "+ facility.getSoLuongNguoi());
                System.out.println("Kiểu thuê: "+ facility.getKieuThue());
                System.out.println("Tiêu chuẩn phòng: "+ ((House) facility).getTieuChuanPhong());
                System.out.println("Số tầng: "+ ((House) facility).getSoTang());
            }
            else {
                System.out.println("-----------------------------------------------------");
                System.out.println("Mã dịch vụ: "+ facility.getMaDichVu() + "\t\t\t\t  "+count);
                System.out.println("Tên dịch vụ: "+ facility.getTenDichVu());
                System.out.println("Diện tích sử dụng: " + facility.getDienTichSuDung());
                System.out.println("CHI phí: "+ facility.getChiPhi());
                System.out.println("Số lượng người: "+ facility.getSoLuongNguoi());
                System.out.println("Kiểu thuê: "+ facility.getKieuThue());
                System.out.println("Tiêu chuẩn phòng: "+ ((Villa) facility).getTieuChuanPhong());
                System.out.println("Dien tich: "+ ((Villa)facility).getDienTich());
                System.out.println("Số tầng: "+ ((Villa) facility).getSoTang());
            }
            pos++;
        }
        System.out.println("------------------------------------------------------");
    }

    @Override
    public void addNewHouse() {
        System.out.println("NHẬP THÔN TIN CỦA FACILITY");
        // nhập mã dịch vụ
        System.out.println("Mã dịch vụ: (SVHO-YYYY)");
        String maDichVu = "";
        boolean flagId = true;
        do {
            maDichVu = scanner.nextLine();
            if (checkIDInputRoom(maDichVu))
                flagId = false;
            else
                System.out.println("Bạn đã nhập sai format.");
        }while (flagId);

        // nhập tên của dịch vụ
        System.out.println("Tên ichjh vụ: ");
        String tenDichVu = scanner.nextLine();
        tenDichVu = characterConversion(tenDichVu);
        System.out.println("Tên dịch vụ: "+ tenDichVu);



        // Nhập diện tích sử dụng
        System.out.println("diện tích dử dụng (Phải lớn hơn 30m2)");
        boolean flagCheck = true;
        int usebleArea =0;
        do {
            usebleArea = Integer.parseInt(scanner.nextLine());
            if (checkNumber(usebleArea))
                flagCheck = false;
            else
                System.out.println("Bạn đã nhập sai ");
        }while (flagCheck);

        System.out.println("Chi phí: ");
        double chiPhi = 0;
        do {
            chiPhi = Double.parseDouble(scanner.nextLine());
            if (chiPhi < 0)
                System.out.println("Chi Phí phải lớn hơn 0");
        }while (chiPhi < 0);


        //Nhập số lượng người
        System.out.println("So Lượng người: (số lượng không vượt quá 20)");
        int soLuongNguoi = 0;
        do {
            soLuongNguoi = Integer.parseInt(scanner.nextLine());
            if (soLuongNguoi < 0 || soLuongNguoi > 20){
                System.out.println("Số lượng không vượt quá 20 nguwofi và không nhỏ hơn 0");
            }
        }while ((soLuongNguoi < 0 || soLuongNguoi > 20));


        //Nhập kiểu thuê
        String kieuThue = standardizedRetal(tenDichVu);
        System.out.println("Kiểu thuê: "+ kieuThue);

        // Nhập tiêu chuẩn phòng
        String tieuChuanPhong = standardizedRoom(tenDichVu);
        System.out.println("Tiêu chuẩn phòng: "+ tieuChuanPhong);

        // Nhập số tầng
        System.out.println("Số tầng: ");
        int soTang = 0;
        do {
            soTang = Integer.parseInt(scanner.nextLine());
            if (soTang < 0)
                System.out.println("Số tầng không nhor hơn 0.");
        }while (soTang < 0);

        House house =new House(maDichVu,tenDichVu,usebleArea,chiPhi,soLuongNguoi,kieuThue,tieuChuanPhong,soTang);
        //(String maDichVu, String tenDichVu, String dienTichSuDung, double chiPhi, int soLuongNguoi, String kieuThue, String tieuChuanPhong, int soTang
        FacilityRepository.initializeDataHouse(house);

    }

    @Override
    public void addNewRoom() {
        // nhập mã dịch vụ
        System.out.println("Mã dịch vụ: (SVVL-YYYY)");
        boolean flagID = true;
        String maDichVu= "";
        do {
            maDichVu = scanner.nextLine();
            if (checkIdInputVilla(maDichVu))
                flagID = false;
            else
                System.out.println("Bạn đã nhập sai format");
        }while (flagID);


        // nhập tên của dịch vụ
        System.out.println("Tên ichjh vụ: ");
        String tenDichVu = scanner.nextLine();
        tenDichVu = characterConversion(tenDichVu);
        System.out.println("Tên dịch vụ: "+ tenDichVu);

        // Nhập diện tích sử dụng
        System.out.println("diện tích dử dụng(Phải lớn hơn 30m2)");
        boolean flag = true;
        int usebleArea = 0;
        do {
            usebleArea = Integer.parseInt(scanner.nextLine());
            if (checkNumber(usebleArea))
                flag = false;
            else
                System.out.println("Bạn đã nhập sai n");
        }while (flag);


        // Nhập chi phí
        System.out.println("Chi phí: ");
        double chiPhi = 0;
        do {
            chiPhi = Double.parseDouble(scanner.nextLine());
            if (chiPhi < 0)
                System.out.println("Chi Phí phải lớn hơn 0");
        }while (chiPhi < 0);


        //Nhập số lượng người
        System.out.println("So Lượng người: (số lượng không vượt quá 20)");
        int soLuongNguoi = 0;
        do {
            soLuongNguoi = Integer.parseInt(scanner.nextLine());
            if (soLuongNguoi < 0 || soLuongNguoi > 20){
                System.out.println("Số lượng không vượt quá 20 nguwofi và không nhỏ hơn 0");
            }
        }while ((soLuongNguoi < 0 || soLuongNguoi > 20));


        //Nhập kiểu thuê
        String kieuThue = standardizedRetal(tenDichVu);
        System.out.println("Kiểu thuê: "+ kieuThue);


        // Nhập dịch vụ miễn phis
        System.out.println("Dịch vụ miễn Phí: ");
        String dichVuFree = scanner.nextLine();
        Room room = new Room(maDichVu,tenDichVu,usebleArea,chiPhi,soLuongNguoi,kieuThue,dichVuFree);
        FacilityRepository.initializeDataRoom(room);
    }

    @Override
    public void addNewVilla() {
        // nhập mã dịch vụ
        System.out.println("Mã dịch vụ: (SVRO-YYYY)");
        boolean flagId = true;
        String maDichVu = "";
        do {
            maDichVu = scanner.nextLine();
            if (checkIdInputHouse(maDichVu))
                flagId = false;
            else {
                System.out.println("Bạn đã nhập sai format");
            }
        }while (flagId);



        // nhập tên của dịch vụ
        System.out.println("Tên ichjh vụ: ");
        String tenDichVu = scanner.nextLine();
        tenDichVu = characterConversion(tenDichVu);
        System.out.println("Tên dịch vụ: "+ tenDichVu);


        // Nhập diện tích sử dụng
        System.out.println("diện tích dử dụng (Phải lớn hơn 30m2)");
        boolean flagArea = true;
        int usebleArea = 0;
        do {
            usebleArea = Integer.parseInt(scanner.nextLine());
            if (checkNumber(usebleArea))
                flagArea = false;
            else
                System.out.println("Bạn đã nhập sai ");
        }while (flagArea);



        // Nhập chi phí
        System.out.println("Chi phí: ");
        double chiPhi = 0;
        do {
            chiPhi = Double.parseDouble(scanner.nextLine());
            if (chiPhi < 0)
                System.out.println("Chi Phí phải lớn hơn 0");
        }while (chiPhi < 0);


        //Nhập số lượng người
        System.out.println("So Lượng người: (số lượng không vượt quá 20)");
        int soLuongNguoi = 0;
        do {
            soLuongNguoi = Integer.parseInt(scanner.nextLine());
            if (soLuongNguoi < 0 || soLuongNguoi > 20){
                System.out.println("Số lượng không vượt quá 20 nguwofi và không nhỏ hơn 0");
            }
        }while ((soLuongNguoi < 0 || soLuongNguoi > 20));


        //Nhập kiểu thuê
        String kieuThue = standardizedRetal(tenDichVu);
        System.out.println("Kiểu thuê: "+ kieuThue);

        // Nhập tiêu chuẩn phòng
        String tieuChuanPhong = standardizedRoom(tenDichVu);
        System.out.println("Tiêu chuẩn phòng: "+ tieuChuanPhong);

        // Nhập diện tích
        System.out.println("Diện tích: (Phải lớn hơn 30m2)");
        int area = 0;
        boolean areaFlag = true;
        do {
            area = Integer.parseInt(scanner.nextLine());
            if (checkNumber(area))
                areaFlag = false;
            else
                System.out.println("Bạn đã nhập không đúng");
        }while (areaFlag);

        // Nhập số tầng
        System.out.println("Số tầng: ");
        int soTang = 0;
        do {
            soTang = Integer.parseInt(scanner.nextLine());
            if (soTang < 0)
                System.out.println("Số tầng không nhor hơn 0.");
        }while (soTang < 0);

        // phương thức add này dùng để thêm vào 1 cái mảng
        Villa villa = new Villa(maDichVu,tenDichVu,usebleArea,chiPhi,soLuongNguoi,kieuThue,tieuChuanPhong,area,soTang);
        FacilityRepository.initializeDataVilla(villa);
    }
}