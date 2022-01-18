package io.spring5.learn.hibernate.service;

import java.util.List;

import io.spring5.learn.hibernate.entities.Singer;

public interface SingerService {
	List<Singer> findAll();

	List<Singer> findAllWithAlbum();

	Singer findById(Long id);

	Singer save(Singer singer);

	void delete(Singer singer);

	List<Singer> findAllByNativeQuery();
	
	void displayAllSingerSummary();
}