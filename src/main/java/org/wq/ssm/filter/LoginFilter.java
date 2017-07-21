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

@WebFilter(filterName="用户登录的filter",value={"/*"},dispatcherTypes={DispatcherType.REQUEST}  )
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 System.out.println("LoginFilter  init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 //比如有些页面需要用户登录后才能进入 
		//这里需要过滤该拦截 检查session里面的用户值
		/*HttpServletRequest httpServletRequest =(HttpServletRequest) request;
		HttpServletResponse httpServletResponse =(HttpServletResponse) response;
		Object obj  = httpServletRequest.getSession().getAttribute("userinfo");
		if(obj!=null){
			//重定向
			httpServletResponse.sendRedirect("目标地址");
		}else{
			httpServletResponse.sendRedirect("其他地址");
		}*/
		
		
	}

	@Override
	public void destroy() {
		System.out.println("LoginFilter  destroy");
	}
 
 

}
