package org.wq.ssm.dto.lasw;

import org.wq.ssm.enums.LaswNewsEnum;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月12日 下午6:11:11
 * 类的说明:新闻数据操作 前段返回对象
 *
 */
public class LaswNews {

	private int state;
	private String stateInfo;
	
	
	
	public LaswNews(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public LaswNews(LaswNewsEnum laswNewsEnum) {
		this.state = laswNewsEnum.getState();
		this.stateInfo = laswNewsEnum.getStateInfo();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

}
