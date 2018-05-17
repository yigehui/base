package com.ygh.shop.action;



import com.ygh.shop.model.Account;



/**此action是为了完成请求转发的功能，此
 * 
 * @author Administrator
 *
 */

public class accountAction extends baseAction<Account>{

	public  String query(){
		
		jsonList = accountservice.list();
		return "jsonList";
	}

}
