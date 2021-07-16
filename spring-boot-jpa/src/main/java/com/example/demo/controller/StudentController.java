package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@RestController
public class StudentController {
	@Autowired
	StudentRepo repo;

	@RequestMapping("home")
	public String home() {
		return "home.jsp";
	}

	@PostMapping(path="/student", consumes= {"application/json"})
	public Student addStudent(@RequestBody Student s) {
		repo.save(s);
		return s;
	}
	
	@DeleteMapping("/student/{id}") 
	public String deleteStudent(@PathVariable int id)  {
		Student s = repo.getOne(id);
		repo.delete(s);
		return "deleted";
	}
	
	@PutMapping(path="/student", consumes= {"application/json"})
	public Student saveOrUpdateStudent(@RequestBody Student s) {
		repo.save(s);
		return s;
	}

	/*
	 * @RequestMapping("/getStudent") public ModelAndView getStudent(@RequestParam
	 * int id) { ModelAndView mv = new ModelAndView("showStudent.jsp"); Student
	 * student = repo.findById(id).orElse(new Student());
	 * 
	 * 
	 * System.out.println(repo.findByMajor("IT"));
	 * System.out.println(repo.findByIdGreaterThan(2));
	 * System.out.println(repo.findByMajorSorted("Business"));
	 * 
	 * 
	 * mv.addObject(student); return mv; }
	 */
		
	@GetMapping("/students")
	public List<Student> getStudents() {
		return repo.findAll();
	}
	
	@RequestMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {
		return repo.findById(id);
	}
}
