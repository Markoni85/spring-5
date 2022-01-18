package io.spring5.learn.hibernate.controller;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring5.learn.hibernate.entities.Singer;
import io.spring5.learn.hibernate.service.SingerService;

@RestController
@RequestMapping("/musicstore")
public class MusicStoreController {

	@Autowired
	@Qualifier("jpaSingerService")
	private SingerService service;
	
	
	
	@GetMapping("/all")
	@Transactional(readOnly=true)
	public List<Singer> getAllSingers() {
		List<Singer> singers = service.findAll();		
		return singers;
	}
	
	@GetMapping("/all-with-album")
	@Transactional(readOnly=true)
	public List<Singer> getAllWithAlbum() {
		List<Singer> singers = service.findAllWithAlbum();		
		return singers;
	}
	
	@GetMapping("/all/{id}")
	@Transactional(readOnly=true)
	public Singer getById(@PathVariable(name = "id") long id) {
			
		Singer s = service.findById(id);
		System.out.println(s.getAlbums().size());
		return s;
	}

	@GetMapping("/summary")
	@Transactional(readOnly=true)
	public void displayAllSingerSummary(@PathVariable(name = "id") long id) {
		
		service.displayAllSingerSummary();
		return;
	}
}
