package org.springframework.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.learn.model.Singer;
import org.springframework.learn.service.SingerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller

@RequestMapping("/rest-api")
public class SingerController {

	@Autowired
	private SingerService service;

	@GetMapping("/")
	public String Test() {
		return "Hellooo";
	}
	
	@GetMapping("/singers")
	public List<Singer> findAllSingers() {
		return service.getSingers();
	}
}
