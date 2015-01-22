package com.bint.vo;

public class UserVo {
	private String username;
	private String password;
	private String address;
	private String gender;
	private int permissionCode;
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

	@Override
	public String toString() {
		return "UserVo [username=" + username + ", password=" + password + "]";
	}

}
