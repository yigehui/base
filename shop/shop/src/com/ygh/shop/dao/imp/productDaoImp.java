package com.ygh.shop.dao.imp;


import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;


import com.ygh.shop.dao.categoryDAO;
import com.ygh.shop.dao.productDAO;
import com.ygh.shop.model.Category;
import com.ygh.shop.model.Product;


@Component
public class productDaoImp extends BaseDaoImp<Product> implements productDAO{

	public List<Product> queryJoinCategory(String name,int page,int size) {
		//实现分页效果
		Session s = sf.getCurrentSession();
		List<Product> products = (List<Product>)s.createQuery("from Product p left join fetch p.category where p.name like ?")
			.setString(0, "%"+name+"%")
			.setFirstResult((page-1)*size)
			.setMaxResults(size)
			.list();
		return products;
	}

	public long getcount(String name) {
		String sql = "select count(p) from Product p where p.name like ?";
		long count = (Long)sf.getCurrentSession().createQuery(sql)
		.setString(0, "%" + name + "%")
		.uniqueResult();
		return count;
	}

	public List<Product> queryByCid(int cid) {
		
		String sql = "from Product p join fetch p.category where p.commend = true AND p.open = true AND p.category.id = ? ORDER BY p.date DESC";
		return  sf.getCurrentSession().createQuery(sql)
		.setInteger(0, cid)
		.setFirstResult(0)
		.setMaxResults(4)
		.list();
		
	}

}
