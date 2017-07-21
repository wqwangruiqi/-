package org.wq.ssm.dao.seckill;

import org.apache.ibatis.annotations.Param;
import org.wq.ssm.entity.seckill.SuccessKilled;

/**
 * 秒杀成功 对象dao
 * @author wangqiang
 *
 */
public interface SuccessKilledDao {

	/**
	 * 插入秒杀成功的明细  商品id  秒杀的电话号码  (可过滤前台用户重复操作 避免用户秒杀成功后继续秒查)
	 * @param seckillId
	 * @param userPhone
	 * @return  插入的行数数量
	 */
	int insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	/**
	 * 根据id查询 succeedkilled 并携带秒杀产品对象实体
	 * @param seckillId
	 * @return 
	 */
	SuccessKilled  queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	
	
}
