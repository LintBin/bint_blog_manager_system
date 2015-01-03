package com.bint.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bint.vo.PageVo;

/**
 * 1.ָ����������������
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 2.��������
 * transactionManager="������applicationContext.xml�ļ�����������������ƣ�Ĭ����transactionManager"
 * defaultRollback=true ����ִ�к��ǻع������ύ,�����ϣ�������������������ݿ��У���������Ϊtrue
 */
/**
 * 4.����������
 * locations��ָ��applicationContext.xml�ļ���·��������ͨ���������ֹ�ָ�� Spring
 * �����ļ����ڵ�λ�ã�����ָ��һ������ Spring
 * �����ļ�@ContextConfiguration(locations={��xx/yy/beans1.xml��,�� xx/yy/beans2.xml��})
 * inheritLocations���Ƿ�Ҫ�̳и������������е�Spring�����ļ���Ĭ��Ϊ true
 */
@ContextConfiguration(locations = { "classpath*:junit-spring-test.xml" })
public abstract class AbstractTransactionalSpringContextTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	public PageVo pageVo = new PageVo();
	public AbstractTransactionalSpringContextTest(){
		pageVo.setSize(5);
		pageVo.setStartIndex(1);
	}
}
