package com.bint.model;

import java.util.Set;

import com.bint.model.base.BaseModel;

public class LabelModel extends BaseModel{
	private String labelName;
	public Set<UserModel> users;
	
	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public Set<UserModel> getUsers() {
		return users;
	}  

	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}
}
