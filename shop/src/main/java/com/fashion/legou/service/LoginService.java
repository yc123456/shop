package com.fashion.legou.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.legou.entity.Result;
import com.fashion.legou.entity.User;
import com.fashion.legou.service.impl.UserMapperImpl;

@Service
public class LoginService {

	@Autowired
	private UserMapperImpl userMapper;
	
	public Result checkUser(User user){
		User users=userMapper.selectByUser(user);
		Result result =new Result();
		if (null!=users){
			result.setLoginStatus(true);
		    return result;
		}
		result.setLoginStatus(false);
		return result;
		

}
}