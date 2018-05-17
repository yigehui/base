package com.ygh.shop.dao.imp;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ygh.shop.dao.BaseDAO;



@Component("baseDAO")
@Lazy(true)
public class BaseDaoImp<T> implements BaseDAO<T>{
	
	private Class clazz;
	
	protected SessionFactory sf;
	
	BaseDaoImp () {
		//初始化clazz获得范型类型的class
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
	}
	
	
	
	public SessionFactory getSf() {
		return sf;
	}

	@Resource
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	public void add(T t) {
		/*Session s =  hibernateSessionFactory.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();*/
		
	 sf.getCurrentSession().save(t);
		
	}
	
	
	public List<T> list() {
		
		//System.out.println("from " + clazz.getSimpleName());
		return (List<T>)sf.getCurrentSession().createQuery("from " + clazz.getSimpleName()).list();
		
	}

	public T get(int id) {
	
		return (T)sf.getCurrentSession().get(clazz, id);
	}

	

	public void delete(int id) {
		Session s = sf.getCurrentSession();
		System.out.println("delete from "+ clazz.getSimpleName() + " where id = ?");
		s.createQuery("delete from "+ clazz.getSimpleName() + " where id = ?")
		.setInteger(0, id)
		.executeUpdate();
		
	}

	public void update(T t) {
		sf.getCurrentSession().update(t);
	}

}
