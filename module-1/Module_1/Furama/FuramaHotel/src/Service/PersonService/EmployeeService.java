package Service.PersonService;

import Repository.InterfaceRepository.IEmployeeRepository;
import Repository.PersonRepository.EmployeeRepository;
import Service.InterfaceService.IEmployeeService;
import model.Person.Employee;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

import static Service.PersonService.CheckInputEmployeeCustomer.*;

public class EmployeeService implements IEmployeeService {
    private final Scanner scanner= new Scanner(System.in);;
    private   IEmployeeRepository<Employee> employeeRepository = new EmployeeRepository();



    @Override
    public void add() {
        try{
            System.out.println("NHẬP THÔNG TIN NHÂN VIÊN");

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
                         System.out.println("Chưa đủ 18 tuổi.");
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
            String maNhanVien = "";
            do {
                maNhanVien = scanner.nextLine();
                flagId = checkIdEmployee(maNhanVien);
                System.out.println("Bạn đã nhập sai format hãy nhập lại: ");
            }while (!flagId);
            //String hoten, Date ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String trinhDo, String viTri, int salary, String maKhachHang
            Employee employee = new Employee(hoTen,ngaySinh,gioiTinh,soCMND,sdt,email,trinhDo,viTri,salary,maNhanVien);
            employeeRepository.add(employee);
            System.out.println("Thêm 1 Employee thành công!");
        }catch (Exception e){
            System.out.println("Sai ở phần tạo ra 1 Employee trong phần service mới để thêm vào danh sách.!");
        }
    }

    @Override
    public void update(String id) {
        ArrayList<Employee> employeeList = null;
        try {
            employeeList = (ArrayList<Employee>) employeeRepository.getAll();
            for (int i = 0; i < employeeList.size(); i++) {
                if ((employeeList.get(i)).getMaNhanVien().equals(id)) {
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
                                System.out.println("chưa đủ 18 tuổi");
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
                    employeeList.get(i).setHoten(hoTen);
                    employeeList.get(i).setNgaySinh(ngaySinh);
                    employeeList.get(i).setGioiTinh(gioiTinh);
                    employeeList.get(i).setSoCMND(soCMND);
                    employeeList.get(i).setSdt(sdt);
                    employeeList.get(i).setEmail(email);
                    employeeList.get(i).setTrinhDo(trinhDo);
                    employeeList.get(i).setViTri(viTri);
                    employeeList.get(i).setSalary(salary);
                }
            }
            employeeRepository.update(employeeList);
            System.out.println("Cập nhật thành công");
        } catch (Exception e){
            System.out.println("Sai ở phần cập nhật Employee trong phần repository ||" + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        try {
            employeeRepository.delete(id);
        }catch (ParseException e){
            System.out.println("Sai ở method delete ở EmployeeService ||" + e.getMessage());
            e.getStackTrace();
        }
    }

    @Override
    public ArrayList<Employee> getAll() {
        return (ArrayList<Employee>) employeeRepository.getAll();
    }

    @Override
    public void display() {

    }

}

