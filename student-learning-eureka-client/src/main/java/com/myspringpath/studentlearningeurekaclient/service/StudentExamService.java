package com.myspringpath.studentlearningeurekaclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myspringpath.studentlearningeurekaclient.model.StudentExamInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class StudentExamService {
    @Autowired
    private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getAllFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
		    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
		    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
		    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
	})
	public StudentExamInfo getStudentExamInfo(int studentId) {
		restTemplate.
	}
}
