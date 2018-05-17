package com.ygh.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ygh.shop.dao.accountDAO;
import com.ygh.shop.dao.userDAO;
import com.ygh.shop.model.Forder;
import com.ygh.shop.model.Product;
import com.ygh.shop.model.Sorder;
import com.ygh.shop.model.User;
import com.ygh.shop.service.BaseService;
import com.ygh.shop.service.sorderService;
import com.ygh.shop.service.userService;
@Component("userService")
public class userServiceImp extends baseServiceImp<User> implements userService {

	
	public User login(User user) {
		return userdao.login(user);
	}

	
}
