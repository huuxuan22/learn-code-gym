package com.example.demo1.model;

public class Demo {
    private int id;
    private String name;
    private String mota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Demo(int id, String name, String mota) {
        this.id = id;
        this.name = name;
        this.mota = mota;
    }

    public Demo() {
    }
}
