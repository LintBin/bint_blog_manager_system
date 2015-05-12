package com.bint.model;

import com.bint.model.base.BaseModel;

public class NotificationModel extends BaseModel{
	
	private String toUser;
	private String content ;
	private Integer status;
	
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}