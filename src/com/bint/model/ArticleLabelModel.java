package com.bint.model;

public class ArticleLabelModel {
	private Long labelId;
	private String labelName;
	private Long articleId;
	private String articleHeadline;

	public Long getLabelId() {
		return labelId;
	}

	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getArticleHeadline() {
		return articleHeadline;
	}

	public void setArticleHeadline(String articleHeadline) {
		this.articleHeadline = articleHeadline;
	}
}
