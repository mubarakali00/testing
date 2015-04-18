//package com.emas.configuration;
//
//import java.util.Properties;
//
//import javax.annotation.Resource;
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan( { "com.emas.jpa.*" } )
//@PropertySource( { "classpath:database.properties" } )
//public class PersistenceJPAConfig 
//{
//	@Resource
//	private Environment env;
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
//	{
//		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//		em.setDataSource( dataSource() );
//		em.setPackagesToScan( new String[] { "com.emas.jpa.entity", "com.emas.jpa.repository" } );
//
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		em.setJpaVendorAdapter( vendorAdapter );
//		em.setJpaProperties( additionalProperties() );
//
//		return em;
//	}
//
//	@Bean
//	public DataSource dataSource() { 
//		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName( env.getProperty( "db.driver" ) );
//        dataSource.setUrl( env.getProperty( "db.url" ) );
//        dataSource.setUsername( env.getProperty( "db.username" ) );
//        dataSource.setPassword( env.getProperty( "db.password" ) );
//        return dataSource;
//
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
//		final JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(emf);
//		return transactionManager;
//	}
//
//	final Properties additionalProperties() {
//		
//		final Properties hibernateProperties = new Properties();
//		
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty( "hibernate.hbm2ddl.auto" ) );
//        hibernateProperties.setProperty( "hibernate.show_sql", env.getProperty( "hibernate.show_sql" ) );
//        hibernateProperties.setProperty( "hibernate.dialect", env.getProperty( "hibernate.dialect" ) );
//		return hibernateProperties;
//	}
//
//
//}
