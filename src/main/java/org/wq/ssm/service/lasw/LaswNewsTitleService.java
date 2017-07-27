package org.wq.ssm.service.lasw;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wq.ssm.dao.lasw.LaswNewsAttachmentDao;
import org.wq.ssm.dao.lasw.LaswNewsContentDao;
import org.wq.ssm.dao.lasw.LaswNewsTitleDao;
import org.wq.ssm.entity.lasw.LaswNewsAttachment;
import org.wq.ssm.entity.lasw.LaswNewsContent;
import org.wq.ssm.entity.lasw.LaswNewsTitle;
import org.wq.ssm.enums.LaswNewsEnum;
import org.wq.ssm.exception.management.LaswException;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class LaswNewsTitleService {
	
	@Autowired
	private LaswNewsTitleDao laswNewsTitleDao;
	@Autowired
	private LaswNewsContentDao laswNewsContentDao;
	@Autowired
	private LaswNewsAttachmentDao laswNewsAttachmentDao;
	
	
	@PostConstruct
	public void init(){
		//System.out.println("初始化前运行");
	}
	@PreDestroy
	public void destroy(){
		//System.out.println("销毁后运行");
	}
	
	//保存新闻  注意 这里需要事务
	@Transactional
	public boolean insert(LaswNewsTitle laswNewsTitle,LaswNewsContent content,List<LaswNewsAttachment> attachmentList) throws Exception{
		//保存新闻标题
		laswNewsTitleDao.insert(laswNewsTitle);
		int titleId=laswNewsTitle.getId();
		if(titleId>0){
			//保存 新闻内容
			content.setLaswnewsTitleid(titleId);
			laswNewsContentDao.insert(content);
			int contentId=content.getId();
			if(contentId>0){
				
				if(attachmentList!=null && attachmentList.size()>0){
					//保存附件
					 int insertNumber=laswNewsAttachmentDao.insert(attachmentList,content);
					 if(insertNumber==attachmentList.size()){
						 //表示保存成功
						 return true;
					 }else{
						 //保存失败
						throw new LaswException(LaswNewsEnum.FAIL_ATTR);
					 }
				}else{
					//没有附件上传
					return true;
				}
			}else{
				//保存失败
				throw new LaswException(LaswNewsEnum.FAIL_CONTENT);
			}
		}else{
			//保存失败
			throw new LaswException(LaswNewsEnum.FAIL_TITLE);
		}
	}
	
	
	@Transactional
	public boolean update(LaswNewsTitle laswNewsTitle,LaswNewsContent laswNewsContent) throws Exception{
		int updateTitleNumber=laswNewsTitleDao.update(laswNewsTitle);
		if(updateTitleNumber>0){
			//修改成功
			int updateContentNumber=laswNewsContentDao.update(laswNewsContent);
			if(updateContentNumber>0){
				//修改成功
				return true;
			}else{
				//修改失败
				throw new LaswException(LaswNewsEnum.FAIL_CONTENT);
			}
		}else{
			//修改失败
			throw new LaswException(LaswNewsEnum.FAIL_TITLE);
		}
	}
	
	
	//根据菜单id获取新闻标题列表
	public List<LaswNewsTitle> queryByMenuId(long menuId){
		return laswNewsTitleDao.queryByMenuId(menuId);
	}
	 
	
	public int delete(int titleId){
		return laswNewsTitleDao.delete(titleId);
	}
	
	public PageInfo<LaswNewsTitle>  queryPage(Long menuIdF,Long menuIdS,String newsTitleName,Date beginTime,Date endTime,PageInfo<LaswNewsTitle> page){
		if(page==null){
			page=new PageInfo<LaswNewsTitle>();
			page.setPageNum(1);
			page.setPageSize(20);
		}
		if(page.getPageNum()==0){
			page.setPageNum(1);
		}
		if(page.getPageSize()==0){
			page.setPageSize(20);
		}
		PageHelper.startPage(page.getPageNum(), page.getPageSize(),true);
		List<LaswNewsTitle> list = laswNewsTitleDao.queryPage(menuIdF, menuIdS, newsTitleName, beginTime, endTime);
		//用PageInfo对结果进行包装
		page = new PageInfo<LaswNewsTitle>(list);
		return page;
		
	}
	

}
