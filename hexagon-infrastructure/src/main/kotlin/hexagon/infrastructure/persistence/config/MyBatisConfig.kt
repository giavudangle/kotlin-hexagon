package hexagon.infrastructure.persistence.config

import hexagon.infrastructure.persistence.plugin.TimestampPlugin
import javax.sql.DataSource
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.transaction.SpringManagedTransactionFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.io.Resource

@Configuration
@MapperScan(
  basePackages = ["hexagon.infrastructure.persistence.mapper"],
  sqlSessionTemplateRef = "sqlSessionTemplate"
)
open class MyBatisConfig {

  @Bean
  open fun sqlSessionFactory(
    @Qualifier("dataSource") dataSource: DataSource,
    @Value("classpath:mybatis/mybatis-config.xml") configLocation: Resource
  ): SqlSessionFactory {

    val sqlSessionFactoryBean = SqlSessionFactoryBean()

    sqlSessionFactoryBean.setTransactionFactory(SpringManagedTransactionFactory())
    sqlSessionFactoryBean.setDataSource(dataSource)
    sqlSessionFactoryBean.setPlugins(TimestampPlugin())
    sqlSessionFactoryBean.setConfigLocation(configLocation)

    return sqlSessionFactoryBean.`object`!!
  }

  @Primary
  @Bean
  open fun sqlSessionTemplate(
    @Qualifier("sqlSessionFactory") sqlSessionFactory: SqlSessionFactory
  ): SqlSessionTemplate {
    return SqlSessionTemplate(sqlSessionFactory)
  }
}
