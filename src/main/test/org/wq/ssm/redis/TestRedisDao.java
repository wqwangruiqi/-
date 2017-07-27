package org.wq.ssm.redis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wq.ssm.redis.RedisDao;
import org.wq.ssm.dao.seckill.SeckillDao;
import org.wq.ssm.entity.seckill.Seckill;


/**
 * 首先需要配置spring和junit整合  为了junit启动时加载spring ioc容器
 * @author wangqiang
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration(("classpath:spring/spring-dao.xml"))
public class TestRedisDao {
	//注入dao实现类依赖
	@Resource
	private RedisDao  redisDao;
	@Resource
	private SeckillDao  seckillDao;
	
	@Test
	public void TestetSeckill(){
		Seckill  seckill=redisDao.getSeckill(2);
		if(seckill==null){
			seckill=seckillDao.queryById(2);
			String ss=redisDao.putSeckill(seckill);
			System.out.println(ss);
		}
		System.out.println(seckill.toString());
	}
	@Test
	public void TestPutSeckill(){
		
	} 
	

}
