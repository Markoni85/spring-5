package com.apress.prospring5.ch6;


import javax.sql.DataSource;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DataSourceXmlConfigurationDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:drivermanager-cfg-01.xml");
		context.refresh();
		
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		
		
		context.close();
	}
}
