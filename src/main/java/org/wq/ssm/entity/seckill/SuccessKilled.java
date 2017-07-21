package org.wq.ssm.entity.seckill;

import java.util.Date;

/**
 * 商品秒杀成功对象
 * 
 * @author wangqiang
 *
 */
public class SuccessKilled {

	private Long seckilled;
	private Long userPhone;
	private int state;
	private Date createTime;
	// 多对一
	private Seckill seckill;

	public Long getSeckilled() {
		return seckilled;
	}

	public void setSeckilled(Long seckilled) {
		this.seckilled = seckilled;
	}

	public Long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public String toString() {
		return "SuccessKilled [seckilled=" + seckilled + ", userPhone=" + userPhone + ", state=" + state
				+ ", createTime=" + createTime + ", seckill=" + seckill + "]";
	}

}
