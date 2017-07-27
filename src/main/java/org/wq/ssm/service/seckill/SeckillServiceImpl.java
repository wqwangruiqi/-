package org.wq.ssm.service.seckill;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.wq.ssm.dao.seckill.SeckillDao;
import org.wq.ssm.dao.seckill.SuccessKilledDao;
import org.wq.ssm.dto.seckill.Exposer;
import org.wq.ssm.dto.seckill.SeckillExecution;
import org.wq.ssm.entity.seckill.Seckill;
import org.wq.ssm.entity.seckill.SuccessKilled;
import org.wq.ssm.enums.SeckillStatEnum;
import org.wq.ssm.exception.seckill.RepeatKillException;
import org.wq.ssm.exception.seckill.SeckillCloseException;
import org.wq.ssm.exception.seckill.SeckillException;
import org.wq.ssm.redis.RedisDao;

//@Component  代表所有的组建  当不知道是哪个组建的时候 可以使用该注解
//@Service
//@Dao
//@Contoller
@Service
public class SeckillServiceImpl implements SeckillService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// 注入Service依赖 可以使用注解 @Resource @Inject 等j2ee规范注解
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessKilledDao successKilledDao;
	@Autowired
	private RedisDao redisDao;

	// md5盐值字符串 用于混淆MD5
	private final String slat = "asfd456's;d/.ds/fsdfsa=12=(*&@#%_)(*Uhkj@JM<>?";

	@Override
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 10);
	}

	@Override
	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {

		// 优化点：获取Seckill的时候可以 缓存优化
		// 优化点： 缓存优化 超时的基础上维护一致性
		/*
		 * Seckill = get from cache if Seckill null get db put cache return
		 * Seckill else return Seckill
		 * 
		 */
		// 访问redis 获取缓存的数据
		Seckill seckill = redisDao.getSeckill(seckillId);
		if (seckill == null) {
			seckill = seckillDao.queryById(seckillId);
			if (seckill == null) {
				return new Exposer(false, seckillId);
			} else {
				redisDao.putSeckill(seckill);
			}
		}

		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		// 当前时间
		Date now = new Date();
		if (now.getTime() < startTime.getTime() || now.getTime() > endTime.getTime()) {
			return new Exposer(false, seckillId, now.getTime(), startTime.getTime(), endTime.getTime());
		}
		// 转化特定字符串的过程 MD5不可逆
		String md5 = getMd5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	// 不希望被外界访问 所以private修饰
	// 用户返回MD5字符串
	private String getMd5(long seckillId) {
		String base = seckillId + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	@Override
	@Transactional
	/**
	 * 使用注解控制事务方法的优点: 1 开发团队打成一致的约定 明确标注事务方法的编程风格。 看见注解就知道是事务 2
	 * 保证事务方法的执行时间尽可能短,不要穿插其他的网络操作 如:RPC/HTTP请求 或者将这些类似的时间较长的方法剥离到事务方法外部 3
	 * 不是所有的方法都需要事务 如只有一条修改操作 或者只读操作 不需要事务控制
	 */
	// 执行秒杀方法
	public SeckillExecution excuteSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, SeckillCloseException, RepeatKillException {
		if (md5 == null || !md5.equals(getMd5(seckillId))) {
			throw new SeckillException("秒杀地址不正确或者秒杀地址被恶意篡改......");
		}
		// 执行秒杀逻辑 减库存+记录购买行为(优化方式1:先记录购买明细 其次再减少库存)
		//															(深度优化：事务在mysql服务端 使用存储过程)
		try {
			Date nowTime = new Date();
			// 记录购买行为 唯一验证 id+userPhone
			int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
			if (insertCount <= 0) {
				// 重复秒杀
				throw new RepeatKillException("你已经秒杀成功不可重复秒杀");
			} else {
				// 减库存 秒杀商品竞争点在减库存
				int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
				if (updateCount <= 0) {
					// 没有更新到记录 我们不关心到底是时间过期 还是 库存为0 都总结为 秒杀结束
					throw new SeckillCloseException("秒杀结束.....");
				} else {
					// 秒杀成功
					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillStatEnum.SUCCES, successKilled);
				}

			}

		} catch (SeckillCloseException e) {
			throw e;// 拦截秒杀关闭异常
		} catch (RepeatKillException e) {
			throw e;// 拦截秒杀重复异常
		} catch (Exception e) {// 如果数据库连接超时 或者 连接断了 等等异常
			logger.error(e.getMessage(), e);
			// 将所有的编译期异常 转化成运行期异常 这样spring的申明制事物会帮我们回滚
			throw new SeckillException("其他编译期异常:" + e.getMessage());
		}
	}

	@Override
	public SeckillExecution excuteSeckillProcedure(long seckillId, long userPhone, String md5)  {
		if (md5 == null || !md5.equals(getMd5(seckillId))) {
			return new  SeckillExecution(seckillId,SeckillStatEnum.REPEAT_KILL);
		}
		Date nowTime = new Date();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("seckillId", seckillId);
		map.put("userPhone", userPhone);
		map.put("killTime", nowTime);
		map.put("result", null);
		//执行存储过程完后resule被赋值
		try {
			seckillDao.killByProcedure(map);
			//获取result
			int result=MapUtils.getInteger(map, "result",-2);
			if(result == 1){
				SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
				return new SeckillExecution(seckillId, SeckillStatEnum.SUCCES, successKilled);
			}else {
				return new SeckillExecution(seckillId, SeckillStatEnum.stateof(result));
			}
			 
		} catch (Exception e) {// 如果数据库连接超时 或者 连接断了 等等异常
			logger.error(e.getMessage(), e);
			// 将所有的编译期异常 转化成运行期异常 这样spring的申明制事物会帮我们回滚
			return new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
		}
		
		
	}

}
