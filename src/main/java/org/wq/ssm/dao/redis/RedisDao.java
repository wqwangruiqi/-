package org.wq.ssm.dao.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wq.ssm.entity.seckill.Seckill;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 访问Redis数据库
 * @author wangqiang
 *
 */
public class RedisDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private JedisPool  jedisPool;//jedis数据池
	
	public RedisDao(String ip,int port){
		jedisPool=new JedisPool(ip,port);
	}
	
	//schema 序列化
	private RuntimeSchema<Seckill> schema= RuntimeSchema.createFrom(Seckill.class);
	
	public Seckill getSeckill(long seckillId){
		Jedis jedis =null;
		try {
			//redis操作逻辑
			jedis =  jedisPool.getResource();
			String key="seckill:"+seckillId;
			//jedis并没有实现内部序列化操作 所以jedis get的是一个byte数组 所以需要反序列化
			//序列化 我们可以只是让 Seckill   implements   Serializable 但是这个效率不高
			//序列化 我们采用自定义的序列化方式
			byte[] bytes=jedis.get(key.getBytes());
			//缓存重获取到
			if(bytes!=null){
				//空对象
				Seckill seckill=schema.newMessage();
				ProtostuffIOUtil.mergeFrom(bytes,seckill , schema);
				//seckill 被反序列化了
				return seckill;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return null;
	}
	public String putSeckill(Seckill seckill){
		Jedis jedis =null;
		try {
			//redis操作逻辑
			jedis =  jedisPool.getResource();
			String key="seckill:"+seckill.getSeckillId();
			//LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE) 缓存器
			byte[] bytes=ProtostuffIOUtil.toByteArray(seckill,schema , LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
			//超时缓存
			int timeout=60*60;//jedis缓存单位是秒 我们这是为一小时
			String result=jedis.setex(key.getBytes(), timeout, bytes);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return null;
	}
	
}
