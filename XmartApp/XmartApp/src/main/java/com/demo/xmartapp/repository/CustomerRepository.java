package com.demo.xmartapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.xmartapp.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

	
}
