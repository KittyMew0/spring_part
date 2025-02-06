package com.example.sem61ex.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("@annotation(com.example.sem61ex.aspect.TrackUserAction)")
    public void trackUserActionMethods() {
    }

    @AfterReturning(pointcut = "trackUserActionMethods()", returning = "result")
    public void logMethodCall(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        String user = "User";

        log.info("Пользователь: {}, вызвал метод: {} с параметрами: {}. Результат: {}",
                user, methodName, Arrays.toString(args), result);
    }
}
