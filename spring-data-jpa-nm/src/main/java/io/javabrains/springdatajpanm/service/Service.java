package io.javabrains.springdatajpanm.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springdatajpanm.model.Course;
import io.javabrains.springdatajpanm.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class Service {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@GetMapping
	public List<Course> getAll() {
		List<Course> courses = (List<Course>) courseRepository.findAll();
		return courses;
	}
}
