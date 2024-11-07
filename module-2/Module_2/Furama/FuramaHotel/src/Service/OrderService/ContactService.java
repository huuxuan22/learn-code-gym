package Service.OrderService;

import Repository.InterfaceRepository.IContactRepository;
import Repository.OrderRePository.ContactRepository;
import Service.InterfaceService.IContactService;
import model.Facility.Room;
import model.OrderService.Booking;
import model.OrderService.Contact;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class ContactService implements IContactService {
    private static final IContactRepository<Contact> contactRepository = new ContactRepository();
    private final TreeSet<Booking> listBooking = contactRepository.getAllTreBooing();
    private Scanner scanner = new Scanner(System.in);



    @Override
    public void add() {
        System.out.println("====================DANH SÁCH ĐÃ BOOKING CẦN TẠO CONTACT=================");
        ArrayList<Booking> bookingList = new ArrayList<>();
        String idRegex = "SVRO.*";
        Pattern pattern = Pattern.compile(idRegex);
        for (Booking booking : listBooking){
            if (!(pattern.matcher(booking.getIdBooking()).matches())){
                bookingList.add(booking);
            }
        }
        int count = 0;
        //String maBooking, LocalDate ngayBooking, LocalDate ngayThue, LocalDate ngayHetThue, String maKhachHang, String maDichVu
        for (Booking booking : bookingList){
            System.out.println("Booking thứ: "+ (count+1));
            System.out.println("MÃ Booking: "+ booking.getIdBooking());
            System.out.println("Ngày Booking: "+ booking.getDayBooking());
            System.out.println("Ngày thuê: "+ booking.getNgayThue());
            System.out.println("Ngày Hết thuê: "+ booking.getNgayHetThue());
            System.out.println("Mã khách hàng: "+ booking.getMaKhachHang());
            System.out.println("Mã dịch vụ: "+ booking.getMaDichVu());
        }
        System.out.println("====================DANH SÁCH ĐÃ BOOKING CẦN TẠO CONTACT=================");
        try{
            System.out.println("Số hợp đồng: ");
            String soHopDong = scanner.nextLine();
            System.out.println("Mã Booingking: ");
            String maBooking = scanner.nextLine();
            System.out.println("Số tiền cọc trước: ");
            int tienCoc = Integer.parseInt(scanner.nextLine());
            System.out.println("Tổng số tiền thanh toán: ");
            int tongTien = Integer.parseInt(scanner.nextLine());
            Contact contact = new Contact(soHopDong,maBooking,tienCoc,tongTien);
            contactRepository.add(contact);
            System.out.println("Thêm thành công.");
        }catch (Exception e){
            System.out.println("Sai ở method add trong ContactService");
        }
    }

    @Override
    public void update(String id) {
        // không dùng đến
    }

    @Override
    public void delete(String id) {
        // không dùng đến
    }

    @Override
    public ArrayList getAll() {
        return (ArrayList) contactRepository.getAll();
    }

    @Override
    public void display() {
        ArrayList<Contact> listContact = (ArrayList<Contact>) contactRepository.getAll();
        System.out.println("==================DANH SÁCH CONTACT==================");
        int count = 0;
        for (Contact contact : listContact){
            System.out.println("Hợp đồng thứ: "+ (count+1));
            System.out.println("Số hợp đồng: "+ contact.getNumberContact());
            System.out.println("Mã Booking: "+ contact.getIdBooking());
            System.out.println("Số tiền cọc trước: "+ contact.getDeposit());
            System.out.println("Tổng tiền thanh toán: "+ contact.getTotalAmount());
        }
        System.out.println("=====================================================");
    }


    @Override
    public TreeSet<Booking> contactTree() {
        return contactRepository.getAllTreBooing();
    }
}
