package com.bint.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.bint.base.util.UserModelTestUtil;
import com.bint.model.UserModel;
import com.bint.vo.PageVo;

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
		for(int i=0;i<10;i++){
			user.setUsername("hongbin"+i);
			userMapper.add(user);
		}
	}
	@Test
	public void getPage(){
		PageVo page = new PageVo();
		page.setSize(5);
		page.setStartIndex(1);
		List<UserModel> list = userMapper.getPage(page);
		System.out.println(list.size());
		System.out.println(list.get(4).getUsername());
	}
	
	@Rollback(false)
	@Test
	public void findById(){
		long id = 11;
		UserModel userModel = userMapper.findById(id);
		System.out.println(userModel.getUsername());
		System.out.println(userModel.getClassificationList().size());
	}
}
