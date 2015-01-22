package com.bint.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.bint.base.util.ClassificationModellTestUtil;
import com.bint.model.ClassificationModel;

public class ClassifcationMapperTest extends ClassificationModellTestUtil{
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
		long id = 8;
		ClassificationModel c = classficationMapper.findById(id);
		System.out.println(c.getClassificationName());
		if(c.getUser() == null){
			System.out.println("user is null");
		}
		
		System.out.println(c.getUser());
	}
	
	
}
