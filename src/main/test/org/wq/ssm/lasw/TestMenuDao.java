package org.wq.ssm.lasw;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wq.ssm.dao.lasw.LaswMenuDao;
import org.wq.ssm.entity.lasw.LaswMenu;


/**
 * 首先需要配置spring和junit整合  为了junit启动时加载spring ioc容器
 * @author wangqiang
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration(("classpath:spring/spring-dao.xml"))
public class TestMenuDao {
	//注入dao实现类依赖
	@Resource
	private LaswMenuDao  menuDao;
	 
	@Test
	public void testQueryAll(){
		List<LaswMenu> list=menuDao.queryAll();
		for(LaswMenu ss: list){
			System.out.println(ss);
		}
	}
	 
	@Test
	public void TestQueryById(){
		LaswMenu  laswMenu=menuDao.queryById(10);
			System.out.println(laswMenu);
	}
	
	@Test
	public void TestQueryParentFirst(){
		List<LaswMenu> list=menuDao.queryParentFirst();
		System.out.println(list);
	}
	
	

}
