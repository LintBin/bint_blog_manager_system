package com.bint.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.bint.base.util.UserModelTestUtil;
import com.bint.model.UserModel;
import com.bint.service.UserService;
import com.bint.vo.UserVo;

public class UserServiceImplTest extends UserModelTestUtil{
	@Autowired
	public UserService userServiceImpl;
	
	@Test
	public void list(){
		long id = 1;
		System.out.println("Size:" + userServiceImpl.listAll().size());;
	}
	@Test
	public void login() throws Exception {
		UserVo userVo = new UserVo();
		userVo.setUsername("linhongbin");
		userVo.setPassword("password");
		UserModel userModel = userServiceImpl.login(userVo);
	}
	@Test
	public void save(){
		userServiceImpl.save(user);
	}
	@Test
	public void getPage(){
		this.pageVo =  userServiceImpl.getPage(pageVo);
		System.out.println(pageVo.getAmount());
	}
}
