package com.ygh.shop.service;

import java.util.List;



public interface BaseService <T>{

	
	public void add (T t);
	
	public List<T> list();
	public T get(int id);
	public void delete (int id);
	public void update (T t);
}
