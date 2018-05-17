package com.ygh.shop.service;



import java.util.List;


import com.ygh.shop.model.Product;


public interface productService extends BaseService<Product>{

	public List<Product> queryJoinCategory(String name, int page ,int size);
	public long getcount(String name); 
	//找到分类下面的前几个商品，显示到首页
	public List<Product> queryByCid (int cid);
}
