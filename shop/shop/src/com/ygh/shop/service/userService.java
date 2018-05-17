package com.ygh.shop.service;



import java.util.List;


import com.ygh.shop.model.Product;
import com.ygh.shop.model.User;


public interface userService extends BaseService<User>{

	//登录
	public User login(User user);

}
