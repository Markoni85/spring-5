package org.springframework.learn.controller;

import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.learn.model.Singer;
import org.springframework.learn.service.SingerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingerController {
	
	@Autowired
	private SingerServiceImpl service;

	@GetMapping("/")
	public String Test() {
		return "Hellooo there";
	}
	
	@GetMapping("/all")
	public List<Singer> findAllSingers() {
		return service.getSingers();
	}
}
