package com.bint.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bint.base.util.UserModelTestUtil;
import com.bint.service.UserService;

public class UserServiceImplTest extends UserModelTestUtil{
	@Autowired
	public UserService userServiceImpl;
	
	@Test
	public void findById(){
		long id = 1;
		userServiceImpl.list();
	}
	
	
}
