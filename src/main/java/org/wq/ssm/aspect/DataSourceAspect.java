package org.wq.ssm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.wq.ssm.annotation.DataSourceAnnotatin;
import org.wq.ssm.db.DataSourceHolder;

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
public class DataSourceAspect {

    private     Logger logger   =   LoggerFactory.getLogger(this.getClass());

   //@Pointcut("execution(public * org.wq.ssm.dao.lasw.LaswMenuDao.*(..))")
    @Pointcut("execution(* org.wq.ssm.dao..*.*(..))")
    //@Pointcut("@within(org.wq.ssm.annotation.DataSourceAnnotatin)")
    public void parentPcut() {
    	//System.out.println("暂时不做任何处理 方便下面的方法使用统一的execution 配置");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Before("parentPcut()")
    public void doBefore(JoinPoint joinPoint){
    	Object daoObj=joinPoint.getTarget();
    	Class[] interfacesClass = daoObj.getClass().getInterfaces();
    	 for(Class cs:interfacesClass){
    		 DataSourceAnnotatin dataSourceAnnotatin= (DataSourceAnnotatin) cs.getAnnotation(DataSourceAnnotatin.class);
    		 if(dataSourceAnnotatin!=null){
    			 DataSourceHolder.putDataSource(dataSourceAnnotatin.dataSource());
    		 }
    	 }
    	System.out.println("进入 类:"+joinPoint.getTarget()+"   执行的方法是:"+joinPoint.getSignature().getName());
    }

    @After("parentPcut()")
    public void doAfter(JoinPoint joinPoint) {
    	//DataSourceHolder.putDataSource(null);
    	System.out.println("退出 类:"+joinPoint.getTarget()+"   里面的方法:"+joinPoint.getSignature().getName());
    }


}
