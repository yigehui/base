package com.ygh.shop.action;

/*
 * sturut2 收到请求后，先创建action的代理，顺便创建了action然后调用18个拦截器，
 * 
 * 执行完成后，执行action中的代码，在返回拦截器。、
 * 
 * 创建action --------> servletConfig --------> modelDriven
 * 
 * */
import java.io.PrintWriter;
import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.opensymphony.xwork2.ActionContext;
import com.ygh.shop.model.BackData;
import com.ygh.shop.model.Forder;
import com.ygh.shop.model.SendData;
import com.ygh.shop.model.User;

@Controller("payAction")
@Scope("prototype")
public class PayAction extends baseAction<Object> implements ParameterAware{

	private static final long serialVersionUID = -3898532322589046425L;
	//实现action处理多model的情况，用到Struts2的parameters;
	private Map<String, String[]> parameters;
	

	@Override
	public Object getModel() {
		
		if(parameters.get("pd_FrpId")!=null) {
			
			model = new SendData();
		}else{
			model = new BackData();
		}
		return model;
	}

	public String goBank() {
		// 把明文和密文都存储到request Map对象中
		//给p2 p3 pa p6 赋值
		SendData sendData = (SendData)model;
		Forder forder = (Forder)session.get("oldForder");
		User user = (User)session.get("user");
		sendData.setP2_Order(String.valueOf(forder.getId()));
		sendData.setP3_Amt(String.valueOf(forder.getTotal()));
		sendData.setPa_MP(user.getEmail()+","+user.getPhone());
		payservice.saveDataToRequest(request, sendData);
		return "reqpay";
	}



	public void setParameters(Map<String, String[]> parameters) {
		this.parameters=parameters;
	}
	
	public void backBank() {
		BackData backData = (BackData)model;
		boolean isOk = payservice.checkBackData(backData);
		if(isOk){
			System.out.println("success");
			//1.更新订单状态,发送邮件和短信.
			
			forderservice.updateStatusById(Integer.parseInt(backData.getR6_Order()), 2);
			//2.发送支付成功邮件
			String mail = backData.getR8_MP().split(",")[0];
			String phone = backData.getR8_MP().split(",")[1];
			System.out.println(mail);
			System.out.println(phone);
			//mailUtil.sendMail(backData.getR6_Order(), mail);
			//3.发送短信
			//messageUtil.sendSms(phone, backData.getR6_Order());
		}else{
			System.out.println("fail");
		}
			
	}

}
