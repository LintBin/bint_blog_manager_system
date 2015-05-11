package com.bint.vo;

import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;

import com.bint.model.ArticleLabelModel;

public class ArticleVo {
	private Long articleId;
	private String headline;
	private String content;
	private String digest;
	private LocalDate time;
	private int stateCode;
	private int praiseAmount;
	private String athorName;
	private Date uploadTime;
	private List<ArticleLabelModel> articleLabelList; 
	private Long labelId;

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Long getLabelId() {
		return labelId;
	}

	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}

	public List<ArticleLabelModel> getArticleLabelList() {
		return articleLabelList;
	}

	public void setArticleLabelList(List<ArticleLabelModel> articleLabelList) {
		this.articleLabelList = articleLabelList;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getContent() {
		return content;
	}

	public String getAthorName() {
		return athorName;
	}

	public void setAthorName(String athorName) {
		this.athorName = athorName;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}


	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public int getPraiseAmount() {
		return praiseAmount;
	}

	public void setPraiseAmount(int praiseAmount) {
		this.praiseAmount = praiseAmount;
	}
	
	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ArticleVo [articleId=" + articleId + ", headline=" + headline
				+ ", content=" + content + ", digest=" + digest + ", time="
				+ time + ", stateCode=" + stateCode + ", praiseAmount="
				+ praiseAmount + ", athorName=" + athorName + "]";
	}



}
