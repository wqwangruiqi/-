package org.wq.ssm.dto.seckill;

import org.wq.ssm.entity.seckill.SuccessKilled;
import org.wq.ssm.enums.SeckillStatEnum;

/**
 * 封装秒杀执行后的结果
 * @author wangqiang
 *
 */
public class SeckillExecution {
	
	private long seckillId;
	//秒杀执行状态
	private int state;
	//状态对应的字符串说明
	private String stateInfo;
	//秒杀成功后的对象返回
	private SuccessKilled successKilled;
	
	
	//秒杀成功后  所有返回对象
	public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.state = seckillStatEnum.getState();
		this.stateInfo = seckillStatEnum.getStateInfo();
		this.successKilled = successKilled;
	}
	//失败的话 返回对象
	public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum) {
		this.seckillId = seckillId;
		this.state = seckillStatEnum.getState();
		this.stateInfo = seckillStatEnum.getStateInfo();
	}
	
	
	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
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
	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}
	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}
	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state + ", stateInfo=" + stateInfo
				+ ", successKilled=" +( successKilled==null?"null":successKilled.toString()) + "]";
	}

	
}
