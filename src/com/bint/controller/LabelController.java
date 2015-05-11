package com.bint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bint.controller.base.BaseController;
import com.bint.model.LabelModel;
import com.bint.service.LabelService;
import com.bint.vo.PageVo;

@Controller
public class LabelController extends BaseController{
	@Autowired
	private LabelService labelServiceImpl;
	
	@RequestMapping("label/getList")
	public String getList(String labelName ,Model model){
		PageVo pageVo = new PageVo();
		List<LabelModel> result = labelServiceImpl.getList(labelName);
		pageVo.setList(result);
		pageVo.setAmount(result.size());
		model.addAttribute("pageVo",pageVo);
		return "jsp/label/manageLabel";
	}
	
	
	@RequestMapping("label/addLabel")
	public @ResponseBody ModelMap  addLabel(LabelModel label,Model model){
		labelServiceImpl.save(label);
		return success();
	}
	
	@RequestMapping("label/deleteLabel")
	public @ResponseBody ModelMap  deleteLabel(Long labelId,Model model){
		labelServiceImpl.delete(labelId);
		return success();
	}
	
	
}
