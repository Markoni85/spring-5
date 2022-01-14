package io.javabrains.springsecurityfacebooklogin.model;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private long id;
	private String name;
	public Student(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
