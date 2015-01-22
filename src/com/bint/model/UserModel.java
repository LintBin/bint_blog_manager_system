package com.bint.model;

import java.util.List;

import com.bint.model.base.BaseModel;

public class UserModel extends BaseModel {
	private String username;
	private String password;
	private String address;
	private String gender;
	private int permissionCode;
	private List<ClassificationModel> classificationList;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(int permissionCode) {
		this.permissionCode = permissionCode;
	}

	public List<ClassificationModel> getClassificationList() {
		return classificationList;
	}

	public void setClassificationList(
			List<ClassificationModel> classificationList) {
		this.classificationList = classificationList;
	}

	@Override
	public String toString() {
		return "UserModel [username=" + username + ", password=" + password
				+ ", address=" + address + ", gender=" + gender
				+ ", permissionCode=" + permissionCode
				+ ", classificationList=" + classificationList + "]";
	}
	
}
