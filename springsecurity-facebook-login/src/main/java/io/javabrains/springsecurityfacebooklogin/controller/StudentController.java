package io.javabrains.springsecurityfacebooklogin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springsecurityfacebooklogin.model.Student;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	public static List<Student> STUDENTS = Arrays.asList(
			new Student(1, "John Smith"),
			new Student(2, "Maria Valverde"),
			new Student(3, "Sam Jeson")
			);
	
	@GetMapping(path = "{studentId}")
	public Student getById(@PathVariable("studentId") long studentId) {
		return STUDENTS
				.stream()
				.filter(st -> st.getId() == studentId)
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Studnet " + studentId + " not found"));
	}
}
