package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.example.DemoRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by valdisnei on 03/01/17.
 */
@Aspect
@EnableAspectJAutoProxy
@Component
public class LambdaAspect {

    @Before("execution(public * com.example.HelloWorldService.executaSomeThing(..))")
    private void insertProcess(JoinPoint joinPoint) {
        Context context= (Context) joinPoint.getArgs()[1];

        context.getLogger().log("joinPoint = " + joinPoint);
        context.getLogger().log("==========================");

        DemoRequest demo= (DemoRequest) joinPoint.getArgs()[0];
        demo.setSourceIp("0000000000000000");

        context.getLogger().log(demo.toString());
    }

}
