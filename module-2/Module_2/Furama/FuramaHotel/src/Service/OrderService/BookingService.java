package Service.OrderService;

import Repository.InterfaceRepository.IBookingRepository;
import Repository.OrderRePository.BookingRepository;
import Repository.PersonRepository.CustomerRepository;
import Service.InterfaceService.IBookingSerVice;
import model.Facility.Facility;
import model.Facility.House;
import model.Facility.Room;
import model.Facility.Villa;
import model.OrderService.Booking;
import model.Person.Customer;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static Service.FacilityServvice.FacilityService.facilityRepository;
import static Service.OrderService.chechInputBookingContact.*;

public class BookingService implements IBookingSerVice {
    private static final IBookingRepository<Booking> bookingRepository = new BookingRepository();
    private static final CustomerRepository customerRepository = new CustomerRepository();
    private LinkedHashMap<Facility,Integer> facilityIntegerLinkedHashMap = new LinkedHashMap<>();
    public BookingService(){
        facilityIntegerLinkedHashMap = facilityRepository.getAllLinkedHashMap();
    }

    @Override
    public void add() {
        // hiển thị danh sách facility
        // danh sách để lưu trữ
        Set<Facility> facilitySet = facilityIntegerLinkedHashMap.keySet();
        int countFacility = 0;
        System.out.println("==================DANH SÁCH FACILITY=================");
        for (Facility facility : facilitySet){
            System.out.println("----------------------------------");
            System.out.println("Facility thứ: "+ (countFacility+1));
            System.out.println("Mã dịch vụ: "+ facility.getMaDichVu());
            System.out.println("Tên dịch vụ: "+ facility.getTenDichVu());
            System.out.println("Diện tích sử dụng: " + facility.getDienTichSuDung());
            System.out.println("CHI phí: "+ facility.getChiPhi());
            System.out.println("Số lượng người: "+ facility.getSoLuongNguoi());
            System.out.println("Kiểu thuê: "+ facility.getKieuThue());
            if (facility instanceof Room){
                System.out.println("Dịch vụ miễn phí: "+ ((Room) facility).getDichVuMienPhi());
            } else if (facility instanceof Villa) {
                System.out.println("Tiêu chuẩn phòng: "+ ((Villa) facility).getTieuChuanPhong());
                System.out.println("Dien tich: "+ ((Villa)facility).getDienTich());
                System.out.println("Số tầng: "+ ((Villa) facility).getSoTang());
            }else {
                System.out.println("Tiêu chuẩn phòng: "+ ((House) facility).getTieuChuanPhong());
                System.out.println("Số tầng: "+ ((House) facility).getSoTang());
            }
            countFacility++;
        }
        System.out.println("==================DANH SÁCH FACILITY=================\n\n");

        // hiển thị danh sách Customer
        ArrayList<Customer> customersList = new ArrayList<>();
        int countCustomer = 0;
        customersList = customerRepository.getAll();
        System.out.println("===================DANH SÁCH CUSTOMER=================");
        for (Customer customer : customersList){
            System.out.println("----------------------------------");
            System.out.println("Customer thứ: "+ (countCustomer+1));
            System.out.println("Mã khách hàng: "+ customer.getMaKhachHang());
            System.out.println("Họ tên: " +customer.getHoten());
            System.out.println("Ngày sinh: " + customer.getNgaySinh());
            System.out.println("Giới tính: " + customer.getNgaySinh());
            System.out.println("Số chứng minh nhân dân: " + customer.getSoCMND());
            System.out.println("Số điện thoại: " + customer.getSdt());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Trình độ: " + customer.getTrinhDo());
            System.out.println("Vị trí: " + customer.getViTri());
            System.out.println("Lương: " + customer.getSalary());
            countCustomer++;
        }
        System.out.println("===================DANH SÁCH CUSTOMER=================\n\n");


        //String maBooking, Date ngayBooking, java.util.Date ngayThue, java.util.Date ngayHetThue, String maKhachHang, String maDichVu
        try {
            // Mã dịch vụ
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bạn hãy chọn Mã Dịch Vụ từ danh sách trên: ");
            boolean flagMaDichVu = true;
            String maDichVu = "";
            do {
                maDichVu = scanner.nextLine();
                if (checkMaDichVuFromFacilityList(maDichVu)){
                    flagMaDichVu = false;
                }else {
                    System.out.println("Mã dịch không có trong danh sách trên.");
                }
            }while (flagMaDichVu);

            //Mã khách hàng
            System.out.println("Mã khách hàng: ");
            boolean flagMaKhachHang = true;
            String maKhachhang;
            do {
                maKhachhang = scanner.nextLine();
                if (checkIdCustomer(maKhachhang)){
                    flagMaKhachHang = false;
                }else {
                    System.out.println("MÃ khách hàng không có trong danh sách trên");
                }
            }while (flagMaKhachHang);

            // Ma Booking
            System.out.println("Mã Booking:  ");
            String maBooking;
            boolean flagMaBooking = true;
            do {
                maBooking = scanner.nextLine();
                if (checkMaBooking(maBooking)){
                    flagMaBooking = false;
                }else {
                    System.out.println("Bạn đã nhập sai format.");
                }
            }while (flagMaBooking);


            // Ngày Booking
            System.out.println("Ngày Booking: ");
            String date = scanner.nextLine();
            LocalDate ngayBooKing = null;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd//MM/yyyy");
                ngayBooKing = LocalDate.parse(date,formatter);
            } catch (Exception e) {
                System.out.println("Lỗi nhập ngày booking: ");
            }


            // Ngày thuê
            System.out.println("Ngày Thuê: ");
            String date1 = scanner.nextLine();
            LocalDate ngayThue = null;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd//MM/yyyy");
                ngayThue = LocalDate.parse(date1,formatter);
            } catch (Exception e) {
                System.out.println("Lỗi nhập ngày booking: ");
            }

