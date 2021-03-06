package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	public List<User> findByProfession(String profession);
	public long countByAge(int age);
	public List<User> deleteByName(String name);
	public List<User> findByProfessionAndAge(String profession, int age);
	public List<User> findByProfessionIgnoreCase(String profession);
	@Query("select u from User u")
	public List<User> getUsersCustomQuery();
}
