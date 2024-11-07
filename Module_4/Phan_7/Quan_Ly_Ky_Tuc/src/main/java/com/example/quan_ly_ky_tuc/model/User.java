package com.example.quan_ly_ky_tuc.model;


import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @Column(name = "account")
    private String acount;

    @Column(name = "pass_word")
    private String passWord;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Student student;

    public User(String acount, String passWord, Student student) {
        this.acount = acount;
        this.passWord = passWord;
        this.student = student;
    }

    public User() {
    }

    public User(String acount, String passWord) {
        this.acount = acount;
        this.passWord = passWord;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
