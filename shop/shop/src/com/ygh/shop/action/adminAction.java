package com.ygh.shop.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import com.ygh.shop.service.categoryService;

@Component("adminAction")
@Scope("prototype")
public class adminAction extends ActionSupport {

	@Override
	public String execute()  {
		
		return "index";
	}
	

	
	
}
