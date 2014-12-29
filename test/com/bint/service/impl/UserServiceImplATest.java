package com.bint.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bint.base.util.UserModelTestUtil;
import com.bint.service.UserService;

public class UserServiceImplATest extends UserModelTestUtil{
	@Autowired
	private UserService userServiceImplA;
	
	@Test
	public void findById(){
		long id = 1;
		userServiceImplA.list();
		
	}
}
