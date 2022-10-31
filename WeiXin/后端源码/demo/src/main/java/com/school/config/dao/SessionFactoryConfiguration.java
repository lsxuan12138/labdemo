<<<<<<< HEAD
package com.school.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SessionFactoryConfiguration {
    @Value("${mybatis_config_file}")
    private String mybatisFilePath;
    @Value("${mapper_path}")
    private String mapperPath;
    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactionBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisFilePath));
        PathMatchingResourcePatternResolver resourcePatternResolver=new PathMatchingResourcePatternResolver();
        String packageSearchPath=PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}
=======
package com.school.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SessionFactoryConfiguration {
    @Value("${mybatis_config_file}")
    private String mybatisFilePath;
    @Value("${mapper_path}")
    private String mapperPath;
    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactionBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisFilePath));
        PathMatchingResourcePatternResolver resourcePatternResolver=new PathMatchingResourcePatternResolver();
        String packageSearchPath=PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}
>>>>>>> a23d072 (add WinXin)
