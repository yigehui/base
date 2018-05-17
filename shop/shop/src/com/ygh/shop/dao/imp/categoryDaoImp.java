package com.ygh.shop.dao.imp;


import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;


import com.ygh.shop.dao.categoryDAO;
import com.ygh.shop.model.Category;


@Component
public class categoryDaoImp extends BaseDaoImp<Category> implements categoryDAO{

	public List<Category> queryJoinAccount(String type,int page,int size) {
		//实现分页
		Session s = sf.getCurrentSession();
		List<Category> Categorys = (List<Category>)s.createQuery("from Category c left join fetch c.account where c.type like ?")
			.setString(0, "%"+type+"%")
			.setFirstResult((page-1)*size)
			.setMaxResults(size)
			.list();
		return Categorys;
	}

	public long getcount(String type) {
		String sql = "select count(c) from Category c where c.type like ?";
		long count = (Long)sf.getCurrentSession().createQuery(sql)
		.setString(0, "%" + type + "%")
		.uniqueResult();
		return count;
	}

	public void deleteByid(String ids) {
		String sql = "delete from Category c where c.id in ("+ ids + ")";
		sf.getCurrentSession().createQuery(sql)
		.executeUpdate();
	}

	public List<Category> queryByHot(boolean hot) {
		String sql = "from Category c where c.hot = :hot";
		return  sf.getCurrentSession().createQuery(sql)//
		.setBoolean("hot", hot)//
		.list();
		
	}
}
