package Service.PersonService;

import Repository.InterfaceRepository.ICustomerRepository;
import Repository.PersonRepository.CustomerRepository;
import Service.InterfaceService.ICustomerService;
import Util.DateTimeFurama;
import model.Person.Customer;
import model.Person.Employee;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static Service.PersonService.CheckInputEmployeeCustomer.*;

public class CustomerService implements ICustomerService {
    private  ICustomerRepository<Customer> customerRepository = new CustomerRepository();
    private final Scanner scanner = new Scanner(System.in);



    @Override
    public void add() {
        try{
        System.out.println("NHẬP THÔNG TIN KHÁCH HÀNG");
            //String hoten, Date ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String trinhDo, String viTri, int salary, String maKhachHang
            //String hoten, Date ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String trinhDo, String viTri, int salary, String maKhachHang
            System.out.println("Họ tên: ");
            String hoTen = scanner.nextLine();
            hoTen = thayDoiTen(hoTen);
            System.out.println("Tên của bạn: "+ hoTen);

            // Ngày sinh
            System.out.println("Ngày sinh: (Nhập theo Format dd/MM/yyyy)");
            String ngaySinh = "";
            LocalDate time = null;
            boolean flagTime = true;
            do {
                try{
                    ngaySinh = scanner.nextLine();
                    if (!kiemTraNgaySinh(ngaySinh)){
                        flagTime = true;
                        System.out.println("Chưa đủ 18 tuổi.");
                    }
                    else {
                        flagTime = false;
                    }
                }catch (Exception e){
                    System.out.println("Hãy nhập lại: ");
                    System.out.println("Chưa đủ 18 tuổi hoặc sai format.");
                    flagTime = true;
                }
            }while (flagTime);

            // giới tính
            System.out.println("Giới tính: ");
            String gioiTinh = scanner.nextLine();

            // Chứng minh nhân dân
            System.out.println("Số CMND: (có độ dài là 10 với các số 0->9)");
            String soCMND = "";
            boolean isSoCMNDValid = true;

            do {
                soCMND = scanner.nextLine();
                if (!checkSoCMND(soCMND)) {
                    System.out.println("Bạn đã nhập sai format hoặc độ dài của số chứng minh nhân dân.");
                    System.out.println("Hãy nhập lại:");
                } else {
                    isSoCMNDValid = false;
                }
            } while (isSoCMNDValid);

            // Số điện thoại.
            System.out.println("Số điện thoại: (Số điện thoại nhập vào phải có 10 số.)");
            String sdt = "";
            boolean isSDTValid = true;

            do {
                sdt = scanner.nextLine();
                if (!checkSDT(sdt)) {
                    System.out.println("Bạn đã nhập sai format của số điện thoại. ");
                    System.out.println("Hãy nhập lai:");
                } else {
                    isSDTValid = false;
                }
            } while (isSDTValid);

            // Email.
            System.out.println("Email: ");
            String email = scanner.nextLine();

            // TRình độ
            System.out.println("Trình Độ: ");
            String trinhDo = scanner.nextLine();

            // VỊ TRÍ
            System.out.println("Vị trí: ");
            String viTri = scanner.nextLine();

            // Lương
            System.out.println("Lương: ");
            int salary = 0;
            do {
                salary = Integer.parseInt(scanner.nextLine());
                if (salary < 0)
                    System.out.println("bạn đã nhập sai lương.");
            }while (salary < 0);

            // Nhập mã nhân Viên
            System.out.println("Mã Nhân viên: (Theo định dạng NV-yyyy với y là các số từ 0->9)");
            boolean flagId = false;
            String maKhachHang = "";
            do {
                maKhachHang = scanner.nextLine();
                flagId = checkIdCustomer(maKhachHang);
                System.out.println("Bạn đã nhập sai format hãy nhập lại: ");
            }while (!flagId);
            //String hoten, Date ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String trinhDo, String viTri, int salary, String maKhachHang
            Customer customer = new Customer(hoTen,ngaySinh,gioiTinh,soCMND,sdt,email,trinhDo,viTri,salary,maKhachHang);
            customerRepository.add(customer);
            System.out.println("Thêm 1 Customer thành công!");
    }catch (Exception e){
        System.out.println("Sai ở phần tạo ra 1 cusomer mới để thêm vào danh sách.!");
    }
}

