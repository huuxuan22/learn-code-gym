package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "staff_type")
public class StaffType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_staff_type")
    private Integer idStaffType;

    @Column(name = "staff_type_name")
    private String staffTypeName;

}
