package com.example.demo.model.dto;

import com.example.demo.model.Class;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.sql.Date;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class StudentDTO implements Validator {


    private Integer id;

    @NotNull(message = "Bạn chưa điền mã sinh viên")
    @Pattern(regexp = "[0-9]{8}", message = "Mã sinh viên phải là 8 chữ số và không chứa a, b, hoặc c")
    private String msv;

    // Xác định định dạng ngày tháng cho chuỗi đầu vào
    private String ngaySinh;

    private String ten;

    @NotNull(message = "Bạn chưa điền căn cước công dân")
    @Pattern(regexp = "[0-9]{8}", message = "Mã sinh viên phải là 8 chữ số và không chứa a, b, hoặc c")
    private String canCuocCongDan;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class clazz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public StudentDTO(String msv, String ngaySinh, String ten, String canCuocCongDan, Class clazz) {
        this.msv = msv;
        this.ngaySinh = ngaySinh;
        this.ten = ten;
        this.canCuocCongDan = canCuocCongDan;
        this.clazz = clazz;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public StudentDTO(Integer id, String msv, String ngaySinh, String ten, String canCuocCongDan, Class clazz) {
        this.id = id;
        this.msv = msv;
        this.ngaySinh = ngaySinh;
        this.ten = ten;
        this.canCuocCongDan = canCuocCongDan;
        this.clazz = clazz;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public StudentDTO() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        this.canCuocCongDan = canCuocCongDan;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean supports(java.lang.Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
        StudentDTO studentDTO = (StudentDTO) target;
        String ngaySinhs = studentDTO.getNgaySinh(); // Giả sử getter của trường ngày sinh là getNgaySinh()

        if (ngaySinhs == null || !isValidDateFormat(ngaySinhs, "yyyy-MM-dd")) {
            errors.rejectValue("ngaySinh", "ngaySinh.invalid", "Ngày sinh không hợp lệ. Phải có dạng yyyy-MM-dd");
        }else if (ngaySinhs == null || !isValidDates(ngaySinhs, "yyyy-MM-dd")) {
            errors.rejectValue("ngaySinh", "ngaySinh.invalid", "Ngày sinh không hợp lệ. Phải điền đúng ngày tháng");
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
