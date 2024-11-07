package Repository.FacilityRepository;

import Repository.InterfaceRepository.IFacilityRepository;
import Util.WriteAndReadFile_txt;
import model.Facility.Facility;
import model.Facility.House;
import model.Facility.Room;
import model.Facility.Villa;

import java.text.ParseException;
import java.util.*;

public class FacilityRepository implements IFacilityRepository<Facility> {
    public static final LinkedHashMap<Facility, Integer> storageFacilityList = new LinkedHashMap<>();// danh sách để lưu trữ

    static {
        //String maDichVu, String tenDichVu, int dienTichSuDung, double chiPhi, int soLuongNguoi, String kieuThue, String tieuChuanPhong, int soTang
        House house = new House("1234","ten dich Vu",312312,123123,23423,"Kiểu thuê","5 sao",34234);
        initializeDataHouse(house);

        //(String maDichVu, String tenDichVu, int dienTichSuDung, double chiPhi, int soLuongNguoi, String kieuThue, String dichVuMienPhi
        Room room = new Room("1234","ten dich Vu",312312,123123,23423,"Kiểu thuê","Dich vu mien phi");
        initializeDataRoom(room);

        // String maDichVu, String tenDichVu, int dienTichSuDung, double chiPhi, int soLuongNguoi, String kieuThue, String tieuChuanPhong, int dienTich, int soTang
        Villa villa = new Villa("12343","ten dich Vu",312312,123123,23423,"Kiểu thuê","5 sao",34234,23423);
        initializeDataVilla(villa);
    }

    public static void initializeDataHouse(House house) {
        // Thực hiện công việc khởi tạo dữ liệu với tham số truyền vào
        storageFacilityList.put(house, 0);
    }

    public static void initializeDataRoom(Room room){
        // khởi tạo tham số truyền vào
        storageFacilityList.put(room,0);
    }

    public static void initializeDataVilla(Villa villa){
        // khởi tạo tham số truyền vào
        storageFacilityList.put(villa,0);
    }
    @Override
    public List<Facility> getAll() {
        ArrayList<Facility> listFacility = new ArrayList<>(storageFacilityList.keySet());
        return listFacility;
    }

    @Override
    public void add(Facility item) {
        // không dùng tới
    }

    @Override
    public void update(ArrayList<Facility> listItem) {
        // Không dùng tới
    }

    @Override
    public void delete(String id) throws ParseException {
        // không dùng tới
    }


    @Override
    public LinkedHashMap<Facility, Integer> getAllLinkedHashMap(){
        return storageFacilityList;
    }
}