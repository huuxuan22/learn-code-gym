package com.example.quan_ly_ky_tuc.service;

import com.example.quan_ly_ky_tuc.model.Room;
import com.example.quan_ly_ky_tuc.repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService{
    @Autowired
    private IRoomRepo iRoomRepo;
    @Override
    public List<Room> getAllRoom() {
        return iRoomRepo.findAll();
    }
}
