package com.example.appRegistration.dao;

import java.util.List;

import com.example.appRegistration.model.User;

public interface UserDao {

	List<User> getAllUsers();

	User getUser(String id);

	String addUser(User user);
	
	String removeUser(String id);

}
