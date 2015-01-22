package com.bint.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bint.base.util.ArtcileModelTestUtil;
import com.bint.model.ArticleModel;
import com.bint.service.ArticleService;
import com.bint.vo.ArticleVo;
import com.bint.vo.PageVo;

public class ArticleServiceImplTest extends ArtcileModelTestUtil{
	@Autowired
	private ArticleService articleServiceImpl;
	@Test
	public void save(){
		articleServiceImpl.save(article);
	}
	
	@Test
	public void fuzzyQueryByDigest(){
		ArticleVo articleVo = new ArticleVo();
		articleVo.setDigest("d");
		PageVo pageVo = articleServiceImpl.fuzzyQuery(articleVo);
		List<ArticleModel> list = (List<ArticleModel>) pageVo.getList();
		System.err.println(list.size());
	}
	@Test
	public void fuzzyQueryByHeadline(){
		ArticleVo articleVo = new ArticleVo();
		articleVo.setHeadline("headline");
		PageVo pageVo = articleServiceImpl.fuzzyQuery(articleVo);
		List<ArticleModel> list = (List<ArticleModel>) pageVo.getList();
		System.err.println(list.size());
	}
}
