package com.AccessManagement.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserExtendedDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	public List<JwtRequest> getDetailsAll(String username) {

		return jdbcTemplate.query(
				"select u.username From u where username=?",
				new BeanPropertyRowMapper<JwtRequest>(JwtRequest.class), new Object[] { username });

	}
	
}
