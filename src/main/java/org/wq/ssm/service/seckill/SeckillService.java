package org.wq.ssm.service.seckill;

import java.util.List;

import org.wq.ssm.dto.seckill.Exposer;
import org.wq.ssm.dto.seckill.SeckillExecution;
import org.wq.ssm.entity.seckill.Seckill;
import org.wq.ssm.exception.seckill.RepeatKillException;
import org.wq.ssm.exception.seckill.SeckillCloseException;
import org.wq.ssm.exception.seckill.SeckillException;

/**
 * 业务接口：站在  使用者  的角度 设计接口
 * 三个方面：
 * 	1 方法定义粒度 
 * 	2 参数越简单 越直接更高
 * 	3 返回类型(return 类型/异常)
 * @author wangqiang
 *
 */

public interface SeckillService {
	
	/**
	 * 查询所有的秒杀记录
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	
	/**
	 * 根据id返回一个秒杀记录
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * 秒杀开启时 输出秒杀接口的地址
	 *            否者 输出系统时间和秒杀时间
	 *        达到效果  秒杀开启时才有秒杀地址
	 *        否则谁也不知道秒杀地址
	 * @param seckillId
	 * @return
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	
	/**
	 * 执行秒杀操作 
	 * 根据秒杀商品的id  用户电话号码  和 秒杀的地址
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution excuteSeckill(long seckillId,long userPhone,String md5)
	throws SeckillException,SeckillCloseException,RepeatKillException;
	
	/**
	 * 执行秒杀操作  使用存储过程
	 * 根据秒杀商品的id  用户电话号码  和 秒杀的地址
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution excuteSeckillProcedure(long seckillId,long userPhone,String md5)
	throws SeckillException,SeckillCloseException,RepeatKillException;
	
	 
	
}






