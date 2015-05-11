package com.bint.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bint.mapper.ClassificationMapper;
import com.bint.model.ClassificationModel;
import com.bint.service.ClassificationService;
import com.bint.service.base.impl.BaseServiceImpl;
@Transactional
@Service
public class ClassificationServiceImpl extends BaseServiceImpl<ClassificationModel> implements ClassificationService{
	private ClassificationMapper classificationMapper;
	
	@Resource
	public void setClassificationMapper(ClassificationMapper classificationMapper) {
		this.classificationMapper = classificationMapper;
		this.baseMapper = classificationMapper;	
	}
	
	
}
