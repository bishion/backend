package com.bizi.backend;

import com.bizi.audit.EnableAudit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by guofangbi on 2017/7/23.
 */
@SpringBootApplication
@EnableAudit
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class,args);
    }
}
