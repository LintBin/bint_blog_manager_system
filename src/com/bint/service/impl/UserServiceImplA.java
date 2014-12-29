package com.bint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bint.exception.NotDealtException;
import com.bint.mapper.base.BaseMapper;
import com.bint.model.UserModel;
import com.bint.service.UserService;
import com.bint.service.base.impl.BaseServiceImpl;
import com.bint.vo.UserVo;

@Service
public class UserServiceImplA extends BaseServiceImpl<UserModel> implements UserService{
	@Autowired
	public BaseMapper<UserModel> userMapper;
	
	
	@Override
	public List<UserModel> list() {
		System.out.println(userMapper.getClass().getName());
		if(userMapper == null){
			System.out.println("userMapper is null");
		}{
			System.out.println("userMapper is not null");
		}
		return null;
	}

	@Override
	public UserModel login(UserVo userVo) throws NotDealtException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
