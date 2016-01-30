package com.fashion.legou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.legou.entity.Page;
import com.fashion.legou.entity.User;
import com.fashion.legou.service.impl.UserMapperImpl;
@Service
public class AdminService {
	@Autowired
	private UserMapperImpl userMapper;

	public List<User> findPage(Page page) {
		
		return userMapper.findPage(page);
	}
	
	public int countAll(){
		return userMapper.countAll();
	}

	public void deleteItem(List<Integer> list) {
		 userMapper.deleteItem(list);
		
	}

}
