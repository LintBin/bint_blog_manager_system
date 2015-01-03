package com.bint.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bint.vo.PageVo;

/**
 * 1.指定测试用例运行器
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 2.事务配置
 * transactionManager="这里是applicationContext.xml文件中事务管理器的名称，默认是transactionManager"
 * defaultRollback=true 事务执行后是回滚还是提交,如果不希望测试用数据留在数据库中，可以设置为true
 */
/**
 * 4.上下文配置
 * locations：指定applicationContext.xml文件的路径，可以通过该属性手工指定 Spring
 * 配置文件所在的位置，可以指定一个或多个 Spring
 * 配置文件@ContextConfiguration(locations={“xx/yy/beans1.xml”,” xx/yy/beans2.xml”})
 * inheritLocations：是否要继承父测试用例类中的Spring配置文件，默认为 true
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
