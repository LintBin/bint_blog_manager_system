package com.bint.service;

import com.bint.exception.NotDealtException;
import com.bint.model.UserModel;
import com.bint.service.base.BaseService;
import com.bint.vo.UserVo;

public interface UserService extends BaseService<UserModel> {
	public UserModel login(UserVo userVo) throws NotDealtException;
}
