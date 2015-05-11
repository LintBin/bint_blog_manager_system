package com.bint.model;

import com.bint.model.base.BaseModel;

public class ClassificationModel extends BaseModel {
	private String classificationName;

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}

	@Override
	public String toString() {
		return "ClassificationModel [classificationName=" + classificationName
				+ "]";
	}

}