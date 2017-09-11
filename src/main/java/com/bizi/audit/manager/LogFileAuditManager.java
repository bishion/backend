package com.bizi.audit.manager;

import com.bizi.audit.AuditInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFileAuditManager implements AuditManager{
    private Logger logger;
    public LogFileAuditManager(String loggerName){
        this.logger = LoggerFactory.getLogger(loggerName);
    }
    public LogFileAuditManager(){
        this.logger = LoggerFactory.getLogger(LogFileAuditManager.class);
    }

    @Override
    public void dealAuditInfo(AuditInfo auditInfo) {
        logger.info(auditInfo.toString());
    }
}
