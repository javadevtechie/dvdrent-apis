package com.dvd.service;

import static com.model.rental.Tables.CUSTOMER;
import static com.model.rental.Tables.PAYMENT;
import static com.model.rental.Tables.ADDRESS;
import static com.model.rental.Tables.CITY;
import static com.model.rental.Tables.COUNTRY;
import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.sum;

import java.math.BigDecimal;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record6;
import org.jooq.SelectHavingStep;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dvd.mapper.ActorRowMapper;
import com.dvd.mapper.CustomerRowMapper;
import com.dvd.model.Customer;

@Service
public class CustomerService {
	@Autowired
	DSLContext dsl;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Customer> getRewardCustomers() {

		SelectHavingStep<Record6<String, String, BigDecimal, String, String, String>> from = dsl
				.select(CUSTOMER.FIRST_NAME, CUSTOMER.EMAIL, sum(PAYMENT.AMOUNT).as("payment"), ADDRESS.ADDRESS_,
						CITY.CITY_, COUNTRY.COUNTRY_)
				.from(CUSTOMER)
				.join(PAYMENT).on(PAYMENT.CUSTOMER_ID.eq(CUSTOMER.CUSTOMER_ID))
				.join(ADDRESS)
				.on(ADDRESS.ADDRESS_ID.eq(CUSTOMER.ADDRESS_ID))
				.join(CITY).on(CITY.CITY_ID.eq(ADDRESS.CITY_ID))
				.join(COUNTRY).on(COUNTRY.COUNTRY_ID.eq(CITY.COUNTRY_ID)).groupBy(CUSTOMER.FIRST_NAME, CUSTOMER.EMAIL,
						 ADDRESS.ADDRESS_, CITY.CITY_, COUNTRY.COUNTRY_);
		System.out.println(from.getSQL());
		
		String query="select concat(c.first_name, ' ', c.last_name) as full_name, c.email ,sum(p.amount) as payment,a.address ,c2.city ,c3.country  from customer c \r\n" + 
				"join payment p \r\n" + 
				"on c.customer_id =p.customer_id \r\n" + 
				"join address a \r\n" + 
				"on a.address_id =c.address_id \r\n" + 
				"join city c2 \r\n" + 
				"on c2.city_id =a.city_id \r\n" + 
				"join country c3 \r\n" + 
				"on c3.country_id =c2.country_id \r\n" + 
				"group by 1,2,4,5,6\r\n" + 
				"order by  3 desc\r\n" + 
				"limit 10\r\n" ;
		return jdbcTemplate.query(query, new CustomerRowMapper());
	}

}
