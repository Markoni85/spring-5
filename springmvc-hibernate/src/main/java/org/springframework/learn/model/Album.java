package org.springframework.learn.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="album")
public class Album implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	private Long singerId;
    
	@Column(name = "title")
	private String title;
	
	@Column(name = "release_date")
	private Date releaseDate;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setSingerId(Long singerId) {
		this.singerId = singerId;
	}

	public Long getSingerId() {
		return this.singerId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	@Override
	public String toString() {
		return "Album - Id: " + id + ", Singer id: " + singerId + ", Title: " + title + ", Release Date: "
				+ releaseDate;
	}
}