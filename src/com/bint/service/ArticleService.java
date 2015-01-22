package com.bint.service;

import com.bint.model.ArticleModel;
import com.bint.service.base.BaseService;
import com.bint.vo.ArticleVo;
import com.bint.vo.PageVo;

public interface ArticleService extends BaseService<ArticleModel>{
	public void save(ArticleVo articleVo);
	public void update(ArticleVo articleVo);
	public PageVo fuzzyQuery(ArticleVo articleVo);
}
