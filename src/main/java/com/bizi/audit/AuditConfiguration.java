package com.bizi.audit;

import com.bizi.audit.manager.LogFileAuditManager;
import com.bizi.audit.resolver.SkipHttpActionResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@ConditionalOnBean(AuditAutoConfiguration.class)
public class AuditConfiguration {

    @Resource
    private AuditAutoConfiguration auditAutoConfiguration;
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ClientInfoFilter());
        registration.addUrlPatterns(auditAutoConfiguration.getUrlPatterns().split(","));
        return registration;
    }
    @Bean
    public LogFileAuditManager logFileAuditManager(){
        String logger = auditAutoConfiguration.getLogger();
        if(logger == null){
            return new LogFileAuditManager();
        }
        return new LogFileAuditManager(logger);
    }
    @Bean
    public SkipHttpActionResolver ignoreRequestResolver(){
        return new SkipHttpActionResolver();
    }

}
