package com.ali.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLogginAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());
	
}
