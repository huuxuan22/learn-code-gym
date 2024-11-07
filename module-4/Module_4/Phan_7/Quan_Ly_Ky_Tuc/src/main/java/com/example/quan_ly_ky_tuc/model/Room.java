package com.example.quan_ly_ky_tuc.model;

import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int roomId;

    @Column(name = "room_name")
    private String roomName;


    public Room(int roomId, String roomName, int maximumQuanity, Floor floor) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.maximumQuanity = maximumQuanity;
        this.floor = floor;
    }

    public int getRoomId() {
        return roomId;
    }

    public Room() {
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getMaximumQuanity() {
        return maximumQuanity;
    }

    public void setMaximumQuanity(int maximumQuanity) {
        this.maximumQuanity = maximumQuanity;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Column(name = "maximum_quanity")
    private int maximumQuanity;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;
}
