package com.bint.controller.base;

import org.springframework.ui.ModelMap;

public class BaseController {
	public ModelMap modelMap = new ModelMap();
	public ModelMap success(){
		modelMap.addAttribute("statusCode", "200");
		modelMap.addAttribute("message", "操作成功");
		return modelMap;
	}
	public ModelMap failed(){
		modelMap.addAttribute("statusCode", "300");
		modelMap.addAttribute("message", "操作失败");
		return modelMap;
	}
	public ModelMap failedWithReason(String reason){
		modelMap.addAttribute("statusCode", "300");
		modelMap.addAttribute("message", reason);
		return modelMap;
	}
	public ModelMap success(Object object){
		modelMap.addAttribute("statusCode", "200");
		modelMap.addAttribute("message", "操作成功");
		modelMap.addAttribute(object);
		return modelMap;
	}
	
	
	public ModelMap success(String name ,Object object){
		modelMap.addAttribute("statusCode", "200");
		modelMap.addAttribute("message", "操作成功");
		modelMap.addAttribute(name,object);
		return modelMap;
	}
}
