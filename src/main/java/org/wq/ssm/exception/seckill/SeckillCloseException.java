package org.wq.ssm.exception.seckill;



/**
 * 
 * 秒杀关闭异常
 * 如果秒杀关闭了 还要执行秒杀其实是不允许的
 * 
 * @author wangqiang
 *
 */
public class SeckillCloseException extends SeckillException {


	private static final long serialVersionUID = 1L;

	public SeckillCloseException(String message) {
		super(message);
	}
	
	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
	}

}
