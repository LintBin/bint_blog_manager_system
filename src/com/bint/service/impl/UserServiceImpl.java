package com.bint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bint.exception.NotDealtException;
import com.bint.mapper.UserMapper;
import com.bint.model.UserModel;
import com.bint.service.UserService;
import com.bint.vo.UserVo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	public UserMapper userMapper ;
	
	
	
	public void save(UserModel user){
		userMapper.add(user);
	}
	
	public List<UserModel> list(){
		return userMapper.listAll();
	}
	
	public UserModel login(UserVo userVo) throws NotDealtException{
		if (userVo.getUsername() == null || userVo.getPassword() == null){
			return null;
		}
		UserModel userModel = userMapper.findByUsername(userVo.getUsername());
		if (userModel == null){
			return null;
		}
		if (userVo.getPassword().equals(userModel.getPassword())){
			return userModel;
		}
		throw new NotDealtException();
	}
}
