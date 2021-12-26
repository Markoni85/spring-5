package com.apress.prospring5.ch6;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DbConfigTest {
	private static Logger logger = LoggerFactory.getLogger(DbConfigTest.class);

//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (Exception e) {
//			logger.error("Unable to load jdbc driver", e);
//		}
//	}

	@Test
	public void testXmlApplicationContext() throws SQLException {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:drivermanager-cfg-01.xml");
		context.refresh();

		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		assertNotNull(dataSource);
		testDataSource(dataSource);
		context.close();
	}

	private void testDataSource(DataSource dataSource) throws SQLException {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT 1");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int mockVal = resultSet.getInt("1");
				assertTrue(mockVal == 1);
			}
			statement.close();
		} catch (Exception e) {
			logger.debug("Something unexpected happened.", e);
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
}
