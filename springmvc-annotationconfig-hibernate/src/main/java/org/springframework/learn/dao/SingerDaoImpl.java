package org.springframework.learn.dao; 

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Singer> criteria = builder.createQuery(Singer.class);
	    criteria.from(Singer.class);
	    
	    List<Singer> data = session.createQuery(criteria).getResultList();
	    return data;
		
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
		Session session = getSession();
		
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Singer> criteria = builder.createQuery(Singer.class);
	    Root<Singer> root = criteria.from(Singer.class);
	    
	    CriteriaQuery<Singer> cc = criteria.select(root)
	    	.where(builder.like(root.get("firstName"), "%"+firstName+"%"));
	    
	    Query<Singer> finalQuery = session.createQuery(cc);
	    
	    List<Singer> data = finalQuery.getResultList();
	    return data;
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
		getSession().save(singer);
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
