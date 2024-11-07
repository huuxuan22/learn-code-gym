package model.Person;

import java.time.LocalDate;
import java.util.Date;

public abstract class Person {
    protected String hoten;
    protected String ngaySinh;
    protected String gioiTinh;
    protected String soCMND;
    protected String sdt;
    protected String email;
    protected String trinhDo;//rung cấp, Cao đẳng, Đại học và Sau đại học
    protected String viTri;//ễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc
    protected int salary;

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Person(String hoten, String ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String trinhDo, String viTri, int salary) {
        this.hoten = hoten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.sdt = sdt;
        this.email = email;
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.salary = salary;
    }
    public Person(){}

    @Override
    public String toString() {
        return "Person{" +
                "hoten='" + hoten + '\'' +
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
    public String getInforPersonToTxT(){
        return hoten +"," +ngaySinh+","+gioiTinh+","+soCMND+","+sdt+","+email+","+trinhDo+","+viTri+","+salary+",";
    }
}
