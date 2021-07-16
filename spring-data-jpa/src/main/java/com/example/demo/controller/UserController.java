package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/getUsers")
	public List<User> getAllUsers() {
		return service.getUsers();
	}
	
	@GetMapping("/getUsersByProfession/{profession}")
	public List<User> getUsersByProfession(@PathVariable String profession) {
		return service.getUsersByProfession(profession);
	}
	
	@GetMapping("/getUserCount/{age}")
	public String getCountByAge(@PathVariable int age) {
		long count = service.getUserCount(age);
		return "Total number of users at age " + age + " is: " + count;
	}
	
	@DeleteMapping("/deleteUser/{name}")
	public List<User> deleteUser(@PathVariable String name) {
		return service.deleteUser(name);
	}
	
	@GetMapping("/getUsersByProfessionAndAge/{profession}/{age}")
	public List<User> getUsersByMultiConditions(@PathVariable String profession, @PathVariable Integer age) {
		return service.getUsersByMultiConditions(profession, age);
	}
	
	@GetMapping("/getUsersIgnoreCase/{profession}")
	public List<User> getUsersIgnorecase(@PathVariable String profession) {
		return service.getUsersIgnoreCase(profession);
	}
	
	@GetMapping("/getSortedUsers/{field}")
	public List<User> getSortedUsers(@PathVariable String field) {
		return service.getUsersSort(field);
	}
	
	@GetMapping("/getPaginatedUsers")
	public Page<User> getPaginatedUsers() {
		return service.getPaginatedUser();
	}
	
	@GetMapping("/getUsersCustomQuery")
	public List<User> getUsersCustomQuery() {
		return service.getUsersCustomQuery();
	}
}
