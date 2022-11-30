package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {

    @Pointcut("within(com.demo.service.*)")
    public void withinCurrencyServicePointcut(){}

    @Pointcut("@within(com.demo.annotation.Secured)")
    public void withinAnnotationCurrencyServicePointcut(){}

    @Pointcut("@target(com.demo.annotation.Secured)")
    public void targetAnnotationCurrencyServicePointcut(){}

    @Pointcut("@annotation(com.demo.annotation.InTransaction)")
    public void annotationCurrencyServicePointcut(){}

    @Pointcut("bean(currency)")
    public void beanCurrencyServicePointcut(){}

    @Pointcut("args(int,int)")
    public void argsCurrencyServicePointcut(){}

    @Pointcut("@args(com.demo.annotation.Validated)")
    public void argsAnnotationCurrencyServicePointcut(){}

   // @Before("withinCurrencyServicePointcut()")
    public void beforeCurrencyServiceAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();

        //System.out.println(className);
        System.out.println(
                String.format("%s's %s method is invoked with %s parameter before advice in %s.",
                        className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );
    }

    //@Before("withinAnnotationCurrencyServicePointcut()")
    public void beforeWithinAnnotationCurrencyServiceAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();

        //System.out.println(className);
        System.out.println(
                String.format("%s's %s method is invoked with %s parameter before advice in %s.",
                        className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );
    }

    //@Before("annotationCurrencyServicePointcut()")
    public void beforeAnnotationCurrencyServiceAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();

        //System.out.println(className);
        System.out.println(
                String.format("%s's %s method is invoked with %s parameter before advice in %s.",
                        className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );
    }

    //@Before("beanCurrencyServicePointcut()")
    public void beforeBeanCurrencyServiceAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();

        //System.out.println(className);
        System.out.println(
                String.format("%s's %s method is invoked with %s parameter before advice in %s.",
                        className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );
    }

    //@Before("withinCurrencyServicePointcut() && argsCurrencyServicePointcut()")
    public void argsCurrencyServiceAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();

        //System.out.println(className);
        System.out.println(
                String.format("%s's %s method is invoked with %s parameter before advice in %s.",
                        className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );
    }

    @Around("targetAnnotationCurrencyServicePointcut()")
    public Object targetAnnotationCurrencyAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        String className = joinPoint.getTarget().getClass().getSimpleName();

        //System.out.println(className);
        System.out.println(
                String.format("%s's %s method is invoked with %s parameter before advice in %s.",
                        className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
        try{
            return joinPoint.proceed();
        }finally {
            System.out.println("After invoking method . . . . . .");
        }
    }

    //@AfterReturning(value = "argsAnnotationCurrencyServicePointcut()", returning = "country")
    public void argsAnnotationCurrencyServiceAdvice(JoinPoint joinPoint, String country){
        String className = joinPoint.getTarget().getClass().getSimpleName();

        //System.out.println(className);
        System.out.println(
                String.format("%s's %s method is invoked with %s parameter after" +
                                " advice is :: %s in %s..",
                        className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),country, LocalDateTime.now())
        );
    }

    //@AfterThrowing(value = "argsAnnotationCurrencyServicePointcut()", throwing = "e")
    public void argsAnnotationCurrencyServiceAdvice(JoinPoint joinPoint, Throwable e){
        String className = joinPoint.getTarget().getClass().getSimpleName();

        //System.out.println(className);
        System.out.println(
                String.format("%s's %s method is invoked with %s parameter after throwing" +
                                " advice exception class is :: %s in %s.",
                        className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),e.getClass().getSimpleName(), LocalDateTime.now())
        );
    }

}
