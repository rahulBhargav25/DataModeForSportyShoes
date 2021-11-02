package com.example.datamodel.entity;

import javax.persistence.*;

@Entity
@NamedQueries(
        value = {
                @NamedQuery(name="get_all_users", query = "select u from User u")

        }
)
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String userName;

    private String email;

    private String name;

    private String password;

    public User() {
    }

    public User(String userName, String email, String name, String password) {
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
