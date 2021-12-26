package com.myspringpath.studentlearningeurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.myspringpath.studentlearningeurekaclient.Model.StudentInfo;

import reactor.core.publisher.Flux;

@RestController
public class StudentNonBlockingController {

    @Autowired
    private RestTemplate restTemplate;
	
//	@GetMapping(value = "/tweets-non-blocking", 
//            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//	public Flux<StudentInfo> getStudentsInfoNonBlocking() {
//	    System.out.println("Starting NON-BLOCKING Controller!");
//	    Flux<StudentInfo> tweetFlux = WebClient.create()
//	      .get()
//	      .uri("http://students-service/students") //replace with service name
//	      .retrieve()
//	      .bodyToFlux(StudentInfo.class);
//
//	    tweetFlux.subscribe(tweet -> {
//	    	System.out.println(tweet.toString());
//	    });
//	    
//	    System.out.println("Exiting NON-BLOCKING Controller!");
//	    return tweetFlux;
//	}
    
	@GetMapping(value = "/students-info")
	public StudentInfo[] getStudentsInfoBlocking() {
		ResponseEntity<StudentInfo[]> response =
				  restTemplate.getForEntity(
				  "http://students-service/students",
				  StudentInfo[].class);
		StudentInfo[] students = response.getBody();
		
		return students;
	}
}
