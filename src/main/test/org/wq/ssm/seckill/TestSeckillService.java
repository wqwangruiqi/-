package org.wq.ssm.seckill;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wq.ssm.dto.seckill.Exposer;
import org.wq.ssm.dto.seckill.SeckillExecution;
import org.wq.ssm.entity.seckill.Seckill;
import org.wq.ssm.exception.seckill.RepeatKillException;
import org.wq.ssm.exception.seckill.SeckillCloseException;
import org.wq.ssm.exception.seckill.SeckillException;
import org.wq.ssm.service.seckill.SeckillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ 
				"classpath:spring/spring-dao.xml", 
				"classpath:spring/spring-service.xml" })
public class TestSeckillService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private SeckillService seckillService;

	
	 
	@Test
	public void TestGetSeckillList() {
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}",list);
		/*for(Seckill s: list ){
			System.out.println(s.toString());
		}*/

	}

	@Test
	public void TestGetById() {
		Seckill seckill = seckillService.getById(2L);
		logger.info("seckill={}",seckill);
	}
	@Test
	public void TestExportSeckillUrl() {
		Exposer exposer = seckillService.exportSeckillUrl(2L);
		logger.info("exposer={}",exposer);
		//exposer=Exposer [exposed=false, md5=null, seckillId=2, now=1498981722546, start=1498838400000, end=1498924800000]
		//exposer=Exposer [exposed=true, md5=2bbf3958a1940dce0b7108d2541db461, seckillId=2, now=0, start=0, end=0]


	}


	@Test
	public void TestExcuteSeckill() throws SeckillException, SeckillCloseException, RepeatKillException {
		try {
			SeckillExecution seckillExecution = seckillService.excuteSeckill(2L, 1304323183, "2bbf3958a1940ddce0b7108d2541db461");
			logger.info("seckillExecution={}",seckillExecution);
			
		} catch (RepeatKillException e) {
			logger.error("异常信息为:"+e.getMessage());
		}catch (SeckillCloseException e) {
			logger.error("异常信息为:"+e.getMessage());
		}catch (Exception e) {
			logger.error("异常信息为:"+e.getMessage());
		}
	}
	
	//上面两个方法是单个测试 接下来的测试是将两个业务逻辑联合起来测试
	//集成测试可重复性等
	@Test
	public void testSeckillLogic()  throws Exception{
		long seckillId=3L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()){
			//INFO   cn.wq.skill.TestSeckillService - exposer=Exposer [exposed=true, md5=d3afd8af1b691647d72925f84146ab0d, seckillId=3, now=0, start=0, end=0]
			logger.info("exposer={}",exposer);
			try {
				long phone=9999L;
				SeckillExecution seckillExecution = seckillService.excuteSeckill(seckillId, phone, exposer.getMd5());
				logger.info("seckillExecution={}",seckillExecution);
			} catch (RepeatKillException e) {
				logger.error("异常信息为:"+e.getMessage());
			}catch (SeckillCloseException e) {
				logger.error("异常信息为:"+e.getMessage());
			}
		}else{
			//警告 秒杀未开启
			//WARN  cn.wq.skill.TestSeckillService - exposer=Exposer [exposed=false, md5=null, seckillId=3, now=1498983491216, start=1498838400000, end=1498924800000]

			logger.warn("exposer={}",exposer);
		}
	}
	
	
	
	
	@Test
	public void TestExcuteSeckillProcedure()  throws Exception{
		long seckillId=3L;
		long userPhone=2222222L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()){
			SeckillExecution  seckillExecution=seckillService.excuteSeckillProcedure(seckillId, userPhone, exposer.getMd5());
			logger.info("seckillExecution={}",seckillExecution);
		}else {
			logger.warn("exposer={}",exposer);
		}
	}
	

}
