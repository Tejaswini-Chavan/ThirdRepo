package com.demo.xmartapp.servicelayertest;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.demo.xmartapp.dto.CustomerDTO;
import com.demo.xmartapp.entity.CustomerEntity;
import com.demo.xmartapp.repository.CustomerRepository;
import com.demo.xmartapp.service.CustomerService;
import com.demo.xmartapp.service.CustomerServiceImpl;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CustomerServiceImplTest {

	private CustomerEntity customerEntity;
	private CustomerDTO customerDTO;
	@Mock
	CustomerRepository customerRepository;
	@InjectMocks
	CustomerService customerServiceImpl = new CustomerServiceImpl();

	@Test
	@BeforeEach()
	public void init() {
		customerDTO = new CustomerDTO();
		customerDTO.setName("Akshada");
		customerDTO.setAddress("Pune");
		customerDTO.setPassword("Akshada@59");
		customerDTO.setEmailId("akshada@gmail.com");
		customerDTO.setPhoneNumber("9874563220");
		customerEntity = new CustomerEntity(customerDTO);
	}

	@Test
	@Order(3)
	public void deleteCustomerByIdTest() {
		doNothing().when(customerRepository).deleteById(customerDTO.getEmailId());
		customerServiceImpl.deleteCustomerById(customerDTO.getEmailId());
	}

	@Test
	@Rollback(value = false)
	@Order(1)
	public void registerNewCustomerTest() {
		when(customerRepository.save(any(CustomerEntity.class))).thenReturn(customerEntity);
		CustomerEntity savedCustomerRecord = customerServiceImpl.registerNewCustomer(customerDTO);
		Assertions.assertEquals(savedCustomerRecord.getEmailId(), customerEntity.getEmailId());
	}

	@Test
	@Rollback(value = false)
	@Order(2)
	public void fetchCustomerListTest() {
		List<CustomerEntity> customerEntityList = new ArrayList<>();
		CustomerDTO customerDTO1 = new CustomerDTO();
		customerDTO1.setEmailId("hemant@gmail.com");
		customerDTO1.setName("Hemant");
		customerDTO1.setPassword("Hemant@59");
		customerDTO1.setAddress("Pune");
		customerDTO1.setPhoneNumber("8874563220");
		CustomerEntity customerEntity1 = new CustomerEntity(customerDTO1);
		customerEntityList.add(customerEntity1);
		customerEntityList.add(customerEntity);

		when(customerRepository.findAll()).thenReturn(customerEntityList);
		Assertions.assertEquals(2, customerServiceImpl.fetchCustomerList().size());
	}

	@Test
	public void updatePasswordTest() {
		when(customerRepository.findById(customerEntity.getEmailId()))
				.thenReturn(java.util.Optional.of(customerEntity));
		customerServiceImpl.updatePassword(customerDTO);
		verify(customerRepository).save(customerEntity);
	}
}
