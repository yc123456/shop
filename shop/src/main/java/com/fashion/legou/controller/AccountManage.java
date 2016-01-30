package com.fashion.legou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/account")
public class AccountManage {
   
	@RequestMapping(value="/resetPwd.html")
	public String resetPwd(){
		return "/resetPwd";
	}
	
}
