package com.bint.service;

import java.util.List;

import com.bint.model.LabelModel;
import com.bint.service.base.BaseService;

public interface LabelService extends BaseService<LabelModel>{
	public List<LabelModel> getList(String labelName);
}
