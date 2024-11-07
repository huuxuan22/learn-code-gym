package Controller;

import Service.FacilityServvice.FacilityService;
import Service.InterfaceService.*;
import Service.OrderService.BookingService;
import Service.OrderService.ContactService;
import Service.PersonService.CustomerService;
import Service.PersonService.EmployeeService;
import model.Person.Customer;
import model.Person.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FuramaController {
    private static final FacilityService facilityService =  new FacilityService();
    private static final EmployeeService customersList = new EmployeeService();
    private static final ICustomerService customerService = new CustomerService();
    private static final IBookingSerVice bookingService = new BookingService();
    private static final IContactService contactService = new ContactService();
    private final Scanner scanner = new Scanner(System.in);


    public FuramaController() {
        Scanner scanner = new Scanner(System.in);
    }

    public void displayMainMenu(){

        int choose = 0;
        do {
            // MENU LỰA CHỌN
            System.out.println("---------------------MeNu-----------------");
            System.out.println("1. Employee Management\n" +
                    "2. Customer Management\n" +
                    "3. Facility Management\n" +
                    "4. Booking Management\n" +
                    "5. Promotion Management\n" +
                    "6. Exit");
            System.out.println("---------------------MeNu-----------------");
            System.out.println("Đưa ra lựa chọn của bạn.");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    try {
                        int chooseMenuE = 0;
                        do {
                            System.out.println("1. Display list employees\n" +
                                    "2. Add new employee\n" +
                                    "3. Edit employee\n" +
                                    "4. Return main menu\n");
                            System.out.println("Đưa ra lựa chọn của bạn: ");
                            chooseMenuE = Integer.parseInt(scanner.nextLine());
                            switch (chooseMenuE) {
                                case 1:
                                    displayEmployee();
                                    break;
                                case 2:
                                    customersList.add();
                                    break;
                                case 3:
                                    System.out.println("Nhập vào id để sửa chữa: ");
                                    String idUpdate = scanner.nextLine();
                                    customersList.update(idUpdate);
                                    // chỉnh sửa thông tin của Employee
                                    break;
                            }
                        } while (chooseMenuE != 4);
                    } catch (Exception e) {
                        System.out.println("Sai ở Controller phần Employee || "+ e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        int chooseMenuC = 0;
                        do {
                            System.out.println("1. Display list customers\n" +
                                    "2. Add new customer\n" +
                                    "3. Edit customer\n" +
                                    "4. Return main menu");
                            System.out.println("Đưa ra lựa chọn của bạn: ");
                            chooseMenuC = Integer.parseInt(scanner.nextLine());
                            switch (chooseMenuC){
                                case 1:
                                    displayCustomer();
                                    // hiển thị danh sách Customer
                                    break;
                                case 2:
                                    customerService.add();
                                    //thêm 1 Customer mới
                                    break;
                                case 3:
                                    System.out.println("Nhập vào id để chỉnh sửa: ");
                                    String idUpdate = scanner.nextLine();
                                    customerService.update(idUpdate);
                                    // chỉnh sửa thông tin của Customer
                                    break;
                            }
                        }while (chooseMenuC != 4);// lựa chọn 4 để thoát khỏ chương trình
                    }catch (Exception e){
                        System.out.println(Arrays.toString(e.getStackTrace()));
                    }
                    break;
                case 3:
                    try{
                        // HIỂN THỊ DANH SÁCH MENU FACILITY
                        int chooseMenuF = 0;
                        do {
                            System.out.println("1 Display list facility\n" +
                                    "2 Add new facility\n" +
                                    "3 Display list facility maintenance\n" +
                                    "4 Return main menu");
                            chooseMenuF = Integer.parseInt(scanner.nextLine());
                            switch (chooseMenuF){
                                case 1:
                                    // hiển thị danh sách Facility đã được ghi rồi
                                    facilityService.display();
                                    break;
                                case 2:
                                    //thêm 1 facility
                                    int chooseMenuFacility = 0 ;
                                    do {
                                        System.out.println("1. add Room\n" +
                                                "2. add House \n" +
                                                "3. add Villa \n" +
                                                "4. exit");
                                        System.out.println("Đưa ra lựa chọn của bạn: ");
                                        chooseMenuFacility = Integer.parseInt(scanner.nextLine());
                                        switch (chooseMenuFacility){
                                            case 1:
                                                addNewVilla();
                                                break;
                                            case 2:
                                                addNewHouse();
                                                break;
                                            case 3:
                                                addNewRoom();
                                                break;
                                        }
                                    }while (chooseMenuFacility != 4);
                                    break;
                                case 3:
                                    // hiển thị những dịch vụ Facility đagn bảo trif
                                    break;
                            }
                        }while (chooseMenuF != 4);// lựa chọn 4 để thoát khỏ chương trình
                    }catch (Exception e){

                    }
                    break;
                case 4:
                    try{
                        int chooseMenuB = 0;
                        do {
                            System.out.println("Add new booking\n" +
                                    "2. Display list booking\n" +
                                    "3. Create new contracts\n" +
                                    "4. Display list contracts\n" +
                                    "5. Edit contracts\n" +
                                    "6. Return main menu");
                            System.out.println("Đưa ra lựa chọn của bạn: ");
                            chooseMenuB = Integer.parseInt(scanner.nextLine());
                            switch (chooseMenuB){
                                case 1:
                                    // thêm vào danh sách Booking
                                    bookingService.add();
                                    break;
                                case 2:
                                    //Hiển thị danh sách Booking
                                    break;
                                case 3:
                                    contactService.add();
                                    // Tạo 1 cái hợp đồng
                                    break;
                                case 4:
                                    //hiển thị thông tin của hợp đồng
                                    break;
                                case 5:
                                    System.out.println("Nhập vào id để cập nhât: ");
                                    String idUpdate = scanner.nextLine();
                                    contactService.update(idUpdate);
                                    //chỉnh sửa hợp đồng.
                                    break;
                            }
                        }while (chooseMenuB != 6);// lựa chọn 4 để thoát khỏ chương trình
                    }catch (Exception e){
                        System.out.println("lựa chọn menu Booking sai (Controller)");
                    }
                    break;
                case 5:
                    System.out.println("1. Display list customers use service\n" +
                            "2. Display list customers get voucher\n" +
                            "3. Return main menu");
                    try{
                        int chooseMenuM = 0;
                        do {
                            System.out.println("Đưa ra lựa chọn của bạn: ");
                            chooseMenuM = Integer.parseInt(scanner.nextLine());
                            switch (chooseMenuM){
                                case 1:
                                    // hiển thị danh sách Customer sử dụng dịch vụ
                                    break;
                                case 2:
                                    //tHiển thị danh sách khách hàng nhận voucher
                                    break;
                            }
                        }while (chooseMenuM != 3);// lựa chọn 4 để thoát khỏ chương trình
                    }catch (Exception e){
                        System.out.println("lựa chọn menu sai ở Phần thứ 6 (Controller)");
                    }
                    break;
            }
        }while(choose != 6);// thoát khỏi chương trình menu
    }



    // HIỂN THỊ DANH SÁCH EMPLOYEE
    public static void displayEmployee() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList = customersList.getAll();
        //String hoten, LocalDate ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String trinhDo, String viTri, int salary, String maNhanVien
        System.out.println("--------------Dannh sách Employee---------------------");
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println("Employee thứ: " + (i+1));
            System.out.println("Họ tên: " + employeeList.get(i).getHoten());
            System.out.println("Ngày sinh: " + employeeList.get(i).getNgaySinh());
            System.out.println("Giới tính: " + employeeList.get(i).getNgaySinh());
            System.out.println("Số chứng minh nhân dân: " + employeeList.get(i).getSoCMND());
            System.out.println("Số điện thoại: " + employeeList.get(i).getSdt());
            System.out.println("Email: " + employeeList.get(i).getEmail());
            System.out.println("Trình độ: " + employeeList.get(i).getTrinhDo());
            System.out.println("Vị trí: " + employeeList.get(i).getViTri());
            System.out.println("Lương: " + employeeList.get(i).getSalary());
            System.out.println("Mã nhân viên: " + employeeList.get(i).getMaNhanVien());
            System.out.println("----------------------------------------------------");
        }
    }

    // HIỂN THỊ DANH SÁCH CUSTOMER
    public static void displayCustomer(){
        ArrayList<Customer> customersList = (ArrayList<Customer>) customerService.getAll();
        System.out.println("--------------Dannh sách Employee---------------------");
        for (int i = 0; i < customersList.size(); i++) {
            System.out.println("Employee thứ: " + (i+1));
            System.out.println("Họ tên: " + customersList.get(i).getHoten());
            System.out.println("Ngày sinh: " + customersList.get(i).getNgaySinh());
            System.out.println("Giới tính: " + customersList.get(i).getNgaySinh());
            System.out.println("Số chứng minh nhân dân: " + customersList.get(i).getSoCMND());
            System.out.println("Số điện thoại: " +customersList.get(i).getSdt());
            System.out.println("Email: " +customersList.get(i).getEmail());
            System.out.println("Trình độ: " + customersList.get(i).getTrinhDo());
            System.out.println("Vị trí: " + customersList.get(i).getViTri());
            System.out.println("Lương: " + customersList.get(i).getSalary());
            System.out.println("Mã Khách hàng: " +customersList.get(i).getMaKhachHang());
            System.out.println("----------------------------------------------------");
        }
    }

    public static void addNewHouse(){
        facilityService.addNewHouse();
    }
    public static void addNewRoom(){
        facilityService.addNewRoom();
    }
    public static void addNewVilla(){
        facilityService.addNewVilla();
    }



    // FACILITY


}


