package org.wq.ssm.listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.wq.ssm.entity.log.UserSessionLog;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月19日 下午3:12:58
 * 类的说明:session 监听器
 *可用于记录日志 统计在线人数等
 */
@WebListener
public class SessionListener implements HttpSessionListener{
	private int userNumber=0;//用户在线数量
	
	//private LaswMenuService laswMenuService;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		userNumber++;
		ServletContext servletContext=se.getSession().getServletContext();
		
	/*	
	 * if(laswMenuService==null){
			WebApplicationContext wac = (WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
			//通上面一样都是获取ApplicationContext对象 
			//下面两种方式的区别是，getRequiredWebApplicationContext获取失败时抛出异常，getWebApplicationContext则返回null。
			ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			laswMenuService = wac.getBean(LaswMenuService.class);
		}*/
		//这里就可以根据laswMenuService 操作数据库了
		/*List<LaswMenu> menuListF = laswMenuService.queryParentFirst();
		System.out.println(menuListF.size());*/
		
		//注意：需要将userNumber放在Context当中作为全局值 在整个web应用都可以获取到该值
		servletContext.setAttribute("userNumber", userNumber);
		System.out.println("session创建的时候执行该方法sessionCreated");
		
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sessionDestroyed(HttpSessionEvent se) {
		userNumber--;
		se.getSession().getServletContext().setAttribute("userNumber", userNumber);
		
		
		Map<String, UserSessionLog> userMap= (Map)se.getSession().getServletContext().getAttribute("userMap");
		if(userMap!=null){
			userMap.remove(se.getSession().getId());
			se.getSession().getServletContext().setAttribute("userMap", userMap);
		}
		System.out.println("session销毁的时候执行该方法sessionDestroyed");
	}
}
