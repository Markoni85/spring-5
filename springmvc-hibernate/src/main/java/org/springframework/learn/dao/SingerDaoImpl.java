package org.springframework.learn.dao; 

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.learn.model.Album;
import org.springframework.learn.model.Singer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SingerDaoImpl implements SingerDao {

	@Autowired
	// @Resource(name = "sessionFactory")
	private SessionFactory factory;
	
	@Transactional(readOnly = true)
	@Override
	public List<Singer> findAll() {
		Session session = getSession();
		
		Query<Singer> hqlQuerry = session.createQuery("from Singer s "
				+ "left join fetch s.albums a "
			    + "where s.firstName like :name");
		hqlQuerry.setParameter("name", "Eric");
		
        List<Singer> data =  hqlQuerry.getResultList();
	    
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
