package com.myspringpath.studentexameseurekaclient.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_exam")
public class StudentExam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "student_id")
	private String studentId;
	
	@Column(name="passed")
	private boolean passed;

	@OneToMany
	private Set<Exam> 
	
	public StudentExam() {
		
	}

}
