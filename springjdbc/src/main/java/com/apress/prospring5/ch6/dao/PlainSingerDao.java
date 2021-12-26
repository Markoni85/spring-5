package com.apress.prospring5.ch6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apress.prospring5.ch6.entities.Singer;

public class PlainSingerDao implements SingerDao {

	private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			logger.error("Unable to load jdbc driver", e);
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/musicdb?useSSL=true", "prospring5",
				"prospring5");
	}

	private void closeConnection(Connection connection) {
		if (connection == null) {
			return;
		}

		try {
			connection.close();
		} catch (SQLException e) {
			logger.error("Problem with closing DB connection", e);
		}
	}

	public List<Singer> findAll() {
		List<Singer> singers = new ArrayList<Singer>();

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement stateMent = connection.prepareStatement("Select * from singer");

			ResultSet result = stateMent.executeQuery();
			while (result.next()) {
				Singer singer = new Singer();
				singer.setId(result.getLong("id"));
				singer.setFirstName(result.getString("first_name"));
				singer.setLastName(result.getString("last_name"));
				singer.setBirthDate(result.getDate("birth_date"));

				singers.add(singer);
			}

		} catch (SQLException e) {
			logger.error("Problem when executing SELECT!", e);
		} finally {
			closeConnection(connection);
		}

		return singers;
	}

	public List<Singer> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String findLastNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String findFirstNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Singer singer) {

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement stateMent = connection.prepareStatement(
					"insert into singer (first_name, last_name, birth_date)" + "values(?, ? , ?)",
					Statement.RETURN_GENERATED_KEYS);
			stateMent.setString(1, singer.getFirstName());
			stateMent.setString(2, singer.getLastName());
			stateMent.setDate(3, singer.getBirthDate());

			ResultSet generatedKeys = stateMent.getGeneratedKeys();
			if (generatedKeys.next()) {
				singer.setId(generatedKeys.getLong(1));
			}

		} catch (SQLException e) {
			logger.error("Prblem executing INSERT", e);
		} finally {
			closeConnection(connection);
		}

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


}
