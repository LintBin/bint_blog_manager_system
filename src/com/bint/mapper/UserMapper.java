package com.bint.mapper;

import com.bint.mapper.base.BaseMapper;
import com.bint.model.UserModel;

public interface UserMapper extends BaseMapper<UserModel>{
	public UserModel findByUsername(String username);
}