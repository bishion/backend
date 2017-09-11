package com.bizi.audit;

import com.bizi.audit.manager.AuditManager;
import com.bizi.audit.resolver.ActionResolver;
import com.bizi.audit.resolver.LoginInfoResolver;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Aspect
@Slf4j
@Component
@ConditionalOnBean(AuditAutoConfiguration.class)
public class AuditAspect {
    @Autowired
    private List<AuditManager> auditManagerList;

    @Autowired
    private Map<String,ActionResolver> actionResolverMap;
    @Resource
    private AuditAutoConfiguration auditAudiConfiguration;

    @Resource
    private LoginInfoResolver loginInfoResolver;

    public AuditAspect() {
    }

    @Around(value = "@annotation(audit)", argNames = "joinPoint,audit")
    public Object handleAudit(final ProceedingJoinPoint joinPoint, final Audit audit) throws Throwable {
        // 获取参数
        joinPoint.getArgs();
        // 获取请求action
        String actionName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String loginName = loginInfoResolver.getLoginName();
        try {

            Object result = joinPoint.proceed();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            String system = auditAudiConfiguration.getSystem();

            log.info(actionName+methodName);
        }

    }
}
