package com.ygh.shop.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ygh.shop.model.Category;

import com.ygh.shop.service.categoryService;



public class testRegister {

	
	@Test
	public void testAdd() {
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryService categoryservice = (categoryService)applicationcontext.getBean("categoryServiceImp");
		Category c = new Category();
		c.setType("老人休闲");
		c.setHot(true);
		categoryservice.add(c);
	}
	@Test
	public void testList() {
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryService categoryservice = (categoryService)applicationcontext.getBean("categoryServiceImp");
		for(Category c : categoryservice.list())
		{
			System.out.println(c.getType()  +"---" + c.isHot());
			
		}
		
	}
	@Test
	public void testQuery() {
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryService categoryservice = (categoryService)applicationcontext.getBean("categoryServiceImp");
		for(Category c : categoryservice.queryJoinAccount("",2,2))
		{
			System.out.println(c);
			
		}
		
	}

@Test
public void testLoad() {
	ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
	categoryService registerservice = (categoryService)applicationcontext.getBean("categoryServiceImp");
	System.out.println(registerservice.get(1).getType());
	
}

@Test
public void testUpdate() {
	ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
	categoryService categoryservice = (categoryService)applicationcontext.getBean("categoryServiceImp");
	Category c = new Category();
	c.setId(1);
	c.setType("女士休闲");
	c.setHot(false);
	
	categoryservice.update(c);
	
}

@Test
public void testDelete() {
	ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
	categoryService categoryservice = (categoryService)applicationcontext.getBean("categoryServiceImp");
	
	categoryservice.delete(4);
	
}
@Test
public void testCount() {
	ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
	categoryService categoryservice = (categoryService)applicationcontext.getBean("categoryServiceImp");
	
	System.out.println(categoryservice.getcount(""));
	
}
@Test
public void testDeleteByid() {
	ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
	categoryService categoryservice = (categoryService)applicationcontext.getBean("categoryServiceImp");
	
	categoryservice.deleteByid("2,3,4,5");
	
}
@Test
public void testQueryByHot() {
	ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
	categoryService categoryservice = (categoryService)applicationcontext.getBean("categoryServiceImp");
	for(Category c:categoryservice.queryByHot(true))
	{
		System.out.println(c);
	}
}

}
