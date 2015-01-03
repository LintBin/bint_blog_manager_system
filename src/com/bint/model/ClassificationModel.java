package com.bint.model;

import com.bint.model.base.BaseModel;

public class ClassificationModel extends BaseModel {
	private String classificationName;
	private UserModel user;


	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

}