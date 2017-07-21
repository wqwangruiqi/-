package org.wq.ssm.service.lasw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wq.ssm.dao.lasw.LaswNewsContentDao;
import org.wq.ssm.entity.lasw.LaswNewsContent;

@Service
public class LaswNewsContentService {
	@Autowired
	private LaswNewsContentDao laswNewsContentDao;
	
	public LaswNewsContent queryByTitleIdWithTitleWithAtts(int titleId){
		return laswNewsContentDao.queryByTitleIdWithTitleWithAtts(titleId);
	}
	 
	
	

}
