package com.example.myapplication;

public class User {
    String Name , phone , country;
    int imgId;

    public User(String name, String phone, String country, int imgId) {
        Name = name;
        this.phone = phone;
        this.country = country;
        this.imgId = imgId;
    }

    public User(String name, String phone, String country) {

    }
}

