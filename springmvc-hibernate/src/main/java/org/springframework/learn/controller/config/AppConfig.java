package org.springframework.learn.controller.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class AppConfig {

//	  @Bean public DataSource dataSource() { 
//		  BasicDataSource dataSource = new BasicDataSource(); 
//		  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		  dataSource.setUrl("jdbc:mysql://localhost:3306/musicdb?useSSL=false");
//		  dataSource.setUsername("root"); dataSource.setPassword("Lozinka1");
//	  
//		  return dataSource; 
//	  }
	 
//	@Bean
//	public DataSource dataSource() {
//		try {
//			EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
//			return dbBuilder.setType(EmbeddedDatabaseType.H2).
//					addScript("classpath:db/schema.sql")
//					.addScript("classpath:db/data.sql")
//			.build();
//
//		} catch (Exception e) {
//			System.err.println("Embedded DataSource bean cannot be created!");
//			return null;
//		}
//	}

	 @Bean public DataSource dataSource() { 
		 BasicDataSource dataSource = new BasicDataSource(); 
		 
		 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	     dataSource.setUrl("jdbc:mysql://localhost:3306/musicdb?useSSL=false");
	     dataSource.setUsername("root"); dataSource.setPassword("Lozinka1");
	    
	     return dataSource;
	 }
	
	private Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProp.put("hibernate.format_sql", true);
		hibernateProp.put("hibernate.use_sql_comments", true);
		hibernateProp.put("hibernate.show_sql", true);
		hibernateProp.put("hibernate.max_fetch_depth", 3);
		hibernateProp.put("hibernate.jdbc.batch_size", 10);
		hibernateProp.put("hibernate.jdbc.fetch_size", 50);
		return hibernateProp;
	}
	
	@Bean
	public SessionFactory sessionFactory()
			throws IOException {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("org.springframework.learn.model");
		factoryBean.setHibernateProperties(hibernateProperties());
		factoryBean.afterPropertiesSet();
		
		return factoryBean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		//transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}
