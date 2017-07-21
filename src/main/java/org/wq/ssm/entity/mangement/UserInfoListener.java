package org.wq.ssm.entity.mangement;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月19日 下午4:53:10
 * 类的说明:用户类
 * UserInfo实现了 HttpSessionBindingListener 后  UserInfo 也就被添加了一个监听事件    
 * 在UserInfo被session绑定 和解除的时候 会执行监听事件
 *
 *UserInfo实现了HttpSessionActivationListener 后  UserInfo保存在session里面的时候 如果服务器重启或关闭 会将session里面UserInfo对象钝化至硬盘
 *如果UserInfo继续实现了Serializable 那么tomcat重启或者启动后 钝化后的UserInfo会被活化
 *注意 活化的话 必须实现 Serializable(序列化)
 *
 */
public class UserInfoListener  implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userPwd;
	
	
	public UserInfoListener() {
	}

	public UserInfoListener(String userName, String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		//session在绑定UserInfo 对象的时候 会执行该方法 注意该类不需要在web.xml里面添加监听
		System.out.println(" 绑定  valueBound  "+event.getName() );
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//session在解除绑定UserInfo 对象的时候 会执行该方法  注意该类不需要在web.xml里面添加监听
		System.out.println("解除绑定  valueUnbound  "+event.getName() );
	}
	
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		//钝化方法
		System.out.println("钝化方法 sessionWillPassivate" + se.getSource().toString());
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		//活化方法
		System.out.println("活化方法 sessionDidActivate" + se.getSource().toString());
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String toString() {
		return "UserInfo [userName=" + userName + ", userPwd=" + userPwd + "]";
	}

	
	
	
}
