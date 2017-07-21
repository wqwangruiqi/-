package org.wq.ssm.exception.management;

import org.wq.ssm.enums.LaswNewsEnum;

public class LaswException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private Integer state;
	private String stateInfo;
	
	public LaswException() {
		
    }
	
	
	public LaswException(LaswNewsEnum laswNewsEnum) {
        super(laswNewsEnum.getStateInfo());
        this.state = laswNewsEnum.getState();
        this.stateInfo=laswNewsEnum.getStateInfo();
    }
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

}
