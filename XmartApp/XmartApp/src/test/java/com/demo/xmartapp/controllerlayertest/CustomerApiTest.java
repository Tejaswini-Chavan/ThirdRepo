package com.demo.xmartapp.controllerlayertest;

import com.demo.xmartapp.controller.CustomerApi;
import com.demo.xmartapp.dto.CustomerDTO;
import com.demo.xmartapp.entity.CustomerEntity;
import com.demo.xmartapp.service.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
public class CustomerApiTest {

	private CustomerEntity customerEntity;
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerServiceImpl customerServiceImpl;

	@InjectMocks
	private CustomerApi customerApi;

	private List<CustomerEntity> customerEntityList = new ArrayList<>();

	@Test
	@BeforeEach()
	public void init() {
		CustomerDTO dto = new CustomerDTO();

		dto.setEmailId("akshay@gmail.com");
		dto.setName("Akshay");
		dto.setPassword("Akshay@59");
		dto.setAddress("Pune");
		dto.setPhoneNumber("9874563210");
		customerEntity = new CustomerEntity(dto);
		CustomerDTO dto1 = new CustomerDTO();
		dto1.setEmailId("Hemant@gmail.com");
		dto1.setName("Hemant");
		dto1.setPassword("Hemant@59");
		dto1.setAddress("Pune");
		dto1.setPhoneNumber("8874563210");
		CustomerEntity customerEntity1 = new CustomerEntity(dto1);

		customerEntityList.add(customerEntity1);
		customerEntityList.add(customerEntity);
	}

	@Test
	public void fetchCustomerListTest() throws Exception {
		/*
		 * mockMvc.perform(MockMvcRequestBuilders.get("/")).andDo(print())
		 * //.andExpect(status().isOk()) .andExpect((ResultMatcher)
		 * content().string(containsString("Welcome to X-mart Application!")));
		 */
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(new ResultMatcher() {
			@Override
			public void match(MvcResult result) throws Exception {
				result.getRequest();
			}
		});

	}

}
