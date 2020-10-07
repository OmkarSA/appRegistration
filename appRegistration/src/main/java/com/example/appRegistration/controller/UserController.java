package com.example.appRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appRegistration.dao.UserDao;
import com.example.appRegistration.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") String id) {
		return userDao.getUser(id);
	}

	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		return userDao.addUser(user);
	}
}
