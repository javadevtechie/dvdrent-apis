package com.dvd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DVDutil {

	public static List<String> retrievedColumns(ResultSet rs) throws SQLException {
		java.util.List<String> retrievedColumns = new java.util.ArrayList<>();
		java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		for (int i = 1; i <= columns; i++) {
			retrievedColumns.add(rsmd.getColumnName(i));
		}
		return retrievedColumns;
	}

	public static <T> T extractField(String field, ResultSet rs, List<String> retrievedColumns, Class<T> clazz)
			throws SQLException {
		if (clazz.equals(LocalDateTime.class)) {
			if (retrievedColumns.contains(field.toLowerCase()) && rs.getTimestamp(field.toLowerCase()) != null) {
				return (T) rs.getTimestamp(field.toLowerCase()).toLocalDateTime();
			}
		}
		return retrievedColumns.contains(field.toLowerCase()) ? rs.getObject(field.toLowerCase(), clazz) : null;
	}

	public static <T> List<T> extractArray(String field, ResultSet rs, List<String> retrievedColumns, Class<T> clazz)
			throws SQLException {
		if (retrievedColumns.contains(field.toLowerCase()) && rs.getArray(field.toLowerCase()) != null) {
			return Stream.of((T[]) rs.getArray(field.toLowerCase()).getArray()).collect(Collectors.toList());
		}
		return null;
	}
}
