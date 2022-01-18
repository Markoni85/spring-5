package io.spring5.learn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import io.spring5.learn.aop.exceptions.TaskException;

@Aspect
@Component
public class ErrorHandling {

	private static Logger logger = LoggerFactory.getLogger(ErrorHandling.class);

	@Around(value = "execution(* io.spring5.learn.aop.service.*.*(..))")
	public Object contractHandler(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			Object result = joinPoint.proceed();
			return result;
		} catch (TaskException e) {
			logger.info(" TaskException StatusCode {}", e.getHttpStatus().value());
			logger.info("TaskException Message {}", e.getMessage());
			
			throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
		}
	}
}
