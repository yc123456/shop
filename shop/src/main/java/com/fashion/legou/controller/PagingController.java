package com.fashion.legou.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.fashion.legou.entity.Page;
import com.fashion.legou.entity.User;
import com.fashion.legou.service.AdminService;

@Controller
@RequestMapping(value = "/paging")
public class PagingController {
	
private static Logger log=LoggerFactory.getLogger(PagingController.class);

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/pageInfo.htm")
	public String paging(ModelMap model) {
		Page page = new Page();
		page.setCurPage(1);
		List<User> pages = adminService.findPage(page);
		int count = adminService.countAll();
		page.setCount(count);// 设置总数据量
		page.countPage(page.getCount());// 计算页数
		model.addAttribute("pagelist", pages);
		model.addAttribute("count", page);
		return "/list";

	}

	@RequestMapping(value = "/list/{page}")
	public String findPage(@PathVariable int page, ModelMap model) {
		Page p = new Page();
		p.setCurPage(page);
		List<User> pages = adminService.findPage(p);
		int count = adminService.countAll();
		p.setCurPage(page);
		p.setCount(count);
		p.countPage(p.getCount());
		model.addAttribute("pagelist", pages);
		model.addAttribute("count", p);
		return "/list";
	}

	@RequestMapping(value = "/delete/{url}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable String url) {
		String[] ids=StringUtils.split(url,'.');
		List<Integer> list=new ArrayList<Integer>();
		for (String s :ids) {
			list.add(Integer.valueOf(s));
		}
		try {
			adminService.deleteItem(list);
			return "删除成功"; 
		} catch (Exception e) {
			log.error("failed",e);
			return "failed";
		}
		
	}

}
