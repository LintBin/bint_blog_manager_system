package com.bint.service;

import java.util.List;

import com.bint.exception.NotDealtException;
import com.bint.model.UserModel;
import com.bint.vo.UserVo;

public interface UserService  {
	public void save(UserModel user);
	public List<UserModel> list();
	public UserModel login(UserVo userVo) throws NotDealtException;
}
