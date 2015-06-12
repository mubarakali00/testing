package com.emas.jpa.util;

import javax.transaction.UserTransaction;

import org.hibernate.engine.transaction.internal.jta.JtaTransactionFactory;

public class LocalJtaTransactionFactory extends JtaTransactionFactory {

	
	private static final long serialVersionUID = 1L;
	
	private static volatile UserTransaction userTransaction;
	  
	  public synchronized void setUserTransaction(UserTransaction userTransaction) {
	    LocalJtaTransactionFactory.userTransaction = userTransaction;
	  }
	 
	  protected UserTransaction getUserTransaction() {
	    return userTransaction;
	  }

}
