
package com.project;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.project")
@EnableTransactionManagement
public class AppConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/studentdb");
    ds.setUsername("root");
    ds.setPassword("password");
    return ds;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    factory.setDataSource(dataSource());
    factory.setPackagesToScan("com.project");
    Properties props = new Properties();
    props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
    props.put("hibernate.show_sql", "true");
    props.put("hibernate.hbm2ddl.auto", "update");
    factory.setHibernateProperties(props);
    return factory;
  }

  @Bean
  public HibernateTransactionManager txManager(SessionFactory sf) {
    return new HibernateTransactionManager(sf);
  }
}
