package org.wq.ssm.dao.lasw;

import java.util.List;

import org.wq.ssm.entity.lasw.LaswNewsAttachment;
import org.wq.ssm.entity.lasw.LaswNewsContent;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月10日 上午10:14:05
 * 类的说明:新闻详细信息的dao
 *
 */
public interface LaswNewsAttachmentDao {
	/**
	 * 
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:22:16
	 * 方法的说明: 根据id获取文档
	 *TODO
	 * @param attachmentId
	 * @return
	 *
	 */
	LaswNewsAttachment queryById(int attachmentId);
	
	
	/**
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:29:12
	 * 方法的说明: 根据新闻内容id获取对象列表
	 *TODO
	 * @param contentId
	 * @return
	 *
	 */
	List<LaswNewsAttachment> queryByContentId(int contentId);
	
	
	
	/**
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月12日 下午3:48:05
	 * 方法的说明: 保存对象
	 *TODO
	 * @param attachmentList
	 * @param content
	 * @return
	 *
	 */
	int insert(List<LaswNewsAttachment> attachmentList,LaswNewsContent content );
	
	/**
	 * 
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:21:42
	 * 方法的说明: 
	 *TODO
	 * @param attachment
	 * @return
	 *
	 */
	int update(LaswNewsAttachment attachment);
	
	/**
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:21:01
	 * 方法的说明: 删除对象
	 *TODO
	 * @param attachmentId
	 * @return
	 *
	 */
	int delete(int attachmentId);
	

}
