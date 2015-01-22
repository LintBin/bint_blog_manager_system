package com.bint.mapper;

import java.util.List;

import com.bint.mapper.base.BaseMapper;
import com.bint.model.ArticleModel;
import com.bint.vo.ArticleVo;

public interface ArticleMapper extends BaseMapper<ArticleModel>{
	public List<ArticleModel> fuzzyQuery(ArticleVo articleVo);
}