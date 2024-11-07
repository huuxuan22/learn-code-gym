package model.Person;

import Repository.InterfaceRepository.ICustomerRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends Person {
    private String maKhachHang;

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Customer(String hoten, String ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String trinhDo, String viTri, int salary, String maKhachHang) {
        super(hoten, ngaySinh, gioiTinh, soCMND, sdt, email, trinhDo, viTri, salary);
        this.maKhachHang = maKhachHang;
    }

    public Customer(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    public Customer(){}

    @Override
    public String toString() {
        return "Customer{" +
                "maKhachHang='" + maKhachHang + '\'' +
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
    public String getInforCustomerToTxt(){
        return super.getInforPersonToTxT()+maKhachHang;
    }
}
