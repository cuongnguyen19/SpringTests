package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	/*
	 * List<Student> findByMajor(String major); List<Student>
	 * findByIdGreaterThan(int id);
	 * 
	 * @Query("from Student where major=?1 order by name") List<Student>
	 * findByMajorSorted(String major);
	 */
	
}
