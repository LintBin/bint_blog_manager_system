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
public class UserServiceImpl extends BaseServiceImpl<UserModel> implements
		UserService {
	private UserMapper userMapper;

	@Resource
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
		this.setBaseMapper(userMapper);
	}

	@Override
	public UserModel login(UserVo userVo) throws NotDealtException {
		if (userVo.getUsername() == null || userVo.getPassword() == null) {
			return null;
		}
		UserModel userModel = userMapper.findByUsername(userVo.getUsername());
		if (userModel == null) {
			return null;
		}
		if (userVo.getPassword().equals(userModel.getPassword())) {
			System.err.println(userModel.toString());
			return userModel;
		} else {
			return null;
		}
	}

}