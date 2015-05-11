package com.bint.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bint.mapper.ArticleLabelMapper;
import com.bint.model.ArticleLabelModel;
import com.bint.service.ArticleLabelService;
import com.bint.service.base.impl.BaseServiceImpl;

@Transactional
@Service
public class ArticleLabelServiceImpl extends BaseServiceImpl<ArticleLabelModel> implements
	ArticleLabelService {
	
	private ArticleLabelMapper articleLabelMapper;
	
	@Resource
	public void setArticleLabelMapper(ArticleLabelMapper articleLabelMapper) {
		this.articleLabelMapper = articleLabelMapper;
		this.baseMapper = articleLabelMapper;
	}

	@Override
	public List<ArticleLabelModel> getLabelListByArticelId(Long articleId) {
		List<ArticleLabelModel> list = articleLabelMapper.getLabelListByArticleId(articleId);
		return list;
	}

	@Override
	public void delete(ArticleLabelModel articleLabel) {
		articleLabelMapper.delete(articleLabel);
	}
	
	
	
}
