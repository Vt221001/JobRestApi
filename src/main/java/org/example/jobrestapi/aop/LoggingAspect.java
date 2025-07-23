package org.example.jobrestapi.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* org.example.jobrestapi.service.JobService.getJob*(..)) || execution(* org.example.jobrestapi.service.JobService.getAllJobs*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called " +jp.getSignature().getName());
    }

    @After("execution(* org.example.jobrestapi.service.JobService.getJob*(..)) || execution(* org.example.jobrestapi.service.JobService.getAllJobs*(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed "+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* org.example.jobrestapi.service.JobService.getJob*(..)) || execution(* org.example.jobrestapi.service.JobService.getAllJobs*(..))")
    public void logMethodCrashed(JoinPoint jp) {
        LOGGER.info("Method has some issues "+jp.getSignature().getName());
    }


    @AfterReturning("execution(* org.example.jobrestapi.service.JobService.getJob*(..)) || execution(* org.example.jobrestapi.service.JobService.getAllJobs*(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully "+jp.getSignature().getName());
    }


}
