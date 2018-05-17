package com.ygh.shop.dao.imp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ygh.shop.dao.ForderDAO;
import com.ygh.shop.model.Forder;
import com.ygh.shop.model.Sorder;
@Component
public class forderDaoImp extends BaseDaoImp<Forder> implements ForderDAO {

	public BigDecimal getTotal(Forder forder) {
		
		BigDecimal total = new BigDecimal(0.0);
		
		for(Sorder temp : forder.getSorderList())
			
		{
			total = total.add(temp.getPrice().multiply(new BigDecimal(temp.getNumber())));
		}
		return total;
	}

	public void updateStatusById(int id, int statusId) {
		String hql="UPDATE Forder f set f.status.id =:statusId WHERE f.id = :id";
		sf.getCurrentSession().createQuery(hql)
		.setInteger("statusId", statusId)
		.setInteger("id", id)
		.executeUpdate();
		
	}


	

}
