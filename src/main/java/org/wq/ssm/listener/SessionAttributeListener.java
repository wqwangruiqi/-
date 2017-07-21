package org.wq.ssm.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月19日 下午3:12:58
 * 类的说明:session 监听器
 *属性值的 添加 删除 替换等事件
 */
//@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener{

	 
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("Session attributeAdded :"+event.getName());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("Session attributeRemoved :"+event.getName());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Session attributeReplaced :"+event.getName());
	}
 

	 

}
