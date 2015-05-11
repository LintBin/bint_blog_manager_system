package com.bint.vo;

import java.util.Date;

public class CommentVo {
	private Date commentTime;
	private String content;
	private String username;
	private Long blogId;
	private Long comemntId;
	private Long parentCommentId;
	private String commentTimeStr;
	private String articleTittle;

	public String getArticleTittle() {
		return articleTittle;
	}

	public void setArticleTittle(String articleTittle) {
		this.articleTittle = articleTittle;
	}

	public String getCommentTimeStr() {
		return commentTimeStr;
	}

	public void setCommentTimeStr(String commentTimeStr) {
		this.commentTimeStr = commentTimeStr;
	}

	public Long getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(Long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "CommentVo [commentTime=" + commentTime + ", content=" + content
				+ ", username=" + username + ", blogId=" + blogId
				+ ", comemntId=" + comemntId + ", parentCommentId="
				+ parentCommentId + ", commentTimeStr=" + commentTimeStr
				+ ", articleTittle=" + articleTittle + "]";
	}

}
