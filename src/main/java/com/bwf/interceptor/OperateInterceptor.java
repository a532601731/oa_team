package com.bwf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bwf.entity.Auth;
import com.bwf.entity.User;

public class OperateInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("用户申请进入页面："+request.getRequestURI());
		String uri = request.getRequestURI();
		
		boolean sessionContainsUri = false;
		User user = (User) request.getSession().getAttribute("user"); 
		for( Auth o : user.getRole().getAuthes() ) {
			if ( uri.contains( o.getMenuUrl() ) ) {
				sessionContainsUri = true;
			}
		}
		
		if ( sessionContainsUri ) {
			return true;
		} else {
			System.out.println("权限不够，拦截");
			response.sendRedirect( request.getContextPath() + "/error");
			return false;
		}
	}
	
}