package com.example.javaee.rest.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {
	
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		
		long initialTime = System.currentTimeMillis();
		Object o =  context.proceed();
		long finalTime = System.currentTimeMillis();
		
		String className = context.getTarget().getClass().getSimpleName();
		String methodName = context.getMethod().getName();
		
		System.out.println("-------");
		System.out.println("Class: " + className);
		System.out.println("Method: " + methodName);
		System.out.println("Elapsed Time(ms): " + (finalTime - initialTime));
		System.out.println("-------");
		
		return o;
		
	}

	
	
}
