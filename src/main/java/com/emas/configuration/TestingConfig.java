package com.emas.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource({ "classpath:database.properties" })
@EnableJpaRepositories( basePackages = "com.testing.jpa.repository", entityManagerFactoryRef = "testEntityManager", transactionManagerRef = "transactionManager" )
public class TestingConfig {
	
    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean testEntityManager() {
    	
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource( testDataSource() );
        em.setPersistenceProviderClass( HibernatePersistenceProvider.class );
        em.setPersistenceUnitName( "testingPU" );
        em.setPackagesToScan(new String[] { "com.testing.jpa.entity" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter( vendorAdapter );
		em.setJpaProperties( additionalProperties() );

        return em;
    }

    @Bean
    public DataSource testDataSource() {
    	
    	/*DataSource ds = null;
		try {
			
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:jboss/TestingDSXA");
			System.out.println( "Connected database name ===>" + ds.getConnection().getCatalog() );
			
		} catch (NamingException | SQLException e) {

			e.printStackTrace();
		}
		
    	return ds;*/
    	final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName( env.getProperty( "db.driver" ) );
		dataSource.setUrl( env.getProperty( "db.url.test" ) );
		dataSource.setUsername( env.getProperty( "db.username" ) );
		dataSource.setPassword( env.getProperty( "db.password" ) );

		return dataSource;
    }
    
    final Properties additionalProperties() {
		
		final Properties hibernateProperties = new Properties();
		
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty( "hibernate.hbm2ddl.auto" ) );
        hibernateProperties.setProperty( "hibernate.show_sql", env.getProperty( "hibernate.show_sql" ) );
        hibernateProperties.setProperty( "hibernate.dialect", env.getProperty( "hibernate.dialect" ) );
        hibernateProperties.setProperty( "hibernate.format_sql", env.getProperty( "hibernate.format_sql" ) );
        hibernateProperties.setProperty( "hibernate.transaction.jta.platform" , "org.hibernate.service.jta.platform.internal.JBossAppServerJtaPlatform" );
        hibernateProperties.setProperty( "hibernate.transaction.factory_class", "org.hibernate.transaction.CMTTransactionFactory" );
		
        return hibernateProperties;
	}

}