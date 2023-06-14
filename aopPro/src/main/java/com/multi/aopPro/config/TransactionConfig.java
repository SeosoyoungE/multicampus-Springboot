package com.multi.aopPro.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionConfig {
	javax.sql.DataSource ds;
	
	@Autowired
	public TransactionConfig(javax.sql.DataSource ds) {
		super();
		this.ds = ds;
	}
	//스프링이 제공하는 AOP는 트랜잭션매니저를 찾아서 실행한다.
	@Bean
	PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(ds);
	}
	
}
