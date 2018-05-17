package com.ygh.shop.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ygh.shop.model.Account;
import com.ygh.shop.model.Product;
import com.ygh.shop.util.MailUtil;



public class testProduct {

	
	@Test
	public void testQuery() {
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		productService productservice = (productService)applicationcontext.getBean("productServiceImp");
		
		for(Product p : productservice.list()){
			p.getCategory().setAccount(null);
			System.out.println(p);
		}
	}
	@Test
	public void testMail() {
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		MailUtil mailUtil= (MailUtil)applicationcontext.getBean("mailUtil");
		
		mailUtil.sendMail("76511144473", "yigehui2@163.com");
	}
	@Test
	public void testQueryByCid() {
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		productService productservice = (productService)applicationcontext.getBean("productServiceImp");
		
		for(Product p : productservice.queryByCid(1)){
			
			System.out.println(p);
		}
	}
	
	@Test
	public void testGet() {
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		productService productservice = (productService)applicationcontext.getBean("productServiceImp");
		System.out.println(productservice.get(1));
		System.out.println(productservice.get(1));
		
	}
	
}
