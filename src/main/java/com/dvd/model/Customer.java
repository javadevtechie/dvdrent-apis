package com.dvd.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.dvd.DVDutil;

public class Customer {
	private String fullName;
	private String email;
	private String address;
	private String city;
	private String country;
	private BigDecimal totalAmount;
	
	public Customer() {
	
	}

	public Customer(ResultSet rs) throws SQLException {
		List<String> retrievedColumns = DVDutil.retrievedColumns(rs);
		this.setFullName(DVDutil.extractField("full_name", rs, retrievedColumns, String.class));
		this.setEmail(DVDutil.extractField("email", rs, retrievedColumns, String.class));
		this.setAddress(DVDutil.extractField("address", rs, retrievedColumns, String.class));
		this.setCity(DVDutil.extractField("city", rs, retrievedColumns, String.class));
		this.setCountry(DVDutil.extractField("country", rs, retrievedColumns, String.class));
		this.setTotalAmount(DVDutil.extractField("payment", rs, retrievedColumns, 	BigDecimal.class));
		System.out.println();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}
