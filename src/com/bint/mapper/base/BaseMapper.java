package com.bint.mapper.base;

import java.util.List;

public interface BaseMapper<T> {
	public T findById(Long id);
	public int add(T model);
	public void delete(long id);
	public int update(T model);
	public List<T> listAll();
}
