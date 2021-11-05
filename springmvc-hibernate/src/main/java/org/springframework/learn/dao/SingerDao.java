package org.springframework.learn.dao;

import java.util.List;

import org.springframework.learn.model.Singer;

public interface SingerDao {
	List<Singer> findAll();

	List<Singer> findByFirstName(String firstName);

	String findLastNameById(Long id);

	String findFirstNameById(Long id);

	void insert(Singer singer);

	void update(Singer singer);

	void delete(Long singerId);

	List<Singer> findAllWithDetail();

	void insertWithDetail(Singer singer);
}