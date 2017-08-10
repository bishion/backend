package com.bizi.backend.audit;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@ConditionalOnProperty(value = "bizi.config.audit.enabled")
public class AuditAspect {

    @Around(value = "@annotation(audit)", argNames = "joinPoint,audit")
    public Object handleAudit(final ProceedingJoinPoint joinPoint, final Audit audit) throws Throwable {
        // 获取参数
        joinPoint.getArgs();
        // 获取请求action
        String actionName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object result = joinPoint.proceed();

        log.info(actionName+methodName);
        return "SUCCESS";
    }
}
