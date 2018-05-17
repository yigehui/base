package com.ygh.shop.dao;

import java.util.List;

import com.ygh.shop.dao.BaseDAO;

import com.ygh.shop.model.Product;

public interface productDAO extends BaseDAO<Product>{
	//实现分页效果
	public List<Product> queryJoinCategory(String name, int page,int size);
	//获得总数量
	public long getcount(String name); 
	//通过Id获得产品列表
	public List<Product> queryByCid (int cid);

}
