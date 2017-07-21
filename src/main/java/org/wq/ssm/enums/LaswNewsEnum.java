package org.wq.ssm.enums;

public enum  LaswNewsEnum {
	 UNKONW_ERROR(-1, "未知错误"),
	SUCCES(1,"操作成功"),
	FAIL(0,"操作失败"),
	FAIL_TITLE(100,"新闻标题操作失败"),
	FAIL_CONTENT(101,"新闻内容操作失败"),
	FAIL_ATTR(103,"新闻附件操作失败"),
	INNER_ERROR(-2,"系统异常");
	
	private Integer  state;
	private String stateInfo;
	
	LaswNewsEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}
	
	public static LaswNewsEnum stateof(int index){
		for(LaswNewsEnum state:values()){
			if(state.getState()==index){
				return state;
			}
		}
		return null;
	}
	

}
