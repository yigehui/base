package com.ygh.shop.service;



import java.util.List;


import com.ygh.shop.model.Forder;
import com.ygh.shop.model.Product;
import com.ygh.shop.model.Sorder;


public interface sorderService extends BaseService<Sorder>{


	//通过商品建立购物项
	public Sorder sorderToForder(Product product);
	//把购物项加入到购物车
	public Forder addSorder(Forder forder,Product product);
	//更新购物项
	public Forder updateSorder(Forder forder,Sorder sorder);
	//查询销售结果
	public List<Object> querySale(int number);
}
