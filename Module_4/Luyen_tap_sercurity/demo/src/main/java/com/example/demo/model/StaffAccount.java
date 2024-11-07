package com.example.demo.model;

import com.example.demo.model.Staff;
import jakarta.persistence.*;

@Entity
public class StaffAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Định nghĩa khóa chính cho bảng này
    @OneToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pass_word")
    private String passWord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public StaffAccount(Long id, Staff staff, String userName, String passWord) {
        this.id = id;
        this.staff = staff;
        this.userName = userName;
        this.passWord = passWord;
    }

    public StaffAccount() {
    }
}
