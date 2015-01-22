package com.bint.service.base.impl;

import java.util.List;

import com.bint.mapper.base.BaseMapper;
import com.bint.service.base.BaseService;
import com.bint.vo.PageVo;

public class BaseServiceImpl<T> implements BaseService<T>{
	public BaseMapper<T> baseMapper;
	
	
	@Override
	public void save(T model) {
		baseMapper.add(model);
	}

	@Override
	public void delete(Long id) {
		baseMapper.delete(id);
	}

	@Override
	public void update(T model) {
		baseMapper.update(model);
	}

	@Override
	public T findById(Long id) {
		T model = baseMapper.findById(id);
		return model;
	}

	public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public List<T> listAll() {
		return baseMapper.listAll();
	}
	
	@Override
	public PageVo getPage(PageVo pageVo){
		List<T> list = baseMapper.getPage(pageVo);
		pageVo.setAmount(baseMapper.getAmount());
		pageVo.setList(list);
		return pageVo;
	}
	
}
