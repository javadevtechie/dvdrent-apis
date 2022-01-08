package com.dvd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.model.Customer;
import com.dvd.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/reward")
	public List<Customer> getRewardCustomer() {
		
		return customerService.getRewardCustomers();
	}
	
}
