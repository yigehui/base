package com.ygh.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ygh.shop.model.Forder;
import com.ygh.shop.model.Product;
import com.ygh.shop.model.Sorder;
import com.ygh.shop.model.Status;
import com.ygh.shop.model.User;


@Component("forderAction")
@Scope("prototype")
public class forderAction extends baseAction<Forder> {
	
	@Override
	public Object getModel() {
		
		model = (Forder)session.get("forder");
		return model;
	}

	//保存订单信息
	public String save() {
		//
		
		model.setUser((User)(session.get("user")));
		model.setStatus(new Status(1));
		forderservice.add(model);
		
		//把forder移除，并保存为oldForder
		session.put("oldForder", session.get("forder"));
		//刷新购物车
		session.put("forder", new Forder());
		session.put("forder_number", new Integer(0));
		//跳转到银行页面
		return "bank";
	}

}
