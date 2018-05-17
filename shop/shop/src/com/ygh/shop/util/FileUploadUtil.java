package com.ygh.shop.util;

import java.io.File;
import java.io.FilenameFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ygh.shop.model.FileImage;
@Component("fileUpload")
@Scope("prototype")
public class FileUploadUtil implements FileUpload {
	//文件地址
	private String filepath ;
	//图片地址
	private String bankpath ;
	@Value("#{prop.basepath+prop.bankpath}")
	public void setBankpath(String bankpath) {
		this.bankpath = bankpath;
	}
	//spring3.0支持SpEL表达式(org.springframework.beans.factory.config.PropertiesFactoryBean)
	@Value("#{prop.basepath+prop.filepath}")
	public void setFilepath(String filepath) {
		//System.out.println(filepath);
		this.filepath = filepath;
	}
	
	private String getExt(String fileName){
		return FilenameUtils.getExtension(fileName);
	}

	
	private String setNewName(String ext) {
		return UUID.randomUUID().toString() + "." + ext;
		
	}
	
	public String uploadFile(FileImage fileimage) {
		String pic = setNewName(getExt(fileimage.getFilename()));
		try {
			FileUtil.copyFile(fileimage.getFile(), new File(filepath + pic));
			return pic;
		} catch (Exception e) {
			throw new RuntimeException();
		}finally{
			
			fileimage.getFile().delete();
		}
		
	}
	//获得银行图片信息
	public List<String> getImage() {
		List<String> bankImage = new ArrayList<String>();
		String string[] = new File(bankpath).list(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				return name.endsWith(".gif");
			}
		});
		for (String temp:string)
		{
			bankImage.add(temp);		
		}
		return bankImage;
	}

}
