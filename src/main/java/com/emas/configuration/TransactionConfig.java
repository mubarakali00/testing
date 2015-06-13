package com.emas.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {


	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {

		JtaTransactionManager manager = new JtaTransactionManager();
		manager.setUserTransactionName( "java:jboss/UserTransaction" );
		manager.setTransactionManagerName( "java:jboss/TransactionManager" );
		return manager;
	}
	
}
