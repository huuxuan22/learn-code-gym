package com.example.baithi.service;

import com.example.baithi.model.BenhAn;

import java.util.List;

public interface IHospitalService {
    List<BenhAn> selectAll();
    boolean delete(int idBenhAn);
    Integer findIdMaxBN();
    Integer findIdMaxBA();
    boolean update(int idBenhAn,int idBenhNhan,String maBenhAn,String maBenhNhan,String tenBenhNhan,String ngayXuatVien,String ngayRaVien,String lyDO);
    boolean add(BenhAn benhAn);
}
