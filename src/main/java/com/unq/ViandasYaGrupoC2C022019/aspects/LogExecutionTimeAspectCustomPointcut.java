package com.unq.ViandasYaGrupoC2C022019.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class LogExecutionTimeAspectCustomPointcut {
	
	static Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspectCustomPointcut.class);
	
	@Pointcut("execution(* com.unq.ViandasYaGrupoC2C022019.webservice.*(..))")
	public void methodsStarterServicePointcut() {
		
	}
	
	public void beforeMethods() throws Throwable {
		logger.info("/////// BEFORE /////");
	}
	
	public void afterMethods() throws Throwable {
		logger.info("/////// AFTER /////");
	}

}
