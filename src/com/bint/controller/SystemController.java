package com.bint.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bint.controller.base.BaseController;
@Controller
public class SystemController extends BaseController{
	
	@RequestMapping(value = "system/url", method = RequestMethod.POST)
	public @ResponseBody ModelMap save(HttpServletRequest request,String url) {
		HttpSession session = request.getSession();
		
		String[] urlArray = url.split("/"); 
		session.setAttribute("url",urlArray[urlArray.length-1]);
		return success();
	}
	
	
}
