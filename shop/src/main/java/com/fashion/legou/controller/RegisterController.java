package com.fashion.legou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/register")
public class RegisterController {

	@RequestMapping(value="/register.html")
	public String register(){
		return "/register";
		
	} 
}
