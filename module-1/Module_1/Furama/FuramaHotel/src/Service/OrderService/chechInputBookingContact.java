package Service.OrderService;

import Repository.FacilityRepository.FacilityRepository;
import Repository.PersonRepository.CustomerRepository;
import model.Facility.Facility;
import model.Person.Customer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class chechInputBookingContact {
    public static final String maDichVu_REGEX = "BK-YYYY";
    public static final Pattern maDichVu_Patten = Pattern.compile(maDichVu_REGEX);
    private static LinkedHashMap<Facility,Integer> facilityIntegerLinkedHashMap = new LinkedHashMap<>();
    private static final CustomerRepository customerRepository = new CustomerRepository();
    public chechInputBookingContact(FacilityRepository facilityRepository){
        facilityIntegerLinkedHashMap = facilityRepository.getAllLinkedHashMap();
    }
    chechInputBookingContact(){

    }

    public static boolean checkMaBooking(String maDichVu){
        Matcher matcher = maDichVu_Patten.matcher(maDichVu);
        return matcher.matches();
    }
    public static boolean checkMaDichVuFromFacilityList(String maDichVu){
        Set<Facility> facilitySet = facilityIntegerLinkedHashMap.keySet();
        for (Facility facility : facilitySet){
            if (facility.getMaDichVu().equals(maDichVu)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkIdCustomer(String maKhachHang){
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList = customerRepository.getAll();
        for (Customer customer : customerList){
            if (customer.getMaKhachHang().equals(maKhachHang)){
                return true;
            }
        }
        return false;
    }
}
