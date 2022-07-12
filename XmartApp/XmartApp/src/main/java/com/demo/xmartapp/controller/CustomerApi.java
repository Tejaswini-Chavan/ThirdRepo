package com.demo.xmartapp.controller;

import com.demo.xmartapp.dto.CustomerDTO;
import com.demo.xmartapp.entity.CustomerEntity;
import com.demo.xmartapp.service.CustomerService;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerApi {

    @Autowired
    private CustomerService customerServiceImpl;

    @GetMapping(value="/")
    public String welcome(){
        return "Welcome to X-mart Application!";
    }

    //Add Crud methods to the code
	
    
    @PostMapping("/addCustomer")
    public CustomerEntity registerNewCustomer(@Valid @RequestBody CustomerDTO customerDTO)
    {
        return customerServiceImpl.registerNewCustomer(customerDTO);
    }
    
	@GetMapping("/customerslist")
    public List<CustomerEntity> fetchCustomerList()
    {
        return customerServiceImpl.fetchCustomerList();
    }
    
    @PutMapping("/updatePassword")
    public CustomerEntity updatePassword(@RequestBody CustomerDTO customerDTO)
    {
        return customerServiceImpl.updatePassword(customerDTO);
    }
    
    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomerById(@PathVariable("id") String emailId)
    {
    	customerServiceImpl.deleteCustomerById(emailId);
        return "Deleted Successfully";
    }
    
}

