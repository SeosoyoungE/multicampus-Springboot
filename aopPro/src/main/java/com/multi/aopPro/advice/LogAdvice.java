package com.multi.aopPro.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//모든클래스에 적용할 공통모듈
@Component
@Aspect //스프링에서 사용하는 aop가 정의되어 있는 클래스라는 의미
public class LogAdvice {
	//포인트컷을 적용하는 방법은 별도로 메소드위에 정의하는 방식
	@Pointcut("execution(* com.multi.aopPro.exam.UserDAO.get*(..))")
	public void logPointCut() {
		
	}
	
	//로그기록하는 코드
	@After("logPointCut()")
	public void log() {
		System.out.println("==========로그기록==========");
	}
	
	
}
