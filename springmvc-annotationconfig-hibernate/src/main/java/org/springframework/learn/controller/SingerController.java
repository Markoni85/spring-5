package org.springframework.learn.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.learn.model.Singer;
import org.springframework.learn.service.SingerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singer")
public class SingerController {
	
	@Autowired
	private SingerService service;

	@GetMapping("")
	public String Test() {
		return "Hellooo there";
	}
	
	@GetMapping("all")
	public List<Singer> findAllSingers() {
		return service.getSingers();
	}
	
	@GetMapping("all/filter")
	public List<Singer> findAllSingers(@RequestParam(required =  false) String firstName) {
		return service.findByFirstName(firstName);
	}
}
