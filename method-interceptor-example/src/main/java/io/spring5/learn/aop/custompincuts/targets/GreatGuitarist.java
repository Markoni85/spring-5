package io.spring5.learn.aop.custompincuts.targets;

public class GreatGuitarist implements Singer {
	@Override
	public String sing() {
		return "Singing song";
	}
}