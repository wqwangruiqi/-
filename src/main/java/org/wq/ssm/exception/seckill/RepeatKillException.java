package org.wq.ssm.exception.seckill;





/**
 * 重复秒杀异常(运行期异常)
 * 
 * java异常分为 编译期异常+运行期异常
 * 由于spring申明制事物只接受运行期异常回滚策略 非运行期异常不会回滚操作
 * @author wangqiang
 *
 */

public class RepeatKillException extends SeckillException {


	private static final long serialVersionUID = 1L;

	public RepeatKillException(String message) {
		super(message);
	}
	
	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}

}
