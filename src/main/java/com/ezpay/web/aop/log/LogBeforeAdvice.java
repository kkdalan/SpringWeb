package com.ezpay.web.aop.log;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice {

     public void before(Method method, Object[] args, Object target) throws Throwable {
          System.out.println("[Spring AOP] "+ new Date() + " method starts... " + method);
     }

}
