package com.fashion.legou.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.fashion.legou.entity.Result;
import com.fashion.legou.entity.User;

import com.fashion.legou.service.LoginService;

/**
 * 
 * @author yaocheng
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private LoginService loginService;


	@RequestMapping(value = "/login.html")
	public String doLogin(ModelMap model) {
		// User users=userImpl.selectByUser(user);
		// System.out.println(users);
		return "/login";
	}
 
	@RequestMapping(value = "/doLogin.htm", method = RequestMethod.POST)
	public @ResponseBody String login(HttpServletRequest request, User user) {
		String json = null;
		Result usr = loginService.checkUser(user);
		if (usr.isLoginStatus()) {
			request.getSession().setMaxInactiveInterval(96670);
			request.getSession().setAttribute("user", user);
			json = JSON.toJSONString(usr);
		} else {
			user.setLoginStatus(false);
			json = JSON.toJSONString(user);
		}
		return json;
	}

}
