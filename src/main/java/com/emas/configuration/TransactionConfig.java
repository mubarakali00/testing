package com.emas.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {


	/*@Bean(name = "btmConfig")
	public bitronix.tm.Configuration btmConfig() {

		System.out.println("btmConfig()");
		bitronix.tm.Configuration configuration = TransactionManagerServices.getConfiguration();
		configuration.setServerId("spring-btm");
		configuration.setLogPart1Filename("/home/mubarak/btm/btm-log1");
		configuration.setLogPart2Filename("/home/mubarak/btm/btm-log2");
		return configuration;
	}

	@Bean(destroyMethod = "shutdown")
	@DependsOn(value = "btmConfig")
	public BitronixTransactionManager bitronixTransactionManager() {

		System.out.println("bitronixTransactionManager()");
		return TransactionManagerServices.getTransactionManager();
	}

	@Bean(name = "transactionManager")
	public JtaTransactionManager transactionManager() {

		System.out.println("jtaTransactionManager()");
		JtaTransactionManager retVal = new JtaTransactionManager();
		retVal.setTransactionManager(bitronixTransactionManager());
		retVal.setUserTransaction(bitronixTransactionManager());
		return retVal;
	}*/

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {

		JtaTransactionManager manager = new JtaTransactionManager();
		manager.setUserTransactionName( "java:jboss/UserTransaction" );
		manager.setTransactionManagerName( "java:jboss/TransactionManager" );
		return manager;
		
		/*final JtaTransactionManager transactionManager = new JtaTransactionManager();
//		transactionManager.setTransactionManagerName( "txManager" );
//		transactionManager.setUserTransactionName( "java:jboss/UserTransaction" );
		return transactionManager;*/
	}

	//	@Bean
	//	public JtaTransactionManager transactionManager() {
	//		
	//		JtaTransactionManager manager = new JtaTransactionManager();
	//		manager.setUserTransaction( "java:jboss/UserTransaction" );
	//		manager.setTransactionManager( "java:jboss/TransactionManager" );
	//		return manager;
	//	}

	//	@DependsOn( {"", ""} )
	/*@Bean
	public BitronixTransactionManager bitronixTM() {

		return TransactionManagerServices.getTransactionManager();
	}

	@Bean
	public JtaTransactionManager transactionManager() {

		JtaTransactionManager manager = new JtaTransactionManager();
		manager.setUserTransaction( bitronixTM() );
		manager.setTransactionManager( bitronixTM() );
		return manager;
	}*/

	/*
	@Bean
	public TransactionManagerServices bitronixTransactionManager() {

		TransactionManagerServices service = new TransactionManagerServices();
		return service.getTransactionManager();
	}*/

	/*@Bean
	public LocalJtaTransactionFactory txnFactory() {

		LocalJtaTransactionFactory factory = new LocalJtaTransactionFactory();
		factory.setUserTransaction( bitronixTM() );
		return factory;
	}*/

	//	@Bean
	//	public TransactionProxyFactoryBean myService() {
	//		
	//		TransactionProxyFactoryBean transactionFactory = new TransactionProxyFactoryBean();
	//		transactionFactory.setTransactionManager(transactionManager());
	////		transactionFactory.setTarget( main() );
	//		transactionFactory.setTransactionAttributes( transactionAttributes() );
	//		return transactionFactory;
	//	}

	//	private Properties transactionAttributes() {
	//		
	//		Properties prop = new Properties();
	//		prop.setProperty( "*", "PROPAGATION_MANDATORY" );
	//		return prop;
	//	}

	//	@Bean
	//	public MainBll main() {
	//		
	//		return new MainBll();
	//	}
}
