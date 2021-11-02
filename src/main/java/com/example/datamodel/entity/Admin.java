package com.example.datamodel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/*
* STORES ADMIN DETAILS TO DATABASE
* */
@Entity
public class Admin {


    @Id
    @GeneratedValue
    private Long adminId;

    private String password;

    private String adminName;

    private String email;

    public Admin(String password, String adminName, String email) {
        this.password = password;
        this.adminName = adminName;
        this.email = email;
    }
    /*
    * Empty constructor to make JPA happy
    * so any kind of data can be acceptable*/
    public Admin() {

    }
    /*
    * getter & setter for fetching and updating the data*/
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", password='" + password + '\'' +
                ", adminName='" + adminName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
