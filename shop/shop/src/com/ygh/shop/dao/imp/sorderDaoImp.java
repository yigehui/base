package com.ygh.shop.dao.imp;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ygh.shop.dao.ForderDAO;
import com.ygh.shop.dao.SorderDAO;
import com.ygh.shop.model.Forder;
import com.ygh.shop.model.Product;
import com.ygh.shop.model.Sorder;
@Component
public class sorderDaoImp extends BaseDaoImp<Sorder> implements SorderDAO {

	public Sorder sorderToForder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		System.out.println(sorder);
		return sorder;
	}

	public Forder addSorder(Forder forder, Product product) {
		Sorder sorder = sorderToForder(product);
		//判断是否存在此购物项
		boolean isHave = false;
		for(Sorder old : forder.getSorderList())
		{	
			if(old.getProduct().getId()==sorder.getProduct().getId()) {
				old.setNumber(old.getNumber()+ sorder.getNumber());
				isHave=true;
				break;
			}	
		}
		//添加新的购物项
		if(!isHave) {
			sorder.setForder(forder);
			forder.getSorderList().add(sorder);
		}
		return forder;
	}

	public Forder updateSorder(Forder forder, Sorder sorder) {
		//判断购物车中的商品id与传过来的id一致的话，更新number
		for(Sorder temp : forder.getSorderList() )
		{
			if(temp.getProduct().getId().equals(sorder.getProduct().getId()))
			{
				temp.setNumber(sorder.getNumber());
			}
		}
	
		return forder;
	}

	public List<Object> querySale(int number) {
		 String hql = "select s.name,s.number from Sorder s join s.product group by s.product.id";
		 return sf.getCurrentSession().createQuery(hql)
		.setFirstResult(0)
		.setMaxResults(number)
		.list();
		
	}
	

	

}
