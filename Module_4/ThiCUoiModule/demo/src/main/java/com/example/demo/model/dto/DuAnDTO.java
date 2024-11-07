package com.example.demo.model.dto;

import com.example.demo.model.DoanhNghiep;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DuAnDTO implements Validator {

    private Integer idDuAn;

    @NotBlank(message = "hãy điền vào đây")
    @Pattern(regexp = "^DA-\\d{4}$", message = "maDuAn phải có định dạng DA-XXXX với X là số tự nhiên")
    private String maDuAn;

    @NotBlank(message = "hãy điền vào đây")
    private String tenDuAn;

    @NotNull(message = "Hãy điền vào đây")
    private Long kinhPhi;

    @NotBlank(message = "hãy điền vào đây")
    private String moTaDuAn;

    @NotNull(message = "hãy điền vào đây")
    private Integer thoiGianDangKi;

    private String ngayDangKi;

    @ManyToOne
    @JoinColumn(name = "id_doanh_nghiep")
    private DoanhNghiep doanhNghiep;

    public Integer getIdDuAn() {
        return idDuAn;
    }

    public void setIdDuAn(Integer idDuAn) {
        this.idDuAn = idDuAn;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public Long getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(Long kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    public DuAnDTO(Integer idDuAn, String maDuAn, String tenDuAn, Long kinhPhi, String moTaDuAn, Integer thoiGianDangKi, String ngayDangKi, DoanhNghiep doanhNghiep) {
        this.idDuAn = idDuAn;
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.kinhPhi = kinhPhi;
        this.moTaDuAn = moTaDuAn;
        this.thoiGianDangKi = thoiGianDangKi;
        this.ngayDangKi = ngayDangKi;
        this.doanhNghiep = doanhNghiep;
    }

    public DuAnDTO() {
    }

    public String getMoTaDuAn() {
        return moTaDuAn;
    }

    public void setMoTaDuAn(String moTaDuAn) {
        this.moTaDuAn = moTaDuAn;
    }

    public Integer getThoiGianDangKi() {
        return thoiGianDangKi;
    }

    public void setThoiGianDangKi(Integer thoiGianDangKi) {
        this.thoiGianDangKi = thoiGianDangKi;
    }

    public String getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(String ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public DoanhNghiep getDoanhNghiep() {
        return doanhNghiep;
    }

    public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
        DuAnDTO duAnDTO = (DuAnDTO) target;
        String ngayDangKi = duAnDTO.getNgayDangKi(); // Sử dụng đúng tên thuộc tính

        if (ngayDangKi == null || !isValidDateFormat(ngayDangKi, DATE_PATTERN)) {
            errors.rejectValue("ngayDangKi", "ngayDangKi.invalid", "Ngày đăng kí không hợp lệ. Phải có dạng yyyy-MM-dd");
        } else if (!isValidDates(ngayDangKi, "yyyy-MM-dd")) {
            errors.rejectValue("ngayDangKi", "ngayDangKi.invalid", "Ngày đăng kí không hợp lệ. Phải điền đúng ngày tháng");
        }
    }

    private boolean isValidDateFormat(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false); // Không cho phép chuyển đổi linh hoạt
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isValidDates(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false); // Không cho phép chuyển đổi linh hoạt
        try {
            sdf.parse(dateStr);
            // Kiểm tra xem ngày tháng có hợp lệ không
            String[] parts = dateStr.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            if (month < 1 || month > 12 || day < 1 || day > 31) {
                return false;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setLenient(false);
            calendar.set(year, month - 1, day);
            calendar.getTime(); // Thử lấy ngày tháng từ Calendar để kiểm tra
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
