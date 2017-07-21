package org.wq.ssm.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月19日 下午3:12:58
 * 类的说明:context 监听器 的
 * 属性值的 添加 删除 替换等事件
 *
 */
//@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("ContextAttributeListener attributeAdded :"+event.getName());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("ContextAttributeListener attributeRemoved:"+event.getName());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("ContextAttributeListener attributeReplaced:"+event.getName());
	}
	 
 
	 

}
