package com.bint.controller.base;

import org.springframework.ui.ModelMap;

public class BaseController {
	public ModelMap modelMap = new ModelMap();
	public ModelMap sucess(){
		modelMap.addAttribute("statusCode", "200");
		modelMap.addAttribute("message", "操作成功");
		return modelMap;
	}
	public ModelMap failed(){
		modelMap.addAttribute("statusCode", "300");
		modelMap.addAttribute("message", "操作失败");
		return modelMap;
	}
}
