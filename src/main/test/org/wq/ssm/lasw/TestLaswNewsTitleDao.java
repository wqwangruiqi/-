package org.wq.ssm.lasw;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wq.ssm.dao.lasw.LaswNewsTitleDao;
import org.wq.ssm.entity.lasw.LaswNewsTitle;


/**
 * 首先需要配置spring和junit整合  为了junit启动时加载spring ioc容器
 * @author wangqiang
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration({ 
	"classpath:spring/spring-dao.xml", 
	"classpath:spring/spring-service.xml" ,
	"classpath:spring/spring-web.xml" })
public class TestLaswNewsTitleDao {
	//注入dao实现类依赖
	@Resource
	private LaswNewsTitleDao  dao;
	
	
	@Test
	public void testQueryByIdMenuId(){
		List<LaswNewsTitle> titles=dao.queryByMenuId(60100);
		System.out.println(titles);
	}

	
	@Test
	public void testInsert(){
		LaswNewsTitle title=new LaswNewsTitle();
		title.setClickNumber(2);
		title.setInsertTime(new Date());
		title.setIstop(1);
		title.setLaswmenuId(60300L);
		title.setTitleName("哇哈哈");
		title.setUpdateTime(new Date());
		int ABC = dao.insert(title);
		System.out.println(ABC);
	}
	
	
	@Test
	public void testUpdate(){
		LaswNewsTitle title=new LaswNewsTitle();
		title.setId(4);
		title.setClickNumber(3);
		title.setIstop(0);
		title.setTitleName("哇哈哈xiugaiceshi");
		title.setUpdateTime(new Date());
		int ABC = dao.update(title);
		System.out.println(ABC);
	}
	
	
	@Test
	public void TestDelete(){
		int ABC = dao.delete(4);
		System.out.println(ABC);
	}
	

}












