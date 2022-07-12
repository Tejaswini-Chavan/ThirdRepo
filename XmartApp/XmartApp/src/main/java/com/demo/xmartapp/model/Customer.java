package com.demo.xmartapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Customer {
    @NotNull(message = "{email.absent}")
    @Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+", message = "{invalid.email.format}")
    @Id
    private String emailId;
    private String name;
    @NotNull(message = "{password.absent}")
    @Pattern(regexp = ".*[A-Z]+.*", message = "{invalid.password.format.uppercase}")
    @Pattern(regexp = ".*[a-z]+.*", message = "{invalid.password.format.lowercase}")
    @Pattern(regexp = ".*[0-9]+.*", message = "{invalid.password.format.number}")
    @Pattern(regexp = ".*[^a-zA-Z-0-9].*", message = "{invalid.password.format.specialcharacter}")
    private String password;

    @Valid
    @Size(max=10, min = 10, message = "{customer.invalid.phonenumber}")
    @Pattern(regexp="(^$|[0-9]{10})", message = "{customer.invalid.phonenumber}")
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
    public Customer setPassword(String password) {
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
