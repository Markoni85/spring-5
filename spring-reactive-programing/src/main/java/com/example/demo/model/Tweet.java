package com.example.demo.model;

import java.io.Serializable;

public class Tweet implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String message;
	
	public Tweet() {
		
	}
	
	public Tweet(String userName, String message) {
		super();
		this.userName = userName;
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return message + " by user " + userName;
	}
}
