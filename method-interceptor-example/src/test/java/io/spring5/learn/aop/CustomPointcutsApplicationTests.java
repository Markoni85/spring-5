package io.spring5.learn.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.aopalliance.aop.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;

import io.spring5.learn.aop.custompincuts.SimpleAdvice;
import io.spring5.learn.aop.custompincuts.SimpleStaticPointcut;
import io.spring5.learn.aop.custompincuts.targets.GoodGuitarist;
import io.spring5.learn.aop.custompincuts.targets.GreatGuitarist;
import io.spring5.learn.aop.custompincuts.targets.Singer;

class CustomPointcutsApplicationTests {

	@Test
	void PointcutTest() {
		GoodGuitarist johnMayer = new GoodGuitarist();
		GreatGuitarist ericClapton = new GreatGuitarist();

		Singer proxyOne;
		Singer proxyTwo;

		Pointcut pc = new SimpleStaticPointcut();
		Advice advice = new SimpleAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(johnMayer);
		proxyOne = (Singer) pf.getProxy();
		
		pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(ericClapton);
		proxyTwo = (Singer) pf.getProxy();
		
		assertNotNull(proxyOne);
		assertNotNull(proxyTwo);
		
		String sing1 = proxyOne.sing();
		assertNotEquals(sing1, "Singing song lala");
		
		String sing2 = proxyTwo.sing();
		assertEquals(sing2, "Singing song lala");
	}
}
