package org.wq.ssm.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wq.ssm.dto.seckill.Resout;
import org.wq.ssm.exception.management.LaswException;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月18日 下午6:36:29
 * 类的说明:异常的统一处理
 *
 */
@ControllerAdvice
public class ExceptionHandle {

    private   Logger logger = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(value = LaswException.class)//注意这里需要处理的异常类型 如果有多模块 可以 每个模块一个异常父类  一个模块一个对应的处理方法
    @ResponseBody
    public Resout handle(Exception e) {
    	logger.info(e.getMessage());
    	return new Resout(false,e);
    }
}
