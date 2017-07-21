package org.wq.ssm.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月19日 下午3:12:58
 * 类的说明:context 监听器
 *
 *
 *注意使用 注解@WebListener的时候 web.xml不再配置listener并且web.xml 头部metadata-complete 必须为false
 *metadata-complete="false"
 */
@WebListener("这是一个注解的Context监听器")
public class ContextListener implements ServletContextListener{
	
	//private LaswMenuService laswMenuService;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext=sce.getServletContext();
		  /*if(laswMenuService==null){
				WebApplicationContext wac = (WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				//通上面一样都是获取ApplicationContext对象 
				//下面两种方式的区别是，getRequiredWebApplicationContext获取失败时抛出异常，getWebApplicationContext则返回null。
				laswMenuService = wac.getBean(LaswMenuService.class);
			} 
			//这里就可以根据laswMenuService 操作数据库了
			 List<LaswMenu> menuListF = laswMenuService.queryParentFirst();
			System.out.println(menuListF.size()); */
		
		
		/*
		 * web.xml里面 配置的值
			<context-param>
				<param-name>wq</param-name>
				<param-value>wangqiang</param-value>
			</context-param>
		*/
		//获取初始化参数
		String initparameter=servletContext.getInitParameter("wq");
		servletContext.setAttribute("qjz", "上下文初始化的时候设置全局值");
		System.out.println("上下文初始化时执行该方法contextInitialized  获取initparameter = "+initparameter);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		ServletContext sc=sce.getServletContext();
		String qjz = (String) sc.getAttribute("qjz");
		System.out.println("上下文销毁的时候获取了 初始化的时候设置的全局值 qjz = "+qjz);
		System.out.println("上下文销毁时执行该方法contextDestroyed ");
	}
 
 
	 

}
