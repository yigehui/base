package com.ygh.shop.service.imp;





import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



import com.ygh.shop.dao.BaseDAO;
import com.ygh.shop.dao.ForderDAO;
import com.ygh.shop.dao.SorderDAO;
import com.ygh.shop.dao.accountDAO;
import com.ygh.shop.dao.categoryDAO;
import com.ygh.shop.dao.productDAO;
import com.ygh.shop.dao.userDAO;


import com.ygh.shop.model.Forder;

import com.ygh.shop.service.BaseService;
import com.ygh.shop.service.forderService;


@Component
@Lazy(true)
public class baseServiceImp<T> implements BaseService<T>{
	
	private Class clazz;
	
	protected BaseDAO basedao;
	@Resource
	protected ForderDAO forderdao;
	@Resource
	protected accountDAO accountdao;
	@Resource
	protected categoryDAO categorydao;
	@Resource
	protected productDAO productdao;
	@Resource
	protected SorderDAO sorderdao;
	@Resource
	protected userDAO userdao;
	
	

	baseServiceImp() {
		
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
		System.out.println(clazz);
	}
	@PostConstruct
	public void init(){
		//实现basedao的动态加载
		System.out.println("---------init-------");
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0, 1).toLowerCase() + clazzName.substring(1) + "dao";
		System.out.println(clazzDao);
		try {
			Field field = this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("basedao");
			baseField.set(this, field.get(this));
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void add(T t) {
		basedao.add(t);
	}

	public List<T> list() {
		return basedao.list();
	}

	public T get(int id) {
	
		return (T)basedao.get(id);
	}

	public void delete(int id) {
		basedao.delete(id);
	}

	public void update(T t) {
		basedao.update(t);
	}
	
	
	
	
}