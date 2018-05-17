package com.ygh.shop.dao;

import java.util.List;

import com.ygh.shop.dao.BaseDAO;

import com.ygh.shop.model.Product;
import com.ygh.shop.model.User;

public interface userDAO extends BaseDAO<User>{
	//登录
	public User login(User user);

}
