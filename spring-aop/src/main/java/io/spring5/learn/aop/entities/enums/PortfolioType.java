package io.spring5.learn.aop.entities.enums;

public enum PortfolioType {

	LEASE("Lease"), 
	LOAN("Loan");
	
	private String name;
	
	PortfolioType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
