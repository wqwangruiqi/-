package org.wq.ssm.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月19日 下午3:12:58
 * 类的说明:session 监听器
 *属性值的 添加 删除 替换等事件
 */
//@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("RequestAttributeListener attributeAdded :"+srae.getName());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("RequestAttributeListener attributeRemoved :"+srae.getName());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("RequestAttributeListener attributeAdded :"+srae.getName());
	}

	 

	 

	 

}
