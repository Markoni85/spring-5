package com.myspringpath.studenteurekaclient.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringpath.studenteurekaclient.model.Student;
import com.myspringpath.studenteurekaclient.repository.StudentRepository;

@RestController
@RequestMapping("students")
public class StudentController {

	@Autowired
	private StudentRepository repository;
	
	@GetMapping
	public List<Student> getAll() {
		List<Student> students = (List<Student>) repository.findAll();
		
		return students;
	}
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable long id) {
		try {
			return repository.findById(id).get();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return null;
		}
	}
}
