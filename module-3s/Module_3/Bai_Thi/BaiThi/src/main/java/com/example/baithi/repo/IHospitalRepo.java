package com.example.baithi.repo;

import com.example.baithi.model.BenhAn;

import java.util.List;

public interface IHospitalRepo {
    List<BenhAn> selectAll();
    boolean delete(int idBenhAn);
    Integer findIdMaxBA();
    Integer findIdMaxBN();
    boolean update(int idBenhAn,int idBenhNhan,String maBenhAn,String maBenhNhan,String tenBenhNhan,String ngayXuatVien,String ngayRaVien,String lyDO);
    boolean add(BenhAn benhAn);
}
