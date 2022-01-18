package io.spring5.learn.aop.methodinterceptor;

public class TargetApp {

	public void printMessage() {
		System.out.println("This is the target method to advice");
	}
}
