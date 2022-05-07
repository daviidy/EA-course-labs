package com.example.exercise15_2.advice;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import java.util.Date;

public class LogTracing {

    public void logAllMethods(JoinPoint joinPoint) {
        System.out.println(new Date() + " method=" + joinPoint.getSignature().getName());
    }

    @SneakyThrows
    public Object durationAllService(ProceedingJoinPoint joinPoint) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        return object;

    }

    public void logJmsMessage(JoinPoint joinPoint) {
        Object[] object = joinPoint.getArgs();
        System.out.println(new Date() + " Jms message=" + (String) object[0]);
    }
}
