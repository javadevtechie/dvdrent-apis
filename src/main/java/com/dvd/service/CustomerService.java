package com.dvd.service;

import static com.model.rental.Tables.CUSTOMER;
import static com.model.rental.Tables.PAYMENT;
import static org.jooq.impl.DSL.concat;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dvd.model.Customer;


@Service
public class CustomerService {
	@Autowired
	DSLContext dsl;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Customer> getRewaredCustomers(){
		dsl.select(concat(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME).as("full_name"), CUSTOMER.EMAIL,CUSTOMER.ADDRESS_ID ).from(CUSTOMER)
		.leftJoin(PAYMENT).on(CUSTOMER.CUSTOMER_ID.eq(DSL.field("rl.itempguid", Integer.class)));
		
		dsl.select(concat(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME).as("full_name"), CUSTOMER.EMAIL,CUSTOMER.ADDRESS_ID ).from(CUSTOMER)
		.leftJoin(PAYMENT).on(PAYMENT.CUSTOMER_ID.eq(CUSTOMER.CUSTOMER_ID));
		
		return null;
	}
	
	
	
}
