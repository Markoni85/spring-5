package org.springframework.learn.dao;

import java.util.List;

import org.springframework.learn.model.Singer;

public interface SingerDao {
	List<Singer> findAll();
}