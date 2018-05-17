package com.ygh.shop.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;
@Component("messageUtil")
public class MessageUtilImp implements MessageUtil {
	/* (non-Javadoc)
	 * @see com.ygh.shop.util.MessageUtil#sendSms(java.lang.String, java.lang.String)
	 */
	public  void sendSms(String phone,String id){
		//1.打开IE浏览器
		HttpClient client = new HttpClient();
		/*
		 * http://utf8.sms.webchinese.cn/?Uid=本站用户名&Key=接口安全秘钥&smsMob=手机号码&smsText=验证码:8888
		 */
		
		PostMethod post = new PostMethod("utf8.sms.webchinese.cn");
		//设置头信息
		post.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
		//设置请求参数
	
		post.setParameter("Uid", "yigehui");
		post.setParameter("Key", "c41de8ef2a6d9d55b6f2");
		post.setParameter("smsMob", phone);
		post.setParameter("smsText", "订单"+ id +"已经支付成功！");
		//2.提交请求
		try {
			int code = client.executeMethod(post);
			System.out.println("浏览器返回结果为：" + code);
		//返回的是状态码
			String result = post.getResponseBodyAsString();
			//获取服务器端返回的数据信息
			System.out.println("短信发送结果为：" + result);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			post.releaseConnection();
		}
		
	}

}
