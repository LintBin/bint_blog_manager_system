package com.bint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bint.controller.base.BaseController;
import com.bint.model.ArticleLabelModel;
import com.bint.service.ArticleLabelService;

@Controller
public class ArticleLabelController extends BaseController {
	
	@Autowired
	private ArticleLabelService articleLabelServiceImpl;
	
	/**
	 * 增加指定标签并返回所拥有的标签
	 * @param articlelabelModel
	 * @return
	 */
	@RequestMapping(value = "article/label/add" )
	public @ResponseBody ModelMap add(ArticleLabelModel articlelabelModel){
		articleLabelServiceImpl.save(articlelabelModel);
		List<ArticleLabelModel> result = articleLabelServiceImpl.getLabelListByArticelId(articlelabelModel.getArticleId());
		return success("havingLabels",result);
	}
	
	/**
	 * 删除指定的标签并返回所拥有的标签
	 * @param articlelabelModel
	 * @return
	 */
	@RequestMapping(value = "article/label/delete" )
	public @ResponseBody ModelMap delete(ArticleLabelModel articlelabelModel){
		articleLabelServiceImpl.delete(articlelabelModel);
		List<ArticleLabelModel> result = articleLabelServiceImpl.getLabelListByArticelId(articlelabelModel.getArticleId());
		return success("havingLabels",result);
	}
	
}
