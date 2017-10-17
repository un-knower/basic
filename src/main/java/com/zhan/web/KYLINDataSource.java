package com.zhan.web;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Author : Zhan
 * E-mail : kenger@163.com
 * Date   : 2017/10/16
 */
@Configuration
@MapperScan(basePackages = "com.zhan.web.kylinmapper", sqlSessionTemplateRef  = "kylinSqlSessionTemplate")
public class KYLINDataSource {

    @Bean(name = "kylinDataSource")
    @ConfigurationProperties(prefix = "kylin") // application.properteis中对应属性的前缀
    public DataSource kylinDataSource() {
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
    }

    @Bean(name = "kylinSqlSessionFactory")
    public SqlSessionFactory kylinSqlSessionFactory(@Qualifier("kylinDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

//    @Bean(name = "kylinTransactionManager")
//    public DataSourceTransactionManager rdbmsTransactionManager(@Qualifier("kylinDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }


    @Bean(name = "kylinSqlSessionTemplate")
    public SqlSessionTemplate kylinSqlSessionTemplate(@Qualifier("kylinSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
