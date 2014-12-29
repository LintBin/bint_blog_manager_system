package com.bint.base.util;

import com.bint.model.UserModel;
import com.bint.test.base.AbstractTransactionalSpringContextTest;



public class UserModelTestUtil extends AbstractTransactionalSpringContextTest{
	public UserModel user;
	public UserModelTestUtil(){
		user = new UserModel();
		user.setAddress("adress");
		user.setGender("ÄÐ");
		user.setPassword("password");
		user.setPermissionCode(1);
		user.setUsername("username");
	}
}
