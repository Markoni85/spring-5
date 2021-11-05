package org.springframework.learn.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.learn.dao.JdbcSingerDao;
import org.springframework.learn.dao.SingerDao;

@Configuration
public class EmbeddedJdbcConfig {

	//private static Logger logger = LoggerFactory.getLogger(EmbeddedJdbcConfig.class);
	
	@Bean
	public DataSource dataSource() {
		try {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			
			return builder
			.setType(EmbeddedDatabaseType.H2)
			.addScripts(
					"classpath:db/h2/schema.sql",
					"classpath:db/h2/data.sql"
			)
			.build();
		} catch (Exception e) {
			//logger.error("Embedded DataSource bean cannot be created!", e);
			return null;
		}
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
		return namedParameterJdbcTemplate;
	}
	
	@Bean
	public SingerDao singerDao() {
		JdbcSingerDao dao = new JdbcSingerDao();
		dao.setJdbcTemplate(jdbcTemplate());
		return dao;
	}
}
