package io.spring5.learn.aop.custompincuts;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import io.spring5.learn.aop.custompincuts.targets.GreatGuitarist;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "sing".equals(method.getName());
	}

	@Override
	public ClassFilter getClassFilter() {
		return cf -> cf == GreatGuitarist.class;
	}
}
