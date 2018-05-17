package com.ygh.shop.action;


import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.ygh.shop.model.Category;


@Component("categoryAction")
@Scope("prototype")
public class CategoryAction extends baseAction<Category>{
	public String queryJoinAccount() {
		jsonMap = new HashMap<String,Object>();
		List<Category> categorylist = categoryservice.queryJoinAccount(model.getType(), page, rows);
		long total = categoryservice.getcount(model.getType());
		jsonMap.put("total", total);
		jsonMap.put("rows", categorylist);
		return "jsonMap";
	}
	
	
	
	public String deleteById() {
		System.out.println("ids:" + ids);
		categoryservice.deleteByid(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	public String add() {
		System.out.println(model);

		categoryservice.add(model);
		return "add";
	}
	


	public String query() {
		jsonList = categoryservice.list();
		return "jsonList";
	}
	public String update() {
		categoryservice.update(model);
		return "update";
	}


	public String list() {
		request.put("categoryList", categoryservice.list());
		session.put("categoryList", categoryservice.list());
		application.put("categoryList", categoryservice.list());
		
		return SUCCESS;
	}
	
	
	
}
