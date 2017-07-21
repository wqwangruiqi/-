package org.wq.ssm.dto.seckill;


//所有ajax请求返回类型, 封装json结果
public class Resout<T> {
	private boolean success;
	private T data;
	
	
	public Resout() {
	}
	
	
	public Resout(boolean success, T data) {
		this.success = success;
		this.data = data;
	}


	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Resout [success=" + success + ", data=" + data + "]";
	}
	 
	

}
