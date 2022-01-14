package org.springframework.learn.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.learn.mapper.SelectAllSingers;
import org.springframework.learn.model.Singer;
import org.springframework.stereotype.Repository;

@Repository("singerDao")
public class JdbcSingerDao implements SingerDao, InitializingBean {

	private DataSource dataSource;
	private SelectAllSingers allSingers; 
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.allSingers = new SelectAllSingers(dataSource);
	}
	
	public void afterPropertiesSet() throws Exception {
		if(dataSource == null) {
			throw new Exception("Data source not provided");
		}
	}

	public List<Singer> findAll() {
		return allSingers.execute();
	}


}
