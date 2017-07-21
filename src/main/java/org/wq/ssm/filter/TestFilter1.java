package org.wq.ssm.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



@WebFilter(filterName="测试的filter",value={"/*"},dispatcherTypes={DispatcherType.REQUEST,DispatcherType.ASYNC}  )
public class TestFilter1 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//该方法在tomcat容器启动的时候就会执行
		String wq=filterConfig.getInitParameter("WQ");
		System.out.println("TestFilter 执行了 init(初始化)  方法.........");
		System.out.println("TestFilter 执行了 init(初始化)  方法 获取了xml里面的配置值：WQ="+wq);
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("TestFilter 执行  doFilter  方法 start .........");
		chain.doFilter(request, response);
		System.out.println("TestFilter 执行  doFilter  方法 end .........");
	}

	@Override
	public void destroy() {
		//该方法在tomcat容器关闭的时候才会执行
		System.out.println("TestFilter 执行了 destroy(销毁)  方法.........");
	}
 
 

}
