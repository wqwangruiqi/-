package org.wq.ssm.lasw;

import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wq.ssm.entity.lasw.LaswMenu;
import org.wq.ssm.service.lasw.LaswMenuService;


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
public class TestMenuService {
	//注入dao实现类依赖
	@Resource
	private LaswMenuService  laswMenuService;
	 
	@Test
	public void testQueryAll(){
		List<Object> objList=laswMenuService.getMenuTree();
		System.out.println(objList);
	}
	
	@Test
	public void testQueryAll2(){
		//java.lang.reflect.Type.getTypeName()
		List<LaswMenu>  objList=laswMenuService.queryAll();
		System.out.println(objList);
	}
	
	
}
