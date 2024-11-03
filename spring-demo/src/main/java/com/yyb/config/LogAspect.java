package com.yyb.config;

/**
 * @author: yyb
 * @date: 2023/12/24 22:49
 * @description:
 */
@Aspect
@Component
public class LogAspect {

	@Pointcut("@annotation(com.example.demo.annotation.LogAnnotation)")
	public void logPointcut() {}

	@Before("logPointcut()")
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("before " + methodName);
	}

	@After("logPointcut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("after " + methodName);
	}
}