package com.bint.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.LocalDate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bint.mapper.ArticleMapper;
import com.bint.model.ArticleLabelModel;
import com.bint.model.ArticleModel;
import com.bint.service.ArticleLabelService;
import com.bint.service.ArticleService;
import com.bint.service.base.impl.BaseServiceImpl;
import com.bint.vo.ArticleVo;
import com.bint.vo.PageVo;

@Transactional
@Component
public class ArticleServiceImpl extends BaseServiceImpl<ArticleModel> implements
		ArticleService {
	private ArticleMapper articleMapper;
	@Autowired
	private ArticleLabelService articleLabelServiceImpl;

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
		artcileModel.setAuthor(articleVo.getAthorName());
		articleMapper.add(artcileModel);
	}
	
	@Override
	public void update(ArticleModel articleModel){
		articleModel.setUploadTime(new Date());
		articleMapper.update(articleModel);
	}
	
	/*@Override
	public PageVo getPage(PageVo pageVo){
		List<ArticleModel> list = baseMapper.getPage(pageVo);
		List<ArticleVo> voList = new ArrayList<ArticleVo>();
		for(ArticleModel articleModel : list){
			ArticleVo articleVo = new ArticleVo();
			BeanUtils.copyProperties(articleModel,articleVo);
			articleVo.setArticleId(articleModel.getId());
			articleVo.setAthorName(articleModel.getAuthor());
			LocalDate localDate = new LocalDate(articleModel.getUploadTime());
			articleVo.setTime(localDate);
			
			List<ArticleLabelModel> articleLabelList = articleLabelServiceImpl.getLabelListByArticelId(articleModel.getId());
			System.err.println(articleLabelList.size());
			articleVo.setArticleLabelList(articleLabelList);
			
			voList.add(articleVo);
		}
		pageVo.setPageNum(pageVo.getPageNum());
		pageVo.setList(voList);
		return pageVo;
	}*/
	
	public PageVo getPage(PageVo pageVo){
		List<ArticleVo> articleVoList = articleMapper.getArticlePage(pageVo);
		System.err.println("articleVoList" + articleVoList.size());
		List<ArticleVo> articleVoListNew = new ArrayList<ArticleVo>();
		for(ArticleVo articleVo : articleVoList){
			LocalDate localDate = new LocalDate(articleVo.getUploadTime());
			articleVo.setTime(localDate);
			
			//取出指定文章所拥有的标签
			List<ArticleLabelModel> articleLabelList = articleLabelServiceImpl.getLabelListByArticelId(articleVo.getArticleId());
			articleVo.setArticleLabelList(articleLabelList);
			
			articleVoListNew.add(articleVo);
		}
		pageVo.setList(articleVoListNew);
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

	@Override
	public Long getAmount(PageVo pageVo) {
		return baseMapper.getAmount(pageVo);
	}
}
