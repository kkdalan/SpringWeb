package com.ezpay.web.aop.log;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class LogInterceptor implements MethodInterceptor {

     private Logger logger = Logger.getLogger(this.getClass().getName());

     public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//          PropertyConfigurator.configure("config/log4j.properties");
          
          logger.info("[AOP] method starts ====> " + methodInvocation.getMethod());
          Object result = methodInvocation.proceed();
          logger.info("[AOP] method ends   ====> " + methodInvocation.getMethod());

          return result;
     }

}
