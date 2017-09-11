package com.bizi.audit.resolver;

import com.bizi.audit.Audit;
import org.aspectj.lang.JoinPoint;

public interface ActionResolver {
    String resolveFrom(JoinPoint auditTarget, Object returnVal, Audit audit);
    String resolveFrom(JoinPoint auditTarget, Exception exception, Audit audit);
}
