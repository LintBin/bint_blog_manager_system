package com.bint.service.base;

import java.util.List;

import com.bint.vo.PageVo;

public interface BaseService<T> {
	public void save(T model );
	public void delete(Long id);
	public void update(T model);
	public T findById(Long id);
	public List<T> listAll();
	public PageVo getPage(PageVo pageVo);
}
