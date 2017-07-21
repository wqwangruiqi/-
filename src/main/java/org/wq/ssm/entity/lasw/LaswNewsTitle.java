package org.wq.ssm.entity.lasw;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author wangqiang 联系邮箱:417297506@qq.com 2017年7月7日 下午6:47:35 类的说明:新闻标题对象
 *
 */
public class LaswNewsTitle {
	private int id;
	@NotBlank(message = "新闻标题必须不为空")
	@Size(min = 1, max = 200, message = "新闻标题长度为1至200")
	private String titleName;// 标题名字
	private int clickNumber;// 点击次数
	@NotNull(message = "新闻所属类别必选")
	private Long laswmenuId;// 对应的菜单类别
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date insertTime;// 添加的时间
	private Date updateTime;// 修改的时间(置顶的时候 好排序)
	@Min(value = 0, message = "是否置顶值小于最小值")
	@Max(value = 1, message = "是否置顶值大于最大值")
	private int istop;// 是否置顶
	private int isdelete;// 是否删除 0 未删除 1删除
	private LaswMenu laswMenu;
	private LaswNewsContent laswNewsContent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public int getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(int clickNumber) {
		this.clickNumber = clickNumber;
	}

	public Long getLaswmenuId() {
		return laswmenuId;
	}

	public void setLaswmenuId(Long laswmenuId) {
		this.laswmenuId = laswmenuId;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getIstop() {
		return istop;
	}

	public void setIstop(int istop) {
		this.istop = istop;
	}

	public LaswMenu getLaswMenu() {
		return laswMenu;
	}

	public void setLaswMenu(LaswMenu laswMenu) {
		this.laswMenu = laswMenu;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public LaswNewsContent getLaswNewsContent() {
		return laswNewsContent;
	}

	public void setLaswNewsContent(LaswNewsContent laswNewsContent) {
		this.laswNewsContent = laswNewsContent;
	}

	@Override
	public String toString() {
		return "LaswNewsTitle [id=" + id + ", titleName=" + titleName + ", clickNumber=" + clickNumber + ", laswmenuId="
				+ laswmenuId + ", insertTime=" + insertTime + ", updateTime=" + updateTime + ", istop=" + istop
				+ ", isdelete=" + isdelete + ", laswMenu=" + (laswMenu == null ? "" : laswMenu) + ", laswNewsContent="
				+ (laswNewsContent == null ? "" : laswNewsContent) + "]";
	}

}
