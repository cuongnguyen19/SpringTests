package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepo repo;
	
	@PostConstruct
	public void initDB() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, "John", "IT", 20));
		users.add(new User(2, "Jack", "Business", 25));
		users.add(new User(3, "Chris", "Accounting", 30));
		users.add(new User(4, "Ron", "Teacher", 35));
		users.add(new User(5, "Roy", "Engineer", 40));
		repo.saveAll(users);
	}
	public List<User> getUsers() {
		return repo.findAll();
	}
	public List<User> getUsersByProfession(String profession) {
		return repo.findByProfession(profession);
	}
	public long getUserCount(int age) {
		return repo.countByAge(age);
	}
	public List<User> deleteUser(String name) {
		return repo.deleteByName(name);
	}
	public List<User> getUsersByMultiConditions(String profession, Integer age) {
		return repo.findByProfessionAndAge(profession, age);
	}
	public List<User> getUsersIgnoreCase(String profession) {
		return repo.findByProfessionIgnoreCase(profession);
	}
	public List<User> getUsersSort(String field) {
		return repo.findAll(Sort.by(field));
	}
	public Page<User> getPaginatedUser() {
		return repo.findAll(PageRequest.of(0, 3));
	}
	public List<User> getUsersCustomQuery() {
		return repo.getUsersCustomQuery();
	}
}
