package org.wq.ssm.entity.lasw;

import java.text.DecimalFormat;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月7日 下午7:08:23
 * 类的说明:新闻附件
 *
 */
public class LaswNewsAttachment {
	private int id;
	private int laswnewsContentid;//新闻id;
	private String fileName;//附件名字
	private Long fileSize;//附件大小
	private String fileType;//附件类别 pdf  doc .....
	private String filePath;//附件路径 
	@SuppressWarnings("unused")
	private String FILESIZESTRING;//文件大小的字符串
	
	private LaswNewsContent laswNewsContent;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLaswnewsContentid() {
		return laswnewsContentid;
	}

	public void setLaswnewsContentid(int laswnewsContentid) {
		this.laswnewsContentid = laswnewsContentid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public LaswNewsContent getLaswNewsContent() {
		return laswNewsContent;
	}

	public void setLaswNewsContent(LaswNewsContent laswNewsContent) {
		this.laswNewsContent = laswNewsContent;
	}
	
	private	double TB=1024*1024*1024*1024f;
	private	double GB=1024*1024*1024f;
	private	double MB=1024*1024f;
	private	double KB=1024f;
	private DecimalFormat df = new DecimalFormat("#.00");
	public String getFILESIZESTRING() {
		if(fileSize/TB>1){
			return df.format(fileSize/TB)+"TB";
		}else if(fileSize/GB>1){
			return df.format(fileSize/GB)+"GB";
		}else if(fileSize/MB>1){
			return df.format(fileSize/MB)+"MB";
		}else if(fileSize/KB>1){
			return df.format(fileSize/KB)+"KB";
		}else {
			return fileSize+"B";
		}
	}

	@Override
	public String toString() {
		return "LaswNewsAttachment [id=" + id + ", laswnewsContentid=" + laswnewsContentid + ", fileName=" + fileName
				+ ", fileSize=" + fileSize + ", fileType=" + fileType + ", filePath=" + filePath + ", FILESIZESTRING="
				+ getFILESIZESTRING() + ", laswNewsContent=" + (laswNewsContent==null?"null":laswNewsContent.getId() )+ "]";
	}
 
	
	
	
	
}
