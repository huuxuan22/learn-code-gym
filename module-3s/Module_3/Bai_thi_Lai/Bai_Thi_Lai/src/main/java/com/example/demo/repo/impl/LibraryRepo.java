package com.example.demo.repo.impl;

import com.example.demo.model.HocSinh;
import com.example.demo.model.MuonSach;
import com.example.demo.model.Sach;
import com.example.demo.model.ThongKe;
import com.example.demo.repo.BaseRepository;
import com.example.demo.repo.ILibraryRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryRepo implements ILibraryRepo {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private String SELECT_ALL_BOOK = "select s.*,tms.id_muon_sach,tms.ma_muon_sach from sach as s inner join the_muon_sach as tms on s.id_sach = tms.id_sach";
    private String ID_MAX_MS = "select max(id_muon_sach)+ 1 as id_ms_max from the_muon_sach";
    private String SELECT_ALL_HS = "select id_hs, ho_ten from hoc_sinh";
    private String ADD_MUON_SACH = "insert into the_muon_sach(id_muon_sach,id_sach,id_hs,ma_muon_sach,trang_thai,ngay_muon,ngay_tra) \n" +
            "values (?,?,?,?,?,?,?)";
    private String SHOW_SACH_CHO_MUON = "select tms.ma_muon_sach,s.ten_sach,s.tac_gia,hs.ho_ten,hs.lop,tms.ngay_muon,tms.ngay_tra from the_muon_sach as tms inner join sach as s on tms.id_sach = s.id_sach\n" +
            "\t\t\t\t\t\tinner join hoc_sinh as hs on hs.id_hs = tms.id_hs";
    @Override
    public List<Sach> selectAllSach() {
        connection = BaseRepository.getConnectDB();
        List<Sach> sachList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_BOOK);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idSach = resultSet.getInt("id_sach");
                String maSach = resultSet.getString("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int soLuong = resultSet.getInt("so_luong");
                int idMuonSach = resultSet.getInt("id_muon_sach");
                String maMuonSach = resultSet.getString("ma_muon_sach");
                sachList.add(new Sach(idMuonSach,idSach,maSach,tenSach,tacGia,moTa,soLuong,maMuonSach));
            }
            return sachList;
        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public int idMax() {
        connection = BaseRepository.getConnectDB();
        int idMax = 0;
        try {
            statement = connection.prepareStatement(ID_MAX_MS);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                idMax = resultSet.getInt("id_ms_max");
            }
            return idMax;
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public List<HocSinh> selectAllHS() {
        List<HocSinh> hocSinhs = new ArrayList<>();
        connection = BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(SELECT_ALL_HS);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idHocSinh = resultSet.getInt("id_hs");
                String tenHocSinh = resultSet.getString("ho_ten");

                hocSinhs.add(new HocSinh(idHocSinh,tenHocSinh));
            }
            return hocSinhs;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean addNewMuonSach(MuonSach muonSach) {
        connection = BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(ADD_MUON_SACH);
            statement.setInt(1,muonSach.getIdMuonSach());
            statement.setInt(2,muonSach.getIdSach());
            statement.setInt(3,muonSach.getIdHocSinh());
            statement.setString(4,muonSach.getMaMuonSach());
            statement.setString(5,muonSach.getTrangThai());
            statement.setString(6,muonSach.getNgayMuonSach());
            statement.setString(7,muonSach.getNgayTraSach());

            int flag = statement.executeUpdate();

            return flag == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<ThongKe> SelectAll() {
        connection = BaseRepository.getConnectDB();
        List<ThongKe> thongKeList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SHOW_SACH_CHO_MUON);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String maMuonSach = resultSet.getString("ma_muon_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String hoTen = resultSet.getString("ho_ten");
                String lop = resultSet.getString("lop");
                String ngayMuon = resultSet.getString("ngay_muon");
                String ngayTra = resultSet.getString("ngay_tra");

                thongKeList.add(new ThongKe(maMuonSach,tenSach,tacGia,hoTen,lop,ngayMuon,ngayTra));
            }
            return thongKeList;
        } catch (SQLException e) {
            return null;
        }
    }
}
