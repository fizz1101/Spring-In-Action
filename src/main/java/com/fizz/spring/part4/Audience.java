package com.fizz.spring.part4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
public class Audience {

    // && within(com.fizz.spring.part4)
    @Pointcut("execution(* com.fizz.spring.part4.Performance.*(..))")
    public void performance() {}

    @Before("performance()")
    public void silenceCellPhone() {
        System.out.println("Silencing Cell Phone");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demand a refund");
    }

    /**
     * 环绕通知方法
     * @param pj
     */
    /*@Around("performance()")
    public void watchPerformance(ProceedingJoinPoint pj) {
        try {
            System.out.println("Silencing Cell Phone");
            System.out.println("Taking seats");
            pj.proceed();
            System.out.println("CLAP CLAP CLAP!");
        } catch (Throwable e) {
            System.out.println("Demand a refund");
        }
    }*/

}
