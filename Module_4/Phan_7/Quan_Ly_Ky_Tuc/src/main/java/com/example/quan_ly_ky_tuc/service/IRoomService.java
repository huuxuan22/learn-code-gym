package com.example.quan_ly_ky_tuc.service;

import com.example.quan_ly_ky_tuc.model.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomService {
    public List<Room> getAllRoom();
}
