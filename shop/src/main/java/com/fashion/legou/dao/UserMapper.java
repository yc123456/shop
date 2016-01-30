package com.fashion.legou.dao;

import java.util.List;

import com.fashion.legou.entity.Page;
import com.fashion.legou.entity.User;


public interface UserMapper {
	
	public User selectByUser(final User entity);
	
	
	public int countAll();
	
	public List<User> findPage(final Page page);
	
	
	public List<User> findAll();


	public void deleteItem(List<Integer> list);
}
