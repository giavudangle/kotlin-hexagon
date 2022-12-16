package com.vudang.kotlin.hexagon.core.persistence.config

import javax.sql.DataSource
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.transaction.SpringManagedTransactionFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource

@Configuration
class MyBatisConfig {

  @Bean
  fun sqlSessionFactory(
    @Qualifier("dataSource") dataSource: DataSource,
    @Value("classpath:mybatis/mybatis-config.xml") resourceClassPath: Resource
  ): SqlSessionFactory {

    val sqlSessionFactoryBean = SqlSessionFactoryBean()

    sqlSessionFactoryBean.setTransactionFactory(SpringManagedTransactionFactory())
    sqlSessionFactoryBean.setDataSource(dataSource)
    sqlSessionFactoryBean.setPlugins()

    return sqlSessionFactoryBean.`object`!!
  }
}
