package com.ygh.shop.service;



import java.util.List;

import com.ygh.shop.model.Category;


public interface categoryService extends BaseService<Category>{

	public List<Category> queryJoinAccount(String type, int page ,int size);
	public long getcount(String type); 
	public void deleteByid(String ids);
	//找到热点商品，显示到首页
	public List<Category> queryByHot(boolean hot);
}
