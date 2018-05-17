package com.ygh.shop.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ygh.shop.model.Account;



public class testAccount {

	
	@Test
	public void testAdd() {
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		accountService accountservice = (accountService)applicationcontext.getBean("accountServiceImp");
		Account a = new Account();
		a.setLogin("admin");
		a.setName("Сǿ");
		a.setPass("admin***");
		accountservice.add(a);
	}
	
}
