package com.mspringjpadata.onetomanyexample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.mspringjpadata.onetomanyexample")
@EnableTransactionManagement
public class CustomHibernateConfiguration {

}
