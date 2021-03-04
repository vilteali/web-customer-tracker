package com.ali.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLogginAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.ali.controller.*.*(..))")
	private void controllerPackage() { }

	@Pointcut("execution(* com.ali.service.*.*(..))")
	private void servicePackage() { }
	
	@Pointcut("execution(* com.ali.dao.*.*(..))")
	private void daoPackage() { }
	
	@Pointcut("controllerPackage() || servicePackage() || daoPackage()")
	private void appFlow() { }
	
	@Before("appFlow()")
	public void before(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("======> in @Before: calling method: "+method);
		
	}
	
}
