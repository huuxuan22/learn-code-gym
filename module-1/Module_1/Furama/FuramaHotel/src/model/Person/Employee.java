package model.Person;

import Repository.InterfaceRepository.IEmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Employee extends Person {
    private String maNhanVien;

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Employee(String hoten, String ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String trinhDo, String viTri, int salary, String maNhanVien) {
        super(hoten, ngaySinh, gioiTinh, soCMND, sdt, email, trinhDo, viTri, salary);
        this.maNhanVien = maNhanVien;
    }

    public Employee(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public Employee(){}

    @Override
    public String toString() {
        return "Employee{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", hoten='" + hoten + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", soCMND='" + soCMND + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", trinhDo='" + trinhDo + '\'' +
                ", viTri='" + viTri + '\'' +
                ", salary=" + salary +
                '}';
    }
    public String getInforEmployyeToTxT(){
        return super.getInforPersonToTxT()+maNhanVien;
    }
}
