package com.bint.service.base.impl;

import com.bint.mapper.base.BaseMapper;
import com.bint.service.base.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
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
	public void findById(Long id) {
		baseMapper.findById(id);
	}

	public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}
	
}
