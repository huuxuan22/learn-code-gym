package com.example.furama.model;

import jakarta.persistence.*;

@Entity
@Table(name = "facility_type")
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_type_id")
    private Integer id;

    private String name;

    public FacilityType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public FacilityType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
