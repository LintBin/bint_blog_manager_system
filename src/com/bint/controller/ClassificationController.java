package com.bint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bint.controller.base.BaseController;
import com.bint.model.ClassificationModel;
import com.bint.service.ClassificationService;
import com.bint.vo.PageVo;

@Controller
public class ClassificationController extends BaseController{
	@Autowired
	private ClassificationService classificationServiceImpl;
	
	
	
	@RequestMapping(value = "classification/add" ,method = RequestMethod.POST )
	public @ResponseBody ModelMap add(ClassificationModel classificationModel){
		System.err.println(classificationModel.toString());
		classificationServiceImpl.save(classificationModel);
		return success();
	}
	
	
	@RequestMapping(value = "classification/listAll" ,method = RequestMethod.GET )
	public @ResponseBody ModelMap listAll(PageVo pageVo){
		List<ClassificationModel> list= classificationServiceImpl.listAll();
		return success("classifiactionList",list);
	}
}
