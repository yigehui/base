package com.ygh.shop.action;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;



import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;


import com.ygh.shop.model.Category;
import com.ygh.shop.model.Product;


@Component("productAction")
@Scope("prototype")
public class productAction extends baseAction<Product>{
	public String queryJoinCategory() {
		jsonMap = new HashMap<String,Object>();
		List<Product> productlist = productservice.queryJoinCategory(model.getName(), page, rows);
		long total = productservice.getcount(model.getName());
		jsonMap.put("total", total);
		jsonMap.put("rows", productlist);
		return "jsonMap";
	}
	
	

	public void add() throws Exception {
		String pic = fileupload.uploadFile(fileimage);
		model.setPic(pic);
		System.out.println(model);
		productservice.add(model);		
	}
	

	public String query() {

		return "query";
	}
	public String update() {
		productservice.update(model);
		return "update";
	}
	
	public String get() {
		request.put("product", productservice.get(model.getId()));
		return "detail";
	}
	
}
