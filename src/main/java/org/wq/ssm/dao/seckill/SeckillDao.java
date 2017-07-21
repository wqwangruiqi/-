package org.wq.ssm.dao.seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.wq.ssm.entity.seckill.Seckill;

/**
 * seckill 接口
 * 
 * @author wangqiang
 *
 */
public interface SeckillDao {

	/**
	 * 作用 减库存 需要用到商品id 操作时间
	 * 
	 * @param seckillId
	 * @param killTime
	 * @return
	 * 如果影响行数>1 表示更新的记录行数
	 * 
	 */
	int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime") Date killTime);

	/**
	 * 根据秒杀商品id检索秒杀商品对象
	 * 
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);

	/**
	 * 根据偏移量查询秒杀商品列表
	 * (相当于分页)
	 * @param offet
	 * @param limit
	 * @return
	 */
	/*
	 * 如果不加@Param("offet") 会报错
		Caused by: org.apache.ibatis.binding.BindingException: Parameter 'offet' not found. Available parameters are [1, 0, param1, param2]
		因为 java没有保存形参的记录 java在运行期的时候  queryAll(int offet, int limit)    会变成为  queryAll( arg0, arg1) 
		mybatis mapper里面就找不到对应的参数值
		如果只有一个参数值不会报错 但是多个参数就回报错了 所以需要告诉mybatis哪个位置的参数叫什么名字 然后才能找到
		使用mybatis 提供的 注解@Param 可以解决问题		
	 */
	List<Seckill> queryAll(@Param("offet")int offet, @Param("limit")int limit);
	
	
	/**
	 * 使用存储过程执行秒杀
	 * @param paramMap
	 */
	void killByProcedure(Map<String, Object> paramMap);
	

}
