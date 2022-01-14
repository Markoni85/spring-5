package io.javabrains.springsecurityfacebooklogin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springsecurityfacebooklogin.model.Student;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
	public static List<Student> STUDENTS = Arrays.asList(
			new Student(1, "John Smith"), 
			new Student(2, "Maria Valverde"),
			new Student(3, "Sam Jeson"));
	
	@GetMapping
	public List<Student> getAllStudents() {
		return STUDENTS;
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		System.out.println(student);
	}
	
	@DeleteMapping(path = "/{studentId}")
	public void deleteStudent(@PathVariable("studentId") long studentId) {
		System.out.println("Deleting student := " + studentId);
	}
	
	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable("studentId")long studentId, @RequestBody Student student) {
		System.out.println(String.format("%s  %s", studentId, student));
	}
}
