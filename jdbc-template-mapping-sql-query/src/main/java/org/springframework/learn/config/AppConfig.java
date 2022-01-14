package org.springframework.learn.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan(basePackages = "org.springframework.learn.dao")
public class AppConfig {

	//private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	@Bean
	public DataSource dataSource() {
		try {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			
			DataSource ds = builder
			.setType(EmbeddedDatabaseType.H2)
			.addScripts(
					"classpath:db/h2/schema.sql",
					"classpath:db/h2/data.sql"
			)
			.build();
			
			return ds;
		} catch (Exception e) {
			//logger.error("Embedded DataSource bean cannot be created!", e);
			return null;
		}
	}
}
