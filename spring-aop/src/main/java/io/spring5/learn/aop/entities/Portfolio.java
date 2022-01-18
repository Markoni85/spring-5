package io.spring5.learn.aop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.spring5.learn.aop.entities.enums.PortfolioType;

@Entity
@Table(name = "Portfolio")
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "portfolio_name")
	private String portfolioName;

	@Enumerated(EnumType.STRING)
	private PortfolioType portfolioType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public PortfolioType getPortfolioType() {
		return portfolioType;
	}

	public void setPortfolioType(PortfolioType portfolioType) {
		this.portfolioType = portfolioType;
	}

	
	
}
