package com.myspringpath.studentlearningeurekaclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myspringpath.studentlearningeurekaclient.model.StudentInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class StudentInfoService {

    @Autowired
    private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getAllFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
		    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
		    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
		    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
	})
	public ResponseEntity<StudentInfo[]> getStudentInformation() {
		return restTemplate.getForEntity("http://students-service/students", StudentInfo[].class);
	}
	
	public ResponseEntity<StudentInfo[]> getAllFallback() {
		return new ResponseEntity<StudentInfo[]>(new StudentInfo[0], HttpStatus.OK);
	}
}
