package com.bint.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bint.exception.NotDealtException;
import com.bint.model.UserModel;
import com.bint.service.UserService;
import com.bint.vo.UserVo;

@Controller
public class UserController {
	@Resource
	private UserService userServiceImpl;
	
	@RequestMapping(value = "userServiceAdd", method = RequestMethod.GET)
	public @ResponseBody ModelMap save() {
		UserModel user = new UserModel();
		user = new UserModel();
		user.setAddress("address");
		user.setGender("男");
		user.setPassword("password");
		user.setUsername("lin");
		user.setPermissionCode(1);
		userServiceImpl.save(user);
		return null;
	}

	@RequestMapping(value = "userList", method = RequestMethod.GET)
	public @ResponseBody ModelMap list() {
		List<UserModel> list = userServiceImpl.list();
		ModelMap modelMap = new ModelMap();
		modelMap.put("list", list);
		return modelMap;
	}
	
	@RequestMapping(value = "userLogin", method = RequestMethod.GET)
	public @ResponseBody ModelMap login(UserVo userVo) throws NotDealtException {
		UserModel userModel = userServiceImpl.login(userVo);
		if (userModel == null){
			//TODO 返回登陆错误的信息
			
		}else{
			//TODO 把用户的信息存放到session域
			
		}
		return null;
	}
	
	@RequestMapping(value = "deleteUser", method = RequestMethod.GET)
	public @ResponseBody ModelMap delete(){
		
		return null;
	}
	
}
