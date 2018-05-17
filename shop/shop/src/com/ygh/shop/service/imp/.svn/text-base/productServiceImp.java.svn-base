package com.ygh.shop.service.imp;





import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;




import com.ygh.shop.dao.productDAO;

import com.ygh.shop.model.Category;
import com.ygh.shop.model.Product;

import com.ygh.shop.service.productService;

@Component
public class productServiceImp extends baseServiceImp<Product> implements productService{
	

	public List<Product> queryJoinCategory(String name,int page,int size) {
		return productdao.queryJoinCategory(name,page,size);
	}

	public long getcount(String name) {
		
		return productdao.getcount(name);
	}
	public List<Product> queryByCid(int cid) {
		
		return productdao.queryByCid(cid);
	}

	

	
}