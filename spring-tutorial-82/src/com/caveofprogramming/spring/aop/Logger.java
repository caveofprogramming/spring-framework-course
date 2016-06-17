package com.caveofprogramming.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@Pointcut("within(com.caveofprogramming.spring.aop.*)")
	public void cameraSnap() {
	}
	
	@Before("cameraSnap()")
	public void beforeAdvice() {
		System.out.println("********** Before advice ************");
	}
	
}
