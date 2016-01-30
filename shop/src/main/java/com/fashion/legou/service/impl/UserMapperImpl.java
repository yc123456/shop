package com.fashion.legou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import com.fashion.legou.dao.UserMapper;
import com.fashion.legou.entity.Page;
import com.fashion.legou.entity.User;

@Repository
public class UserMapperImpl implements UserMapper {

	@Autowired
	private UserMapper userMapper;

	public User selectByUser(User entity) {
		return userMapper.selectByUser(entity);
	}

	public int countAll() {
		
		return userMapper.countAll();
	}

	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Cacheable( value="page",key="#page.getCurPage()")
	public List<User> findPage(Page page) {
		System.out.println("未使用缓存");
		page.setCurPage((page.getCurPage() - 1) * (page.getPageSize()));
		return userMapper.findPage(page);
	}
    
	@CacheEvict(value="page",allEntries=true)
	public void deleteItem(List<Integer> list) {
		 userMapper.deleteItem(list);
	}

}
