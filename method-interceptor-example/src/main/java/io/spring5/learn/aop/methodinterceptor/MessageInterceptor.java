package io.spring5.learn.aop.methodinterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println(" before calling target method: " + invocation.getMethod().getName());

		Object obj = invocation.proceed();
		
		System.out.println(" after calling target method");
		
		return obj;
	}
}
