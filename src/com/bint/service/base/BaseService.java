package com.bint.service.base;

public interface BaseService<T> {
	public void save(T model );
	public void delete(Long id);
	public void update(T model);
	public void findById(Long id);
}
