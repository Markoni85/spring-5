package io.spring5.learn.aop.entities;

import java.util.Date;

public class ContractDTO {
	private Long contractId;
	private String contractNumber;
	private Date contractDate;
	private Date interestStartDate;
	private int interestRate;
	private double payment;
	
//	private Long portfolioId;
//	
//	private Portfolio portfolio;

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Date getInterestStartDate() {
		return interestStartDate;
	}

	public void setInterestStartDate(Date interestStartDate) {
		this.interestStartDate = interestStartDate;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

//	public Long getPortfolioId() {
//		return portfolioId;
//	}
//
//	public void setPortfolioId(Long portfolioId) {
//		this.portfolioId = portfolioId;
//	}
//
//	public Portfolio getPortfolio() {
//		return portfolio;
//	}
//
//	public void setPortfolio(Portfolio portfolio) {
//		this.portfolio = portfolio;
//	}
}
