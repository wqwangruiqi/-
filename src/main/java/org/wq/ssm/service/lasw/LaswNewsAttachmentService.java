package org.wq.ssm.service.lasw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wq.ssm.dao.lasw.LaswNewsAttachmentDao;
import org.wq.ssm.entity.lasw.LaswNewsAttachment;

@Service
public class LaswNewsAttachmentService {
	@Autowired
	private LaswNewsAttachmentDao newsAttachmentDao;
	 
	public LaswNewsAttachment queryById(int attachmentId){
		return newsAttachmentDao.queryById(attachmentId);
	}
	
	 
	public List<LaswNewsAttachment> queryByContentId(int contentId){
		return newsAttachmentDao.queryByContentId(contentId);
	}
	
	 
	public int update(LaswNewsAttachment attachment){
		return newsAttachmentDao.update(attachment);
	}
	 
	public int delete(int attachmentId){
		return newsAttachmentDao.delete(attachmentId);
	}
	
	

}
