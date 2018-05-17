package com.ygh.shop.service;

import static org.junit.Assert.*;

import net.sf.json.JSONSerializer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ygh.shop.model.Category;

import com.ygh.shop.service.categoryService;



public class testOrder {

	
	@Test
	public void testQuery() {
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		sorderService sorderservice = (sorderService)applicationcontext.getBean("sorderService");
		//System.out.println(JSONSerializer.toJSON(sorderservice.querySale(5)));
		for (Object temp : sorderservice.querySale(5))
		{
			System.out.println(temp);
		}
	}



}
