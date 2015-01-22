package com.bint.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.LocalDate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bint.mapper.ArticleMapper;
import com.bint.model.ArticleModel;
import com.bint.model.UserModel;
import com.bint.service.ArticleService;
import com.bint.service.base.impl.BaseServiceImpl;
import com.bint.vo.ArticleVo;
import com.bint.vo.PageVo;

@Transactional
@Component
public class ArticleServiceImpl extends BaseServiceImpl<ArticleModel> implements
		ArticleService {
	private ArticleMapper articleMapper;

	@Resource
	public void setArticleMapper(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
		this.setBaseMapper(articleMapper);
	}
	
	@Override
	public void save(ArticleVo articleVo){
		ArticleModel artcileModel = new ArticleModel();
		BeanUtils.copyProperties(articleVo, artcileModel);
		artcileModel.setUploadTime(new Date());
		UserModel user = new UserModel();
		user.setId(articleVo.getAuthorId());
		artcileModel.setAuthor(user);
		articleMapper.add(artcileModel);
	}
	
	@Override
	public void update(ArticleVo articleVo){
		ArticleModel articleModel = new ArticleModel();
		BeanUtils.copyProperties(articleVo, articleModel);
		articleModel.setUploadTime(new Date());
		articleModel.setId(articleVo.getArticleId());
		UserModel user = new UserModel();
		user.setId(articleVo.getAuthorId());
		articleModel.setAuthor(user);
		articleMapper.update(articleModel);
	}
	
	@Override
	public PageVo getPage(PageVo pageVo){
		List<ArticleModel> list = baseMapper.getPage(pageVo);
		List<ArticleVo> voList = new ArrayList<ArticleVo>();
		for(ArticleModel articleModel : list){
			ArticleVo articleVo = new ArticleVo();
			BeanUtils.copyProperties(articleModel,articleVo);
			articleVo.setArticleId(articleModel.getId());
			LocalDate localDate = new LocalDate(articleModel.getUploadTime());
			articleVo.setTime(localDate);
			voList.add(articleVo);
		}
		pageVo.setAmount(baseMapper.getAmount());
		pageVo.setList(voList);
		return pageVo;
	}
	/**
	 * 条件查询
	 */
	@Override
	public PageVo fuzzyQuery(ArticleVo articleVo) {
		List<ArticleModel> list = articleMapper.fuzzyQuery(articleVo);
		PageVo pageVo = new PageVo();
		List<ArticleVo> voList = new ArrayList<ArticleVo>();
		for(ArticleModel articleModel : list){
			ArticleVo articleTemp = new ArticleVo();
			BeanUtils.copyProperties(articleModel,articleTemp);
			articleTemp.setArticleId(articleModel.getId());
			LocalDate localDate = new LocalDate(articleModel.getUploadTime());
			articleTemp.setTime(localDate);
			voList.add(articleTemp);
		}
		pageVo.setList(voList);
		pageVo.setAmount(voList.size());
		return pageVo;
	}
	
}
