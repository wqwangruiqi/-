package org.wq.ssm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月18日 下午6:37:16
 * 类的说明:aspect 切面处理
 *给指定规则的类、方法做通知吧
 */
@Aspect
@Component
public class HttpAspect {

    private     Logger logger   =   LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * org.wq.ssm.web.management.ManagementController.*(..))")
    public void log() {
    	//System.out.println("暂时不做任何处理 方便下面的方法使用统一的execution 配置");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //HttpServletRequest request = attributes.getRequest();
        //可以获取请求参数 做日志记录等操作  还可以检查表单字段等
        //url
        /*logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());*/
        
        //暂时不做任何处理
        
    }

    @After("log()")
    public void doAfter(JoinPoint joinPoint) {
    /*	logger.info("After增强：被织入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    	logger.info("After增强：目标方法的参数为：" + Arrays.toString(joinPoint.getArgs()));
    	logger.info("After增强：被织入增强处理的目标对象为" + joinPoint.getTarget());*/
    	//进行一下操作 如 销毁对象等
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }


}
