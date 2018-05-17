package com.ygh.shop.dao.imp;


import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;


import com.ygh.shop.dao.categoryDAO;
import com.ygh.shop.dao.productDAO;
import com.ygh.shop.dao.userDAO;
import com.ygh.shop.model.Category;
import com.ygh.shop.model.Product;
import com.ygh.shop.model.User;


@Component
public class userDaoImp extends BaseDaoImp<User> implements userDAO{

	public User login(User user) {
		String sql = "FROM User u WHERE u.login=:login AND u.pass=:pass ";
		return (User)sf.getCurrentSession().createQuery(sql)
		.setString("login", user.getLogin())
		.setString("pass", user.getPass())
		.uniqueResult();
			
	}

	
}
