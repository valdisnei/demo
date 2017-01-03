package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by valdisnei on 03/01/17.
 */
@Aspect
@EnableAspectJAutoProxy
@Component
public class LambdaAspect {

    @After("execution(public * com.example.Hello.handleRequest(..))  ")
    private void insertProcess(JoinPoint joinPoint) {
        System.out.println("joinPoint = " + joinPoint.get);
    }

}
