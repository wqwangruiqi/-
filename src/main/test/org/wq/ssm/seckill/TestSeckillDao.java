package org.wq.ssm.seckill;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wq.ssm.dao.seckill.SeckillDao;
import org.wq.ssm.entity.seckill.Seckill;


/**
 * 首先需要配置spring和junit整合  为了junit启动时加载spring ioc容器
 * @author wangqiang
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration(("classpath:spring/spring-dao.xml"))
public class TestSeckillDao {
	//注入dao实现类依赖
	@Resource
	private SeckillDao  seckillDao;
	
	@Test
	public void testQueryById(){
		Seckill S=seckillDao.queryById(4);
		System.out.println(S.toString());
	}
	@Test
	public void testQueryAll(){
		List<Seckill> list=seckillDao.queryAll(0, 4);
		for(Seckill ss: list){
			System.out.println(ss);
		}
	}
	
	@Test
	public void testReduceNumber(){
		System.out.println(seckillDao.reduceNumber(2, new Date()));
	}
	
	

}
