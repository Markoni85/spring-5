package io.spring5.learn.hibernate;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring5.learn.hibernate.entities.Singer;

@RestController
@RequestMapping("/musicstore")
public class MusicStoreController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping
	@Transactional(readOnly=true)
	public List<Singer> getAllSingers() {
		
		Query q = entityManager.createQuery("from Singer s");
		@SuppressWarnings("unchecked")
		List<Singer> singers = q.getResultList();
		
		return singers;
	}
}
