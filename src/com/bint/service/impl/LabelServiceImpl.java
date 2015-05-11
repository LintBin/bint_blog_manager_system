package com.bint.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bint.mapper.LabelMapper;
import com.bint.model.LabelModel;
import com.bint.service.LabelService;
import com.bint.service.base.impl.BaseServiceImpl;
import com.bint.vo.PageVo;
@Transactional
@Service
public class LabelServiceImpl extends BaseServiceImpl<LabelModel> implements
		LabelService {
	
	private LabelMapper laebelMapper;
	
	@Resource
	public void setLaebelMapper(LabelMapper laebelMapper) {
		this.laebelMapper = laebelMapper;
		this.setBaseMapper(laebelMapper);
	}
	@Override
	public List<LabelModel> getList(String labelName) {
		PageVo pageVo = new PageVo();
		pageVo.setObject(labelName);
		List<LabelModel> result = laebelMapper.getList(pageVo);
		return result;
	}
}
