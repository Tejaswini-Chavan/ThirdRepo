package com.demo.xmartapp.dto;

import com.demo.xmartapp.entity.CustomerEntity;

public class CustomerDTO {

    private String emailId;
    private String name;
    private String password;

    private String phoneNumber;
    private String address;




    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
    public CustomerEntity setPassword(String password) {
        this.password = password;
        return null;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
