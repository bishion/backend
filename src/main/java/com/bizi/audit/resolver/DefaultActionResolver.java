package com.bizi.audit.resolver;

import com.bizi.audit.Audit;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

@Service
public class DefaultActionResolver implements ActionResolver{
    @Override
    public String resolveFrom(JoinPoint auditTarget, Object returnVal, Audit audit) {
        return null;
    }

    @Override
    public String resolveFrom(JoinPoint auditTarget, Exception exception, Audit audit) {
        return null;
    }
}
