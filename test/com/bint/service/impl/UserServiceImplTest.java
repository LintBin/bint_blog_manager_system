package com.bint.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bint.base.util.UserModelTestUtil;
import com.bint.model.UserModel;
import com.bint.service.UserService;
import com.bint.vo.UserVo;

public class UserServiceImplTest extends UserModelTestUtil{
	@Autowired
	public UserService userServiceImpl;
	
	@Test
	public void list(){
		List<UserModel> users = userServiceImpl.listAll();
		for(UserModel user :users){
			System.err.println(user.getId());
		}
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
		UserModel user = (UserModel) pageVo.getList().get(0);
		System.out.println(user.getAddress());
	}
}
