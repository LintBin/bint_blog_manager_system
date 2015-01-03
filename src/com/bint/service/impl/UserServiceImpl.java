package com.bint.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bint.exception.NotDealtException;
import com.bint.mapper.UserMapper;
import com.bint.model.UserModel;
import com.bint.service.UserService;
import com.bint.service.base.impl.BaseServiceImpl;
import com.bint.vo.UserVo;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserModel> implements UserService{
	private UserMapper userMapper;
	@Resource
	public void setUserMapper(UserMapper userMapper){
		this.userMapper = userMapper;
		this.setBaseMapper(userMapper);
	}
	
	public UserModel login(UserVo userVo) throws NotDealtException{
		System.out.println("in the login :" + userVo.getPassword());
		System.out.println("in the login :" + userVo.getUsername());
		if (userVo.getUsername() == null || userVo.getPassword() == null){
			return null;
		}
		UserModel userModel = userMapper.findByUsername(userVo.getUsername());
		if (userModel == null){
			System.out.println("userModel is null");
			return null;
		}
		if (userVo.getPassword().equals(userModel.getPassword())){
			return userModel;
		}else{
			System.out.println("’À∫≈√‹¬Î≤ª∆•≈‰");
			return null;
		}
	}


}
