package com.example.baithi.repo.impl;

import com.example.baithi.model.BenhAn;
import com.example.baithi.repo.BaseRepository;
import com.example.baithi.repo.IHospitalRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalRepository implements IHospitalRepo {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private CallableStatement callableStatement = null;
    private String SELECT_ALL = "select ba.*, bn.ten_bn,bn.ma_bn\n" +
            "from benh_an as ba  inner join benh_nhan as bn on ba.id_bn = bn.id_bn;";
    private String DELETE = "delete from benh_an where id_ba = ?";
    private String FIND_ID_MAX_BN = "select max(id_ba) + 1 as idMax from benh_an";
    private String FIND_ID_MAX_BA = "select max(id_bn) + 1 as idMax from benh_nhan";
    private String UPDATE = "{call update_benh_vien(?,?,?,?,?,?,?,?)}";
    private String ADD = "{call insert_into_benh_vien(?,?,?,?,?,?,?,?)}";
    @Override
    public List<BenhAn> selectAll() {
        List<BenhAn> benhAnList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idBenhAn = resultSet.getInt("id_ba");
                int idBenhNhan = resultSet.getInt("id_bn");
                String maBenhAn = resultSet.getString("ma_ba");
                String maBenhNhan = resultSet.getString("ma_bn");
                String tenBenhNhan = resultSet.getString("ten_bn");
                String ngayNhapVien = resultSet.getString("ngay_ra_vien");
                String ngayRaVien = resultSet.getString("ngay_xuat_vien");
                String lyDo = resultSet.getString("ly_do");
//                int maBenhAn, int maBenhnhan, String tenBenNhan, String ngayNhanVien, String ngayRaVien, String lyDo
                benhAnList.add(new BenhAn(idBenhAn,idBenhNhan,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayNhapVien,lyDo));
            }
            return benhAnList;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (connection != null){
                        connection.close();
                }if (statement != null){
                    statement.close();
                }if (resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public boolean delete(int  idBenhAn) {
        connection = BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1,idBenhAn);
            int rowDelete = statement.executeUpdate();
            return rowDelete == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Integer findIdMaxBA() {
        connection = BaseRepository.getConnectDB();
        int idMax = 0;
        try {
            statement = connection.prepareStatement(FIND_ID_MAX_BA);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                idMax = resultSet.getInt("idMax");
            }
            return idMax;
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public Integer findIdMaxBN() {
        connection = BaseRepository.getConnectDB();
        int idMax = 0;
        try {
            statement = connection.prepareStatement(FIND_ID_MAX_BN);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                idMax = resultSet.getInt("idMax");
            }
            return idMax;
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public boolean update(int idBenhAn, int idBenhNhan, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayXuatVien, String ngayRaVien, String lyDO) {
        connection= BaseRepository.getConnectDB();
        try {
            callableStatement = connection.prepareCall(UPDATE);
            callableStatement.setInt(1,idBenhAn);
            callableStatement.setInt(2,idBenhNhan);
            callableStatement.setString(3,maBenhAn);
            callableStatement.setString(4,maBenhNhan);
            callableStatement.setString(5,tenBenhNhan);
            callableStatement.setString(6,ngayXuatVien);
            callableStatement.setString(7,ngayRaVien);
            callableStatement.setString(8,lyDO);

            int flag = callableStatement.executeUpdate();

            return  flag == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean add(BenhAn benhAn) {
        connection = BaseRepository.getConnectDB();
        try {
            callableStatement = connection.prepareCall(ADD);
            callableStatement.setInt(1,benhAn.getIdBenhAn());
            callableStatement.setInt(2,benhAn.getIdBenhNhan());
            callableStatement.setString(3,benhAn.getMaBenhNhan());
            callableStatement.setString(4,benhAn.getMaBenhAn());
            callableStatement.setString(5,benhAn.getTenBenhNhan());
            callableStatement.setString(6, benhAn.getNgayNhapVien());
            callableStatement.setString(7, benhAn.getNgayRaVien());
            callableStatement.setString(8, benhAn.getLyDo());

            int flag = callableStatement.executeUpdate();
            return flag == 1;
        } catch (SQLException e) {
            return false;
        }

    }


}
