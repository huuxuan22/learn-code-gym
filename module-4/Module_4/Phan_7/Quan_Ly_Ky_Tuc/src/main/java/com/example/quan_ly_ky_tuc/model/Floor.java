package com.example.quan_ly_ky_tuc.model;

import jakarta.persistence.*;

@Entity
public class Floor {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "floor_id")
    private int floorId;

    @Column(name = "floor_name")
    private String floorName;

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public Floor() {
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Floor(int floorId, String floorName) {
        this.floorId = floorId;
        this.floorName = floorName;
    }
}
