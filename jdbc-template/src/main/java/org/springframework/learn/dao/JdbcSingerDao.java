package org.springframework.learn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.learn.model.Singer;

public class JdbcSingerDao implements SingerDao, InitializingBean{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Singer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Singer> findByFirstName(String firstName) {
		String sql = "select * from singer where first_name = :singerName";
		Map<String, String> namedParameters = new HashMap<String, String>();
		namedParameters.put("singerName", firstName);
		
		//	You can also use the BeanPropertyRowMapper class to simplify the code, for example:
		//  e.g. : List<Singer> singers = template.query(sql, param, BeanPropertyRowMapper.newInstance(Singer.class));
		try {
			List<Singer> singers = namedParameterJdbcTemplate.query(
					sql,
					namedParameters, 
					new ResultSetExtractor<List<Singer>>() {
						List<Singer> singers = new ArrayList<Singer>();
						
						public List<Singer> extractData(ResultSet rs) throws SQLException, DataAccessException {
							while(rs.next()) {
								Singer s = new Singer();
								s.setId(rs.getLong("id"));
								s.setFirstName(rs.getString("first_name"));
								s.setLastName(rs.getString("last_name"));
								s.setBirthDate(rs.getDate("birth_date"));
								
								singers.add(s);
							}
							
							return singers;
						}
					});
			
			return singers;
		} catch (Exception e) {
			// TODO: handle exceptionretu
			return null;
		}
	}

	public String findLastNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String findFullNameById(Long id) {
		String sql = "select first_name || ' ' || last_name from singer where id = ?";
		
		String result = jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
			
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					return rs.getString(1);
				}

				return null;
			}
		}, new Object[] { id });
		
		return result;
	}


	public void insert(Singer singer) {
	    
	    String sql = "INSERT INTO singer (first_name, last_name, birth_date) VALUES (:firstName, :lastName, :birthDate)";
	 
	    BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(singer);
	 
	    namedParameterJdbcTemplate.update(sql, paramSource);
	}


	public void update(Singer singer) {
		// TODO Auto-generated method stub

	}

	public void delete(Long singerId) {
		// TODO Auto-generated method stub

	}

	public List<Singer> findAllWithDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertWithDetail(Singer singer) {
		// TODO Auto-generated method stub

	}
	
	public void afterPropertiesSet() throws Exception {
		if(this.jdbcTemplate == null) {
			throw new BeanCreationException("Error initializing bean");
		}
	}

}
