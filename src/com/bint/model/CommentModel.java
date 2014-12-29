package com.bint.model;

import java.util.Date;

import com.bint.model.base.BaseModel;

public class CommentModel extends BaseModel {
	private Date commentTime;
	private String content;
	private UserModel user;
	private ArticleModel article;
	private CommentModel comment;
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
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public ArticleModel getArticle() {
		return article;
	}
	public void setArticle(ArticleModel article) {
		this.article = article;
	}
	public CommentModel getComment() {
		return comment;
	}
	public void setComment(CommentModel comment) {
		this.comment = comment;
	}
}
