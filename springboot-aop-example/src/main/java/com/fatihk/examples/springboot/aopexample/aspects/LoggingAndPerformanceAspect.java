package com.fatihk.examples.springboot.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAndPerformanceAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAndPerformanceAspect.class);

    //Match controller methods
    @Before("execution(* com.fatihk.examples..controller..*(..))")
    public void logMethodBeginning(JoinPoint joinPoint){
        logger.info(joinPoint.getSignature().getDeclaringTypeName() + "." +joinPoint.getSignature().getName()  + " begins");
    }

    @After("execution(* com.fatihk.examples..controller..*(..))")
    public void logMethodEnd(JoinPoint joinPoint){
        logger.info(joinPoint.getSignature().getDeclaringTypeName() + "." +joinPoint.getSignature().getName() + " ends");
    }

    //match service methods
    @Around("execution(* com.fatihk.examples..service.*.*(..))")
    public Object logPerformance(ProceedingJoinPoint joinPoint)throws Throwable {
        long begin = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        }
        finally {
            long end = System.currentTimeMillis();
            logger.info(joinPoint.getSignature() + " duration: " + (end-begin) + " ms");
        }
    }


}
