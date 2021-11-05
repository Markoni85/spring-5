package org.springframework.learn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.learn.dao.SingerDao;
import org.springframework.learn.model.Singer;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SingerService {

	
	@Autowired
	private SingerDao singerDao;
	
	public List<Singer> getSingers() {
		List<Singer> singers  =  singerDao.findAll();
		return singers;
	}
}
