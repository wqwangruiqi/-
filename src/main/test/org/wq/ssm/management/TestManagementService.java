package org.wq.ssm.management;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wq.ssm.entity.lasw.LaswMenu;
import org.wq.ssm.entity.lasw.LaswNewsTitle;
import org.wq.ssm.entity.management.UserInfo;
import org.wq.ssm.service.lasw.LaswMenuService;
import org.wq.ssm.service.management.ManagementService;


/**
 * 首先需要配置spring和junit整合  为了junit启动时加载spring ioc容器
 * @author wangqiang
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ 
				"classpath:spring/spring-dao.xml", 
				"classpath:spring/spring-service.xml" ,
				"classpath:spring/spring-web.xml" })

/**
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月6日 下午2:46:28
 * 类的说明:这是一个测试service的类
 *
 */
public class TestManagementService {
	//注入dao实现类依赖
	@Resource
	private ManagementService  managementService;
	@Resource
	private LaswMenuService  laswMenuService;
	 
	@Test
	public void  userInfoInsert(){
		UserInfo userInfo=new  UserInfo();
		userInfo.setAge(23);
		userInfo.setEmail("sfdsfsd@qq.com");
		userInfo.setUserName("wwwwwwwwwww");
		System.out.println(managementService.userInfoInsert(userInfo)); 
	}
	@Test
	public void  laswNewsTitleInsert(){
		LaswNewsTitle title=new LaswNewsTitle();
		title.setClickNumber(2);
		title.setInsertTime(new Date());
		title.setIstop(1);
		title.setLaswmenuId(60300L);
		title.setTitleName("哇哈哈");
		title.setUpdateTime(new Date());
		System.out.println(managementService.laswNewsTitleInsert(title)); 
	}
	@Test
	public void testTeansactinal(){
		UserInfo userInfo=new  UserInfo();
		userInfo.setAge(23);
		userInfo.setEmail("sfdsfsd@qq.com");
		userInfo.setUserName("wwwwwwwwwww");
		
		
		LaswNewsTitle title=new LaswNewsTitle();
		title.setClickNumber(2);
		title.setInsertTime(new Date());
		title.setIstop(1);
		title.setLaswmenuId(60300L);
		title.setTitleName("哇哈哈");
		title.setUpdateTime(new Date());
		
		managementService.testTeansactinal(userInfo, title);
	}
	
	
	
	@Test
	public void testQueryAll(){
		List<UserInfo> userList=managementService.queryAll();
		System.out.println(userList);
		System.out.println("==========");
		List<LaswMenu> list=laswMenuService.queryAll();
		System.out.println(list);
	
		
	}
	
	
}
