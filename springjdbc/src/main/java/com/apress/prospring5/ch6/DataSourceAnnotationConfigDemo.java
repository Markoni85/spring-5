package com.apress.prospring5.ch6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.apress.prospring5.ch6.config.DbConfig;
import com.apress.prospring5.ch6.entities.Singer;

public class DataSourceAnnotationConfigDemo {

	public static void main(String[] args) {
		GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(DbConfig.class);
		
		DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
		try {
			testDataSource(dataSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void testDataSource(DataSource dataSource) throws SQLException{
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("select * from singer limit 1");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Singer singer = new Singer();
				singer.setBirthDate(result.getDate("birth_date"));
				singer.setId(result.getLong("id"));
				singer.setFirstName(result.getString("first_name"));
				singer.setLastName(result.getString("last_name"));
				
				System.out.println(" First Name: " + singer.getFirstName());
			}
			statement.close(); 
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			if(connection != null) {
				connection.close();
			}
		}
	}
}
