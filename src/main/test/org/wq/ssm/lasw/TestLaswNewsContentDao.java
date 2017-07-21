package org.wq.ssm.lasw;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wq.ssm.dao.lasw.LaswNewsContentDao;
import org.wq.ssm.entity.lasw.LaswNewsContent;


/**
 * 首先需要配置spring和junit整合  为了junit启动时加载spring ioc容器
 * @author wangqiang
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration(("classpath:spring/spring-dao.xml"))
public class TestLaswNewsContentDao {
	//注入dao实现类依赖
	@Resource
	private LaswNewsContentDao  dao;
	
	
	 
 
	
	@Test
	public void testQueryByTitleIdWithTitleWithAtts(){
		LaswNewsContent newsContent=dao.queryByTitleIdWithTitleWithAtts(3);
		System.out.println(newsContent);
	}

	
	@Test
	public void testInsert(){
		LaswNewsContent content=new LaswNewsContent();
		content.setId(3);
		content.setLaswnewsTitleid(4);
		content.setNewsContent("==测试数据==");
		int ABC = dao.insert(content);
		System.out.println(ABC);
	}
	
	
	@Test
	public void testUpdate(){
		LaswNewsContent content=new LaswNewsContent();
		content.setId(3);
		content.setLaswnewsTitleid(4);
		content.setNewsContent("==测试数据修改==");
		int ABC = dao.update(content);
		System.out.println(ABC);
	}
	
	
	@Test
	public void TestDelete(){
		int ABC = dao.delete(4);
		System.out.println(ABC);
	}
	
	
	 
	

}
