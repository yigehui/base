package com.ygh.shop.service.imp;





import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;



import com.ygh.shop.dao.ForderDAO;


import com.ygh.shop.model.Category;
import com.ygh.shop.model.Forder;

import com.ygh.shop.service.forderService;


@Component
public class forderServiceImp extends baseServiceImp<Forder> implements forderService{

	

	public BigDecimal getTotal(Forder forder) {
		return forderdao.getTotal(forder);
	}
	public void updateStatusById(int id, int statusId) {
		forderdao.updateStatusById(id, statusId);
	}

	
}