            // Ngày hết thuê
            System.out.println("Ngày hết thuê: ");
            String date2 = scanner.nextLine();
            LocalDate ngayHetThue = null;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd//MM/yyyy");
                ngayHetThue = LocalDate.parse(date2,formatter);
            } catch (Exception e) {
                System.out.println("Lỗi nhập ngày booking: ");
            }

            Booking booking = new Booking(maBooking, ngayBooKing, ngayThue, ngayHetThue, maKhachhang, maDichVu);
            bookingRepository.add(booking);
            Set<Facility> facilitieSet = facilityIntegerLinkedHashMap.keySet();
            // viết 1 vòng for để kiểm tra xem cái booking mình vửa nhập là cái dịch vụ gì để tăng số lần lên 1
            for (Facility facility : facilitieSet){
                if (facility.getMaDichVu().contains(maDichVu)){
                    facilityIntegerLinkedHashMap.compute(facility,(key,values)->(values==null)? 1: values+1);
                }
            }
            System.out.println("Thêm mới thành công");
            System.out.println("--------------------------------------------------");
        }catch (Exception e){
            System.out.println("sai ở method add trong BookingService");
        }
    }

    @Override
    public void update(String id)  {
        // không dùng method này.
    }

    @Override
    public void delete(String id)  {
        // không dùng method này
    }

    @Override
    public ArrayList getAll() {
        return (ArrayList) bookingRepository.getAll();
    }

    @Override
    public void display() {
        TreeSet<Booking> bookingTreeSet = bookingRepository.getAllTreeBooking();
        System.out.println("===================DANH SÁCH BOOKING===============");
        int count = 0;
        //String maBooking, LocalDate ngayBooking, LocalDate ngayThue, LocalDate ngayHetThue, String maKhachHang, String maDichVu
        for (Booking booking : bookingTreeSet){
            System.out.println("Booking thứ: "+ (count+1));
            System.out.println("MÃ Booking: "+ booking.getIdBooking());
            System.out.println("Ngày Booking: "+ booking.getDayBooking());
            System.out.println("Ngày thuê: "+ booking.getNgayThue());
            System.out.println("Ngày Hết thuê: "+ booking.getNgayHetThue());
            System.out.println("Mã khách hàng: "+ booking.getMaKhachHang());
            System.out.println("Mã dịch vụ: "+ booking.getMaDichVu());
        }
        System.out.println("====================================================");
    }


}
