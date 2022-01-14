package com.myspringpath.studentlearningeurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringpath.studentlearningeurekaclient.model.StudentInfo;
import com.myspringpath.studentlearningeurekaclient.service.StudentInfoService;

@RestController
public class StudentNonBlockingController {

	@Autowired
	private StudentInfoService infoService;
	
	@GetMapping(value = "/students-info")
	public StudentInfo[] getStudentsInfoBlocking() {
		ResponseEntity<StudentInfo[]> response = infoService.getStudentInformation();
		StudentInfo[] students = response.getBody();
		
		return students;
	}
}


//@GetMapping(value = "/tweets-non-blocking", 
//produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//public Flux<StudentInfo> getStudentsInfoNonBlocking() {
//System.out.println("Starting NON-BLOCKING Controller!");
//Flux<StudentInfo> tweetFlux = WebClient.create()
//.get()
//.uri("http://students-service/students") //replace with service name
//.retrieve()
//.bodyToFlux(StudentInfo.class);
//
//tweetFlux.subscribe(tweet -> {
//System.out.println(tweet.toString());
//});
//
//System.out.println("Exiting NON-BLOCKING Controller!");
//return tweetFlux;
//}
