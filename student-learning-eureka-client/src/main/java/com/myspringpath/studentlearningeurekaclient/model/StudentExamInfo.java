package com.myspringpath.studentlearningeurekaclient.model;

import java.io.Serializable;

public class StudentExamInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private int studentId;
	private String examName;
	private boolean passed;
	
	public StudentExamInfo() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	
	
}
