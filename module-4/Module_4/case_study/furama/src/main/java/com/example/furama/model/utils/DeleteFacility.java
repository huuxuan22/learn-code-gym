package com.example.furama.model.utils;

import com.example.furama.model.Facility;

public class DeleteFacility {
    private String mess;
    private Facility facility;

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public DeleteFacility(String mess, Facility facility) {
        this.mess = mess;
        this.facility = facility;
    }

    public DeleteFacility() {
    }
}
