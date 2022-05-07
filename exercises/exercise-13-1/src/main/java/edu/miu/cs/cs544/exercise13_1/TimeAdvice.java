package edu.miu.cs.cs544.exercise13_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TimeAdvice {
    @Around("execution(public void edu.miu.cs.cs544.exercise13_1.CustomerDAO.save(..))")
    public void invoke(ProceedingJoinPoint call) throws Throwable{
        System.out.println(call.getSignature().getName());
        StopWatch clock = new StopWatch();
        clock.start(call.getSignature().getName());
        Object object = call.proceed();
        clock.stop();
        long totaltime = clock.getLastTaskTimeMillis();
        System.out.println("Time to execute save = " + totaltime + " ms");
    }
}
