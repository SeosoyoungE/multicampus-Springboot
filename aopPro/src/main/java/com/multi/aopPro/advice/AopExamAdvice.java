package com.multi.aopPro.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopExamAdvice {
	@Pointcut("execution(* com.multi.aopPro..*.*(..))")
	public void alllog_point() {

	}
	@Pointcut("execution(* com.multi.aopPro..*DAO.add*(..))")
	public void daolog_point() {

	}
	@Before("alllog_point()")
	public void alllog() {
		System.out.println("********************");
	}
	@After("daolog_point()")
	public void daolog() {
		System.out.println("^^");
	}
}
