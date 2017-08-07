package com.ezpay.web.aop.log;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterAdvice implements AfterReturningAdvice {

     public void afterReturning(Object object, Method method, Object[] args, Object target) throws Throwable {
          System.out.println("[Spring AOP] "+ new Date() + " method ends... " + method);
     }

}
