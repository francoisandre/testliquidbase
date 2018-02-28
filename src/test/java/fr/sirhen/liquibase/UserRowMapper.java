package fr.sirhen.liquibase;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import info.francoisandre.testliquibase.model.User;

public class UserRowMapper implements RowMapper < User > {
	public User mapRow(final ResultSet rs, final int rowNum) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString("email"));
		user.setFullname(rs.getString("fullname"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}