package com.ygh.shop.dao;

import java.util.List;

import com.ygh.shop.dao.BaseDAO;
import com.ygh.shop.model.Category;

public interface categoryDAO extends BaseDAO<Category>{
	//��ҳ��ʾ
	public List<Category> queryJoinAccount(String type, int page,int size);
	public long getcount(String type); 
	//����ɾ��
	public void deleteByid(String ids);
	//����ȵ��ѯ���
	public List<Category> queryByHot(boolean hot);
}
