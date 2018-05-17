package com.ygh.shop.dao;


import java.math.BigDecimal;

import com.ygh.shop.dao.BaseDAO;

import com.ygh.shop.model.Forder;

public interface ForderDAO extends BaseDAO<Forder>{
	//计算购物车的总价格
	public BigDecimal getTotal(Forder forder);
	public void updateStatusById(int id ,int statusId);
}
