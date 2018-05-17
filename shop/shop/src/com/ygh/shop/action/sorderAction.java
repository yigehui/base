package com.ygh.shop.action;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.ygh.shop.model.Forder;
import com.ygh.shop.model.Product;
import com.ygh.shop.model.Sorder;


@Component("sorderAction")
@Scope("prototype")
public class sorderAction extends baseAction<Sorder> {
	public String querySale() {
		List<Object> josnList = sorderservice.querySale(model.getNumber());
		ActionContext.getContext().getValueStack().push(josnList);
		return "jsonList";
	}
	
	public String update() {
		Forder forder = (Forder)session.get("forder");
		forder = sorderservice.updateSorder(forder, model);
		//更新购物车总价格
		forder.setTotal(forderservice.getTotal(forder));
		session.put("forder", forder);
		//返回新的总价格
		inputStream = new ByteArrayInputStream(String.valueOf(forderservice.getTotal(forder)).getBytes());
		return "stream";
	}
	
	public String addSorder() {
		
		//添加购物项
		//1.获取产品id
		
		Product product = productservice.get(model.getProduct().getId());
		//2.看session中是否存在forder
		if(session.get("forder") == null)
		{
			session.put("forder", new Forder());
			session.put("forder_number", new Integer(0));
		}
		//3.添加购物项进购物车
		System.out.println("---add---");
		Forder forder = (Forder)session.get("forder");		
		Integer forder_number = (Integer)session.get("forder_number");
		forder = sorderservice.addSorder(forder, product);
		//购物车的购物项数量
		forder_number += 1;
		
		
		//4.计算总价
		forder.setTotal(forderservice.getTotal(forder));
		//5.把购物车放进session中
		session.put("forder", forder);
		session.put("forder_number", forder_number);
		return "showForder";
	}

}
