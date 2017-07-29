package com.bizi.backend;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by guofangbi on 2017/7/29.
 */
@Configuration
@MapperScan("com.bizi.backend.*.dao")
public class BackendConfiguration {
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;

    @Bean
    public DataSource dataSource(){DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setMinIdle(2);
        druidDataSource.setMinEvictableIdleTimeMillis(60000);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setValidationQuery("select 1 from dual");
        return druidDataSource;
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        VFS.addImplClass(SpringBootVFS.class);
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(dataSource);//指定数据源(这个必须有，否则报错)
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage("com.bizi.backend.permit");//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));//指定xml文件位置

        return fb.getObject();
    }

}
