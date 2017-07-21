package org.wq.ssm.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.wq.ssm.entity.log.UserSessionLog;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月19日 下午3:12:58
 * 类的说明:session 监听器
 * 可以用来记录在线人数的信息
 */
@WebListener
public class RequestListener implements ServletRequestListener{
	
	Map<String, UserSessionLog> userMap=new HashMap<>();//在线用户Map
	/*
	  jsp页面使用下面方式遍历map值
		<c:forEach items="${userMap}" var="user">
			 	${ user.value.sessionIdString }-----  ${user.value.ipString} ----- ${user.value.firstTimeString }<br/>
		</c:forEach>  
	*/
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		//获取request里面的参数等信息
		//sre.getServletRequest().getParameter("xxxx");
		System.out.println("request初始化执行该方法requestInitialized   ");
		
		userMap=(Map)sre.getServletContext().getAttribute("userMap");
		if(userMap==null){
			userMap=new HashMap<>();
		}
		HttpServletRequest  request=(HttpServletRequest) sre.getServletRequest();
		String sessionId=request.getSession().getId();
		if(userMap!=null && userMap.get(sessionId)==null){
			userMap.put(sessionId, new UserSessionLog(sessionId, request.getRemoteAddr(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
		}
		sre.getServletContext().setAttribute("userMap", userMap);
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		//获取request里面set的对象
		//sre.getServletRequest().getAttribute("xxxx");
		System.out.println("request销毁执行该方法requestDestroyed   ");
		
		
	}
 

	 

	 

}
