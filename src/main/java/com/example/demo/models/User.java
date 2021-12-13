package com.example.demo.models;

public class User {
    private int id;
    private String userName;
    private String pass;
    private String country;
    private String email;
    private String phone;
    private String orderAdress;
    private String userRole;

    public User() {
    }

    public User(int id, String userName, String pass, String country, String email, String phone, String orderAdress, String userRole) {
        this.id = id;
        this.userName = userName;
        this.pass = pass;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.orderAdress = orderAdress;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderAdress() {
        return orderAdress;
    }

    public void setOrderAdress(String orderAdress) {
        this.orderAdress = orderAdress;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", orderAdress='" + orderAdress + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
