package com.csi370.mobileprojectcsi370;

public class AppUser {

    private int id;
    private String email;
    private String password;
    private String address;
    private int phoneNum;



    public AppUser() { }

    public AppUser(int id, String username, String password, String address, int phoneNum)
    {
        this.id = id;
        this.email = username;
        this.password = password;
        this.address = address;
        this.phoneNum = phoneNum;

    }

    public int getId() {return id;}

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getAddress() { return address; }

    public int getPhone() { return phoneNum; }

    public void setId(int id) { this.id = id; }

    public void setEmail(String username)
    {
        this.email = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setAddress(String address) { this.address = address; }

    public void setPhone(int phone) { this.phoneNum = phoneNum; }




}
