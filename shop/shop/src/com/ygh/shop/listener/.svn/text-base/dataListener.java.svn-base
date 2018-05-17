package com.ygh.shop.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ygh.shop.model.Category;
import com.ygh.shop.model.Product;
import com.ygh.shop.service.categoryService;
import com.ygh.shop.service.productService;
import com.ygh.shop.util.FileUpload;
import com.ygh.shop.util.ProductTimerTask;

public class dataListener implements ServletContextListener{
	
	private FileUpload fileupload;
	
	private ApplicationContext context = null;
	
	protected ProductTimerTask producttimertask = null;

	public void contextDestroyed(ServletContextEvent event) {
		
	}

	public void contextInitialized(ServletContextEvent event) {
	
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		producttimertask = (ProductTimerTask)context.getBean("productTimerTask");
		fileupload = (FileUpload)context.getBean("fileUpload");
		producttimertask.setApplication(event.getServletContext());
		new Timer(true).schedule(producttimertask, 0, 2000*60*60);
		//把银行图片信息放入到application中。
		event.getServletContext().setAttribute("bankImage", fileupload.getImage());
	}

}
