package com.bint.model;

import com.bint.model.base.BaseModel;

public class ImageModel extends BaseModel {
	private ArticleModel articleModel;
	private String path;
	
	public ArticleModel getArticleModel() {
		return articleModel;
	}

	public void setArticleModel(ArticleModel articleModel) {
		this.articleModel = articleModel;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
