package edu.miu.cs.cs544.exercise13_1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
public class LogAdvice {
    @After("execution(public void edu.miu.cs.cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email, message)")
    public void traceAfterSendMail(JoinPoint joinpoint, String email, String message){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date)
                + " method= "+joinpoint.getSignature().getName()
                + " address= "+email
                + " message= "+message
        );
        IEmailSender e = (IEmailSender) joinpoint.getTarget();
        System.out.println("outgoing mail server= " + e.getOutgoingMailServer());
    }
}
