package com.example.quan_ly_ky_tuc.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "student_id")
    private String studentId;

    @Column(name ="student_name")
    private String studentName;

    @Column(name = "citizenship_id", length = 10, unique = true)
    private String citizenshipId;

    @Column(name = "address")
    private String address;

    @Column(name = "number_phone", length = 10, unique = true)
    private String numberPhone;

    @Column(name = "birthday")
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Student(int id, String studentId, String studentName, String citizenshipId, String address, String numberPhone, Date birthday, Room room) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.citizenshipId = citizenshipId;
        this.address = address;
        this.numberPhone = numberPhone;
        this.birthday = birthday;
        this.room = room;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCitizenshipId() {
        return citizenshipId;
    }

    public void setCitizenshipId(String citizenshipId) {
        this.citizenshipId = citizenshipId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
