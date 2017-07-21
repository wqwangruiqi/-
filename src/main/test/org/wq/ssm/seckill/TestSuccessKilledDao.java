package org.wq.ssm.seckill;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wq.ssm.dao.seckill.SuccessKilledDao;
import org.wq.ssm.entity.seckill.SuccessKilled;


/**
 * 首先需要配置spring和junit整合  为了junit启动时加载spring ioc容器
 * @author wangqiang
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration(("classpath:spring/spring-dao.xml"))
public class TestSuccessKilledDao {
	//注入dao实现类依赖
	@Resource
	private SuccessKilledDao skdao;
	
	@Test
	public void testInsertSuccessKilled(){
		System.out.println(skdao.insertSuccessKilled(2, 13032831812L));
		
	}
	@Test
	public void testQueryByIdWithSeckill(){
		SuccessKilled SK=skdao.queryByIdWithSeckill(3,888888L);
		System.out.println(SK.toString());
		System.out.println(SK.getSeckill().toString());
	}
	
	
	

}
