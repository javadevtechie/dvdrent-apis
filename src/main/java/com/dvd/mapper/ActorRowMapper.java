package com.dvd.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dvd.model.Actor;

public class ActorRowMapper implements  RowMapper<Actor> {

	@Override
	public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Actor(rs);
	}

}
