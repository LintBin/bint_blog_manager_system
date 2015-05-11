package com.bint.service;

import java.util.List;

import com.bint.model.ArticleLabelModel;
import com.bint.service.base.BaseService;

public interface ArticleLabelService extends BaseService<ArticleLabelModel>{
	public List<ArticleLabelModel> getLabelListByArticelId(Long articleId);
	public void delete(ArticleLabelModel articleLabel);
}
