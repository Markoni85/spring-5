package io.spring5.learn.aop.methodinterceptor;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author marko
 *
 * @date Jan 18, 2022
 *
 */
@SpringBootApplication
public class MethodInterceptorExampleApplication{

	public static void main(String[] args) {
		SpringApplication.run(MethodInterceptorExampleApplication.class, args);
	}
}
