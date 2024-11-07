package com.example.demo.model.dto;

import com.example.demo.model.DoanhMuc;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TinTucDTO implements Validator {

    private Integer idTinTuc;

    @NotBlank(message = "Không được để trống")
    @Size(max = 50,message = "Không được quá 50 kí tự")
    private String tieuDe;

    @NotBlank(message = "Không được để trống")
    @Size(max = 500,message = "Nội dung không quá 500 kí tự")
    private String noiDung;

    @NotBlank(message = "Không được để trống")
//    @Pattern(regexp = "\"\\\\d{4}-\\\\d{2}-\\\\d{2}\"",message = "Bạn phải đúng định dạng yyyy-MM-dd")
    private String ngayDangTin;

    @NotBlank(message = "không được để trống")
    private String phongVien;

    @ManyToOne
    @JoinColumn(name = "id_doanh_muc")
    private DoanhMuc doanhMuc;

    public Integer getIdTinTuc() {
        return idTinTuc;
    }

    public void setIdTinTuc(Integer idTinTuc) {
        this.idTinTuc = idTinTuc;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDangTin() {
        return ngayDangTin;
    }

    public void setNgayDangTin(String ngayDangTin) {
        this.ngayDangTin = ngayDangTin;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public DoanhMuc getDoanhMuc() {
        return doanhMuc;
    }

    public void setDoanhMuc(DoanhMuc doanhMuc) {
        this.doanhMuc = doanhMuc;
    }

    public TinTucDTO(Integer idTinTuc, String tieuDe, String noiDung, String ngayDangTin, String phongVien, DoanhMuc doanhMuc) {
        this.idTinTuc = idTinTuc;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDangTin = ngayDangTin;
        this.phongVien = phongVien;
        this.doanhMuc = doanhMuc;
    }

    public TinTucDTO() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }



}