    @Override
    public void update(String id) {
        ArrayList<Customer> customerList = null;
        customerList = (ArrayList<Customer>) customerRepository.getAll();
        try {
            for (int i=0;i<customerList.size();i++){
                    if (((Customer) customerList.get(i)).getMaKhachHang().equals(id)){
                        // HỌ TÊN
                        System.out.println("Họ tên cập nhật: ");
                        String hoTen = scanner.nextLine();
                        hoTen = thayDoiTen(hoTen);
                        System.out.println("Tên của bạn: "+ hoTen);

                        // NGÀY SINH
                        System.out.println("Ngày sinh Cập nhật: ");
                        String ngaySinh = "";
                        LocalDate time = null;
                        boolean flagTime = true;
                        do {
                            try{
                                ngaySinh = scanner.nextLine();
                                if (!kiemTraNgaySinh(ngaySinh)){
                                    System.out.println("Chưa đủ 18 tuổi");
                                    flagTime = true;
                                }
                                else {
                                    flagTime = false;
                                }
                            }catch (Exception e){
                                System.out.println("Hãy nhập lại: ");
                                System.out.println("Chưa đủ 18 tuổi hoặc sai format.");
                                flagTime = true;
                            }
                        }while (flagTime);

                        // GIỚI TÍNH
                        System.out.println("Giới tính Cập nhật: ");
                        String gioiTinh = scanner.nextLine();

                        // SỐ CHỨNG MINH NHÂN DÂN
                        System.out.println("Số CMND Cập nhật: ");
                        String soCMND = "";
                        boolean isSoCMNDValid = true;

                        do {
                            soCMND = scanner.nextLine();
                            if (!checkSoCMND(soCMND)) {
                                System.out.println("Bạn đã nhập sai format hoặc độ dài của số chứng minh nhân dân.");
                                System.out.println("Hãy nhập lại:");
                            } else {
                                isSoCMNDValid = false;
                            }
                        } while (isSoCMNDValid);

                        // SỐ ĐIỆN THOẠI CẬP NHẬT
                        System.out.println("Số điện thoại Cập nhật: ");
                        String sdt = "";
                        boolean isSDTValid = true;

                        do {
                            sdt = scanner.nextLine();
                            if (!checkSDT(sdt)) {
                                System.out.println("Bạn đã nhập sai format của số điện thoại. ");
                                System.out.println("Hãy nhập lai:");
                            } else {
                                isSDTValid = false;
                            }
                        } while (isSDTValid);

                        // EMAIL CẬP NHẬT
                        System.out.println("Email Cập nhật: ");
                        String email = scanner.nextLine();

                        // TRÌNH ĐỘ CẬP NHẬT
                        System.out.println("Trình Độ Cập nhật: ");
                        String trinhDo = scanner.nextLine();

                        // VỊ TRÍ CẬP NHẬT
                        System.out.println("Vị trí ập nhật: ");
                        String viTri = scanner.nextLine();

                        // LƯƠNG CẬP NHÂT
                        System.out.println("Lương Cập nhật: ");
                        int salary = 0;
                        do {
                            salary = Integer.parseInt(scanner.nextLine());
                            if (salary < 0)
                                System.out.println("bạn đã nhập sai lương.");
                        }while (salary < 0);
                        //Phần cập nhật cho từng thông tin của khách hàng  theo mã khác hàng.
                        customerList.get(i).setHoten(hoTen);
                        customerList.get(i).setNgaySinh(ngaySinh);
                        customerList.get(i).setGioiTinh(gioiTinh);
                        customerList.get(i).setSoCMND(soCMND);
                        customerList.get(i).setSdt(sdt);
                        customerList.get(i).setEmail(email);
                        customerList.get(i).setTrinhDo(trinhDo);
                        customerList.get(i).setViTri(viTri);
                        customerList.get(i).setSalary(salary);
                    }
                }
            customerRepository.update(customerList);
            System.out.println("Cập nhật thành công");
        }catch (Exception e){
            System.out.println("Sai ở phần cập nhật Customer trong phần repository");
        }
    }

    @Override
    public void delete(String id) {
        try {
            customerRepository.delete(id);
        } catch (ParseException e) {
            System.out.println("Sai ở method delete trong CustomerService");;
        }
    }

    @Override
    public ArrayList getAll() {
        return (ArrayList) customerRepository.getAll();
    }

    @Override
    public void display() {

    }


}
