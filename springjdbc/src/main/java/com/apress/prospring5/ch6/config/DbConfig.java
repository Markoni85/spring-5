package com.apress.prospring5.ch6.config;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@PropertySource("classpath:db/jdbc.properties")
public class DbConfig {

	//	jdbc.driverClassName=com.mysql.cj.jdbc.Driver
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
	//	jdbc.url=jdbc:mysql://localhost:3306/musicdb?useSSL=true
	@Value("${jdbc.url}")
	private String url;
	
	//	jdbc.username=prospring5
	
	@Value("${jdbc.username}")
	private String username;

	//	jdbc.password=prospring5
	@Value("${jdbc.password}")
	private String password;
	
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
	
	@Lazy
	@Bean
	public DataSource dataSource() {
		try {
			SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
			Class<? extends Driver> driverClass = (Class<? extends Driver>)Class.forName(driverClassName);
			
			dataSource.setDriverClass(driverClass);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			
			return dataSource;
		} catch (Exception e) {
			return null;
		}
	}	
}
