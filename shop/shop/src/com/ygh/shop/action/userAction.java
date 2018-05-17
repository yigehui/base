package com.ygh.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ygh.shop.model.Forder;
import com.ygh.shop.model.Product;
import com.ygh.shop.model.Sorder;
import com.ygh.shop.model.User;


@Component("userAction")
@Scope("prototype")
public class userAction extends baseAction<User> {
	
	
	public String login() {
		//进行登录判断
		model = userservice.login(model);
		if(model == null) {
			session.put("error", "用户名或密码错误");		
			return "ulogin";
		}else{
			//跳转到想要去的页面
		session.put("user", model);
		
		return "goUrl";
	
		}
}
}