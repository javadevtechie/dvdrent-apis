package com.dvd.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import com.dvd.DVDutil;

public class Actor {
	private int actorId;
	private String firstName;
	private String lastName;
	private LocalDateTime lastupdatedDate;

	Actor() {

	}

	public Actor(ResultSet rs) throws SQLException {
		List<String> retrievedColumns = DVDutil.retrievedColumns(rs);
		this.setActorId(DVDutil.extractField("actor_id", rs, retrievedColumns, Integer.class));
		this.setFirstName(DVDutil.extractField("first_name", rs, retrievedColumns, String.class));
		this.setLastName(DVDutil.extractField("last_name", rs, retrievedColumns, String.class));
		this.setLastupdatedDate(DVDutil.extractField("last_update", rs, retrievedColumns, LocalDateTime.class));
		
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getLastupdatedDate() {
		return lastupdatedDate;
	}

	public void setLastupdatedDate(LocalDateTime lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}


	
}
