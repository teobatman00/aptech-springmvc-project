package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.LogManager;

@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* org.example.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* org.example.repository.*.*(..))")
    private void forRepositoryPackage() {
    }

    @Pointcut("execution(* org.example.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("forControllerPackage() || forRepositoryPackage() || forServicePackage()")
    private void forLoggingAspect() {

    }
    @Before("forLoggingAspect()")
    public void beforeLogging(JoinPoint joinPoint) {
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("==> before advice: calling method " + theMethod);
        Object[] args = joinPoint.getArgs();
        for (Object temArgs : args) {
            logger.info("===> argument: " + temArgs);
        }
    }

    @AfterReturning(pointcut = "forLoggingAspect()", returning = "result")
    public void afterRunning(JoinPoint joinPoint, Object result) {
        logger.info("===> Result: " + result);
    }
}
