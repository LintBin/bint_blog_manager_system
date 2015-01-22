package com.bint.model;

import java.util.Date;

import com.bint.model.base.BaseModel;

public class ArticleModel extends BaseModel {
	private String headline;
	private String content;
	private String digest;
	private Date uploadTime;
	private int stateCode;
	private int praiseAmount;
	private UserModel author;
	private ClassificationModel classification;

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getContent() {
		return content;
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

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
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

	public ClassificationModel getClassification() {
		return classification;
	}

	public void setClassification(ClassificationModel classification) {
		this.classification = classification;
	}

	public UserModel getAuthor() {
		return author;
	}

	public void setAuthor(UserModel author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "ArticleModel [headline=" + headline + ", content=" + content
				+ ", digest=" + digest + ", uploadTime=" + uploadTime
				+ ", stateCode=" + stateCode + ", praiseAmount=" + praiseAmount
				+ ", author=" + author + ", classification=" + classification
				+ "]";
	}
	
}
