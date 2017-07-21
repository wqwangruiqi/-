package org.wq.ssm.entity.lasw;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author wangqiang 联系邮箱:417297506@qq.com 2017年7月7日 下午7:08:32 类的说明:新闻详细信息表
 *
 */
public class LaswNewsContent {
	private int id;
	private int laswnewsTitleid;// 新闻标题id;
	@NotEmpty(message = "新闻内容必须不为空")
	@Size(min = 1, message = "新闻内容长度必须大于1")
	private String newsContent;// 新闻内容
	private LaswNewsTitle laswNewsTitle;
	private List<LaswNewsAttachment> attachmentList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLaswnewsTitleid() {
		return laswnewsTitleid;
	}

	public void setLaswnewsTitleid(int laswnewsTitleid) {
		this.laswnewsTitleid = laswnewsTitleid;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public LaswNewsTitle getLaswNewsTitle() {
		return laswNewsTitle;
	}

	public void setLaswNewsTitle(LaswNewsTitle laswNewsTitle) {
		this.laswNewsTitle = laswNewsTitle;
	}

	public List<LaswNewsAttachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<LaswNewsAttachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "LaswNewsContent [id=" + id + ", laswnewsTitleid=" + laswnewsTitleid + ", newsContent=" + newsContent
				+ ", laswNewsTitle=" + laswNewsTitle + ", attachmentList=" + attachmentList + "]";
	}

}
