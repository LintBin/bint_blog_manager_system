package com.bint.mapper.base;

import java.util.List;

import com.bint.vo.PageVo;

public interface BaseMapper<T> {
	public T findById(Long id);
	public int add(T model);
	public void delete(long id);
	public int update(T model);
	public List<T> listAll();
	public long getAmount(PageVo pageVo);
	public List<T> getPage(PageVo pageVo);
}
