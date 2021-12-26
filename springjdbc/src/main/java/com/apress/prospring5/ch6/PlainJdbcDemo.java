package com.apress.prospring5.ch6;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apress.prospring5.ch6.dao.PlainSingerDao;
import com.apress.prospring5.ch6.dao.SingerDao;
import com.apress.prospring5.ch6.entities.Singer;

public class PlainJdbcDemo {
	private static SingerDao singerDao = new PlainSingerDao();
	private static Logger logger = LoggerFactory.getLogger(PlainJdbcDemo.class);

	public static void main(String[] args) {
		
		logger.info("Showing initial DB state");
		
		listAllSingers();
	}
	
	private static void listAllSingers() {
		List<Singer> singers = singerDao.findAll();
		for (Singer singer : singers) {
			logger.info(singer.toString());
		}
	}
}
