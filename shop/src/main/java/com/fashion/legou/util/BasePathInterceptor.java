package com.fashion.legou.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BasePathInterceptor extends HandlerInterceptorAdapter {
	private static Logger log = Logger.getLogger(BasePathInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			return true;
		} else {
            response.sendRedirect("/login/login.html");
			return false;
		}
	}
}
