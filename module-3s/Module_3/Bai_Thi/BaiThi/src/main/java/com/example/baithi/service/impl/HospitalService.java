package com.example.baithi.service.impl;

import com.example.baithi.model.BenhAn;
import com.example.baithi.repo.IHospitalRepo;
import com.example.baithi.repo.impl.HospitalRepository;
import com.example.baithi.service.IHospitalService;

import java.util.List;

public class HospitalService implements IHospitalService {
    private IHospitalRepo hospitalRepo = new HospitalRepository();
    @Override
    public List<BenhAn> selectAll() {
        return hospitalRepo.selectAll();
    }

    @Override
    public boolean delete(int idBenhAn) {
        return hospitalRepo.delete(idBenhAn);
    }

    @Override
    public Integer findIdMaxBN() {
        return hospitalRepo.findIdMaxBN();
    }

    @Override
    public Integer findIdMaxBA() {
        return hospitalRepo.findIdMaxBA();
    }

    @Override
    public boolean update(int idBenhAn, int idBenhNhan, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayXuatVien, String ngayRaVien, String lyDO) {
        return hospitalRepo.update(idBenhAn,idBenhNhan,maBenhAn,maBenhNhan,tenBenhNhan,ngayXuatVien,ngayRaVien,lyDO);
    }

    @Override
    public boolean add(BenhAn benhAn) {
        return hospitalRepo.add(benhAn);
    }
}
