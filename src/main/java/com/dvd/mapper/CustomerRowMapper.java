package com.dvd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dvd.model.Customer;


public class CustomerRowMapper  implements  RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Customer(rs);
	}

}