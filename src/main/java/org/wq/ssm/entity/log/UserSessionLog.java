package org.wq.ssm.entity.log;

public class UserSessionLog {
	private String sessionIdString;//用户session ID
	private String ipString;//用户ip
	private String firstTimeString;//第一次创建时间
	public String getSessionIdString() {
		return sessionIdString;
	}
	public void setSessionIdString(String sessionIdString) {
		this.sessionIdString = sessionIdString;
	}
	public String getIpString() {
		return ipString;
	}
	public void setIpString(String ipString) {
		this.ipString = ipString;
	}
	public String getFirstTimeString() {
		return firstTimeString;
	}
	public void setFirstTimeString(String firstTimeString) {
		this.firstTimeString = firstTimeString;
	}
	public UserSessionLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSessionLog(String sessionIdString, String ipString, String firstTimeString) {
		super();
		this.sessionIdString = sessionIdString;
		this.ipString = ipString;
		this.firstTimeString = firstTimeString;
	}
	
	
}
