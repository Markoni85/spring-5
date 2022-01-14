package com.myspringpath.studenteurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
	
@SpringBootApplication
@EnableEurekaClient
public class StudentEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentEurekaClientApplication.class, args);
	}
	
//	  @Bean
//	  public CommandLineRunner demo(StudentRepository repository) {
//	    return (args) -> {
//	      // save a few customers
//	      List<Student> students =  (List<Student>) repository.findAll();
//	      for (Student st : students) {
//	    	  System.out.println(st);
//	      }
//	    };
//	  }

}
