package io.spring5.learn.aop;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

import io.spring5.learn.aop.methodinterceptor.MessageInterceptor;
import io.spring5.learn.aop.methodinterceptor.TargetApp;

public class MethodInterceptorTests {

	@Test
	public void runTest() {
		TargetApp targetApp = new TargetApp();
		
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new MessageInterceptor());
		factory.setTarget(targetApp);
	
		TargetApp proxyObj = (TargetApp)factory.getProxy();
		
		assertNotNull(proxyObj);
		
		proxyObj.printMessage();
	}
}
