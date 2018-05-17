package com.ygh.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;

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


import com.ygh.shop.model.FileImage;
import com.ygh.shop.service.PayService;
import com.ygh.shop.service.accountService;
import com.ygh.shop.service.categoryService;
import com.ygh.shop.service.forderService;
import com.ygh.shop.service.productService;
import com.ygh.shop.service.sorderService;
import com.ygh.shop.service.userService;
import com.ygh.shop.util.FileUpload;
import com.ygh.shop.util.MailUtil;
import com.ygh.shop.util.MailUtilImpl;
import com.ygh.shop.util.MessageUtil;

@Component("baseAction")
@Scope("prototype")
public class baseAction<T> extends ActionSupport implements ModelDriven,RequestAware,SessionAware,ApplicationAware{
	protected T model;
	
	protected String ids;
	
	protected FileImage fileimage;

	
	private Class clazz;
	
	protected Integer page;
	
	protected List<T> jsonList = null;
	
	

	protected Map<String,Object> jsonMap = null;
	
	protected Integer rows;

	protected InputStream inputStream;

	//获得范型类型的clazz
	public baseAction() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
		//System.out.println(clazz);
	}


	public Object getModel() {
		//new范型类型的model传过去
		 try {
			try {
				model = (T)clazz.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return model;
	}

	//初始化service
	protected categoryService categoryservice;
	
	protected accountService accountservice;
	
	protected forderService forderservice;
	
	protected userService userservice;
	
	protected productService productservice;
	
	protected sorderService sorderservice;
	
	protected PayService payservice;
	
	protected FileUpload fileupload;
	
	protected MailUtil mailUtil;

	protected MessageUtil messageUtil;
	
	
	
	
	public MessageUtil getMessageUtil() {
		return messageUtil;
	}

	@Resource
	public void setMessageUtil(MessageUtil messageUtil) {
		this.messageUtil = messageUtil;
	}


	public MailUtil getMailUtil() {
		return mailUtil;
	}

	@Resource
	public void setMailUtil(MailUtil mailUtil) {
		this.mailUtil = mailUtil;
	}


	public PayService getPayservice() {
		return payservice;
	}

	@Resource
	public void setPayservice(PayService payservice) {
		this.payservice = payservice;
	}


	public userService getUserservice() {
		return userservice;
	}

	@Resource
	public void setUserservice(userService userservice) {
		this.userservice = userservice;
	}


	public categoryService getCategoryservice() {
		return categoryservice;
	}

	@Resource
	public void setCategoryservice(categoryService categoryservice) {
		this.categoryservice = categoryservice;
	}


	public FileUpload getFileupload() {
		return fileupload;
	}

	@Resource(name="fileUpload")
	public void setFileupload(FileUpload fileupload) {
		this.fileupload = fileupload;
	}


	public productService getProductservice() {
		return productservice;
	}

	@Resource
	public void setProductservice(productService productservice) {
		this.productservice = productservice;
	}
	
	

	public sorderService getSorderservice() {
		return sorderservice;
	}

	@Resource(name="sorderService")
	public void setSorderservice(sorderService sorderservice) {
		this.sorderservice = sorderservice;
	}


	public accountService getAccountservice() {
		return accountservice;
	}

	@Resource
	public void setAccountservice(accountService accountservice) {
		this.accountservice = accountservice;
	}

	
	public categoryService getRegisterservice() {
		return categoryservice;
	}

	@Resource
	public void setRegisterservice(categoryService registerservice) {
		this.categoryservice = registerservice;
	}
	
	

	public forderService getForderservice() {
		return forderservice;
	}

	@Resource
	public void setForderservice(forderService forderservice) {
		this.forderservice = forderservice;
	}

	protected Map<String, Object> application;
	protected Map<String, Object> session;
	protected Map<String, Object> request;
	
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	

	public Map getJsonMap() {
		System.out.println("-------getmap----");
		return jsonMap;
	}


	public void setJsonMap(Map jsonMap) {
		this.jsonMap = jsonMap;
	}
	public Integer getRows() {
		return rows;
	}


	public void setRows(Integer rows) {
		this.rows = rows;
	}


	public String getIds() {
		return ids;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}


	public InputStream getInputStream() {
		return inputStream;
	}
	
	public List<T> getJsonList() {
		return jsonList;
	}


	public FileImage getFileimage() {
		return fileimage;
	}


	public void setFileimage(FileImage fileimage) {
		this.fileimage = fileimage;
	}
	
	
}
