package com.ygh.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ygh.shop.dao.SorderDAO;
import com.ygh.shop.model.Category;
import com.ygh.shop.model.Forder;
import com.ygh.shop.model.Product;
import com.ygh.shop.model.Sorder;
import com.ygh.shop.service.sorderService;
@Component("sorderService")
public class sorderServiceImp extends baseServiceImp<Sorder> implements sorderService {
	
	public Sorder sorderToForder(Product product) {
		
		return sorderdao.sorderToForder(product);
	}

	public Forder addSorder(Forder forder, Product product) {
		return sorderdao.addSorder(forder, product);
	}
	public Forder updateSorder(Forder forder, Sorder sorder) {
		return sorderdao.updateSorder(forder, sorder);
	}
	public List<Object> querySale(int number) {
		return sorderdao.querySale(number);
	}

}
