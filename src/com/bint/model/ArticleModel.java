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
	private UserModel userModel;
	private ClassificationModel classifiction;

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

	public ClassificationModel getClassifiction() {
		return classifiction;
	}

	public void setClassifiction(ClassificationModel classifiction) {
		this.classifiction = classifiction;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
}
