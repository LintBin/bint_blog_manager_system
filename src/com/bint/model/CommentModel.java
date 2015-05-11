package com.bint.model;

import java.util.Date;

import com.bint.model.base.BaseModel;

public class CommentModel extends BaseModel {
	private Date commentTime;
	private String content;
	private Long userId;
	private Long blogId;
	private Long comemntId;
	
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	public Long getComemntId() {
		return comemntId;
	}
	public void setComemntId(Long comemntId) {
		this.comemntId = comemntId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "CommentModel [commentTime=" + commentTime + ", content="
				+ content + ", userId=" + userId + ", blogId=" + blogId
				+ ", comemntId=" + comemntId + "]";
	}
	
}
