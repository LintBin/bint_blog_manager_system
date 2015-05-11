package com.bint.mapper;

import java.util.List;

import com.bint.mapper.base.BaseMapper;
import com.bint.model.ArticleLabelModel;

public interface ArticleLabelMapper extends BaseMapper<ArticleLabelModel> {
	public List<ArticleLabelModel> getLabelListByArticleId(Long articleId);
	public void delete(ArticleLabelModel articleLabel);
}
