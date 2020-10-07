package com.example.appRegistration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.appRegistration.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		String query = "select * from users";

		List<User> user = jdbcTemplate.query(query, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(rs.getString("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setNumber(rs.getString("phone"));
				return user;
			}
		});
		return user;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		String query = "select * from users where id = " + id;

		List<User> user = jdbcTemplate.query(query, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(rs.getString("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setNumber(rs.getString("phone"));
				return user;
			}
		});
		if (user.size() > 0)
			return user.get(0);
		else
			return null;
	}

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		String query = "insert into users(first_name, last_name, email, phone) values(?,?,?,?)";

		int count = jdbcTemplate.update(query,
				new Object[] { user.getFirstName(), user.getLastName(), user.getEmail(), user.getNumber() });
		
		if(count == 1)
			return "User added";
		else
			return "User not added";
	}

}
