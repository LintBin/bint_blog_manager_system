package com.bint.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bint.base.util.LabelModelTestUtil;

public class LabelMapperTest extends LabelModelTestUtil{
	@Autowired
	private LabelMapper labelMapper;
	@Test
	public void add(){
		labelMapper.add(label);
	}
	@Test
	public void delete(){
		labelMapper.delete(3);
	}
}
