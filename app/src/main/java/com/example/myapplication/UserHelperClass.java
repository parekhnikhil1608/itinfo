package com.example.myapplication;

public class UserHelperClass {
    String uname,phone,password,vpassword;

    public UserHelperClass(String uname, String phone, String password, String vpassword) {
        this.uname = uname;
        this.phone = phone;
        this.password = password;
        this.vpassword = vpassword;

    }

    public UserHelperClass() {

    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVpassword() {
        return vpassword;
    }

    public void setVpassword(String vpassword) {
        this.vpassword = vpassword;
    }
}
