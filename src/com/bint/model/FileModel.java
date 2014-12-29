package com.bint.model;

import com.bint.model.base.BaseModel;

public class FileModel extends BaseModel {
	private String path;
	private ImageModel imgaeModel;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ImageModel getImgaeModel() {
		return imgaeModel;
	}

	public void setImgaeModel(ImageModel imgaeModel) {
		this.imgaeModel = imgaeModel;
	}
}
