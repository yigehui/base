package com.ygh.shop.service.imp;





import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;



import com.ygh.shop.dao.categoryDAO;
import com.ygh.shop.model.Category;
import com.ygh.shop.service.categoryService;

@Component
public class categoryServiceImp extends baseServiceImp<Category> implements categoryService{
	

	public List<Category> queryJoinAccount(String type,int page,int size) {
		return categorydao.queryJoinAccount(type,page,size);
	}

	public long getcount(String type) {
		
		return categorydao.getcount(type);
	}

	public void deleteByid(String ids) {
		
		categorydao.deleteByid(ids);
	}

	public List<Category> queryByHot(boolean hot) {
		
		return categorydao.queryByHot(hot);
	}
	

	
}