package com.dvd.service;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectJoinStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dvd.mapper.ActorRowMapper;
import com.dvd.model.Actor;
import com.model.rental.Tables;

@Service
public class ActorService {

	@Autowired
	DSLContext dsl;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Actor> getAllActors() {
		SelectJoinStep<Record> from = dsl.select().from(Tables.ACTOR);

		return jdbcTemplate.query(from.getSQL(), new ActorRowMapper());
		
	}

}
