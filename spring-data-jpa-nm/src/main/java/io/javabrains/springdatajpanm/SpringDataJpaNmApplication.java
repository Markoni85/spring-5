package io.javabrains.springdatajpanm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.javabrains.springdatajpanm.model.Course;
import io.javabrains.springdatajpanm.repository.CourseRepository;

@SpringBootApplication
public class SpringDataJpaNmApplication implements CommandLineRunner {

	
	@Autowired
	private CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaNmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course c1 = new Course("Java Spring Boot");
//		Course c2 = new Course("Node Js");
//		
//		courseRepository.save(c1);
//		courseRepository.save(c2);
	}

}
