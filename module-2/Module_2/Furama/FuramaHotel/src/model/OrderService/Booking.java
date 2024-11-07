package model.OrderService;

import model.Facility.Facility;

import java.time.LocalDate;
import java.util.Date;

public class Booking extends Facility implements Comparable<Booking>{
   private String maBooking;
   private LocalDate ngayBooking;// ngày booking
   private LocalDate ngayThue;// ngày thuê
    private LocalDate ngayHetThue;// ngày hết thuê
    private String maKhachHang;// id khác hàng
    private String maDichVu;// id dịch vụ

    public String getIdBooking() {
        return maBooking;
    }

    public void setIdBooking(String idBooking) {
        this.maBooking = idBooking;
    }

    public LocalDate getDayBooking() {
        return ngayBooking;
    }

    public void setDayBooking(LocalDate dayBooking) {
        this.ngayBooking = dayBooking;
    }

    public LocalDate getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(LocalDate ngayThue) {
        this.ngayThue = ngayThue;
    }

    public LocalDate getNgayHetThue() {
        return ngayHetThue;
    }

    public void setNgayHetThue(LocalDate ngayHetThue) {
        this.ngayHetThue = ngayHetThue;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public Booking(String maBooking, LocalDate ngayBooking, LocalDate ngayThue, LocalDate ngayHetThue, String maKhachHang, String maDichVu) {
        this.maBooking = maBooking;
        this.ngayBooking = ngayBooking;
        this.ngayThue = ngayThue;
        this.ngayHetThue = ngayHetThue;
        this.maKhachHang = maKhachHang;
        this.maDichVu = maDichVu;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "maBooking='" + maBooking + '\'' +
                ", ngayBooking=" + ngayBooking +
                ", ngayThue=" + ngayThue +
                ", ngayHetThue=" + ngayHetThue +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", maDichVu='" + maDichVu + '\'' +
                '}';
    }
    public String getInforBookingToTxt(){
        return this.maBooking + ","+ ngayBooking+ ","+ngayThue+ ","+ngayHetThue+ ","+maKhachHang+ ","+maDichVu;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Booking)){
            return false;
        }else{
            Booking booking = (Booking) obj;
            if (maBooking.equals(((Booking) obj).getIdBooking())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return maBooking.hashCode();
    }

    @Override
    public int compareTo(Booking booking) {
        int startDay = ngayBooking.compareTo(booking.getDayBooking());
        if (startDay == 0){
            return ngayHetThue.compareTo(booking.getNgayHetThue());
        }
            return startDay;
    }
}
