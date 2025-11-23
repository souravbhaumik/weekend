package com.sourav.restdemo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-name.method-name(arguements)

    @Before("execution(* com.sourav.restdemo.service.JobService.*(..))")
    public void logMethodCall() {
        LOGGER.info("Method called");
    }

    @Before(
        "execution(* com.sourav.restdemo.service.JobService.getJob(..)) ||"
        + "execution(* com.sourav.restdemo.service.JobService.update(..))"
    )
    public void logBeforeGetMethodCall(JoinPoint jp) {
        LOGGER.info("Get method called " + jp.getSignature().getName());
    }

    @After(
        "execution(* com.sourav.restdemo.service.JobService.getJob(..)) ||"
        + "execution(* com.sourav.restdemo.service.JobService.update(..))"
    )
    public void logAfterGetMethodCall(JoinPoint jp) {
        LOGGER.info("Get method executed " + jp.getSignature().getName());
    }

    @AfterThrowing(
        "execution(* com.sourav.restdemo.service.JobService.getJob(..)) ||"
        + "execution(* com.sourav.restdemo.service.JobService.update(..))"
    )
    public void logAfterExceptionGetMethodCall(JoinPoint jp) {
        LOGGER.info("Some issue in get method " + jp.getSignature().getName());
    }

    @AfterReturning(
        "execution(* com.sourav.restdemo.service.JobService.getJob(..)) ||"
        + "execution(* com.sourav.restdemo.service.JobService.update(..))"
    )
    public void logAfterReturningGetMethodCall(JoinPoint jp) {
        LOGGER.info("Method executed successfully " + jp.getSignature().getName());
    }

}
