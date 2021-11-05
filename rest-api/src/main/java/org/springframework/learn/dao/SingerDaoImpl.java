package org.springframework.learn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.learn.model.Singer;
import org.springframework.stereotype.Repository;

@Repository
public class SingerDaoImpl implements SingerDao {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Singer> findAll() {
		Session session = getSession();
		
		@SuppressWarnings("unchecked")
		List<Singer> singers =  session.createCriteria(Singer.class).list();
		
		return singers;
		
	}

	private Session getSession() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (Exception e) {
			session = factory.openSession();
		}
		
		return session;
	}

	@Override
	public List<Singer> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findLastNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findFirstNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Singer singer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Singer singer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long singerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Singer> findAllWithDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithDetail(Singer singer) {
		// TODO Auto-generated method stub
		
	}

}
