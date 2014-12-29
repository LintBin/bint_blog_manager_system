package com.bint.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bint.base.util.UserModelTestUtil;
import com.bint.model.UserModel;

public class UserMapperTest extends UserModelTestUtil{
	@Autowired
	public UserMapper userMapper ;
	@Test
	public void findByUsername (){
		UserModel user = userMapper.findByUsername("usernmae");
		System.out.println(user.getAddress());
	}
	@Test
	public void delete(){
		long i = 1;
		userMapper.delete(i);
	}
	@Test
	public void add(){
		userMapper.add(user);
	}
}
