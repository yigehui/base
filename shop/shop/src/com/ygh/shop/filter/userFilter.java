package com.ygh.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;

public class userFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		if(req.getSession().getAttribute("user")==null) {
			//获得被过滤器拦截的页面
			String goUrl = req.getServletPath();
			String parm = req.getQueryString();
			if(parm != null) {
				goUrl = goUrl + "?" +parm;
				}
				//把目标页面压入的session中。
				req.getSession().setAttribute("goUrl", goUrl);	
				req.getSession().setAttribute("error", "您还没有登录哦,请登录！");
				res.sendRedirect(req.getContextPath() + "/ulogin.jsp");	
				}else{
					chain.doFilter(request, response);
				}		
	}
	public void init(FilterConfig arg0) throws ServletException {

	}

}