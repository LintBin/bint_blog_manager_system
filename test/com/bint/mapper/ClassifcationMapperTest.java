package com.bint.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.bint.base.util.ClassificationlTestUtil;
import com.bint.model.ClassificationModel;

public class ClassifcationMapperTest extends ClassificationlTestUtil{
	@Autowired
	private ClassificationMapper classficationMapper;
	
	@Rollback(false)
	@Test
	public void add(){
		user.setId(12);
		classification.setUser(user);
		classficationMapper.add(classification);
	}
	
	
	@Test
	public void delete(){
		
	}
	
	@Test
	public void findById(){
		long id = 10;
		ClassificationModel c = classficationMapper.findById(id);
		System.out.println(c.getClassificationName());
		System.out.println(c.getUser().getUsername());
	}
	
	
}
