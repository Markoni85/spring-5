package io.spring5.learn.hibernate.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.spring5.learn.hibernate.entities.Singer;

@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {

	final static String ALL_SINGER_NATIVE_QUERY =
			"select id, first_name, last_name, birth_date, version from singer";
	
	private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional(readOnly=true)
	@Override
	public List<Singer> findAll() {
		List<Singer> allSingers = entityManager.createNamedQuery("singer.findAll", Singer.class)
				.getResultList();
		return allSingers;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Singer> findAllWithAlbum() {
		List<Singer> allWithAlbums = entityManager.createNamedQuery("singer.findAllWithAlbum", Singer.class)
				.getResultList();
		return allWithAlbums;
	}

	@Transactional(readOnly=true)
	@Override
	public Singer findById(Long id) {
		// TODO Auto-generated method stub
		Singer s = entityManager.createNamedQuery("singer.findSingerById", Singer.class)
				.setParameter("id", id)
				.getSingleResult();
		
		return s;
	}

	@Override
	public Singer save(Singer singer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Singer singer) {
		// TODO Auto-generated method stub

	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Singer> findAllByNativeQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayAllSingerSummary() {
		List result = entityManager.createQuery(
		    "select s.firstName, s.lastName, s.title from Singer s "
		  + " left join s.albums a where"
	      + " a.releaseDate = (select max(a2.releaseDate) from Album a2 where a2.singer.id = s.id)"
		).getResultList();
		int count = 0;
		for(Iterator<Object[]> it = result.iterator(); it.hasNext();) {
			Object[] rowValues = it.next();
			
			System.out.println(++count + ": " + rowValues[0] + ", "
					+ rowValues[1] + ", " + rowValues[2]);
		}
		
	}

}
