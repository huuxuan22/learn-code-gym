package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "account")
    private String account;

    @Column(nullable = false, unique = true)
    private String passWord;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
            (
                    name = "users_roles",
                    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "account")},
                    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
            )
    private List<Role> roles = new ArrayList<>();

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User(String account, String passWord, List<Role> roles) {
        this.account = account;
        this.passWord = passWord;
        this.roles = roles;
    }

    public User() {
    }
}
