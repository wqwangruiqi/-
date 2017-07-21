package org.wq.ssm.dao.lasw;

import org.wq.ssm.entity.lasw.LaswNewsContent;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月10日 上午10:14:05
 * 类的说明:新闻详细信息的dao
 *
 */
public interface LaswNewsContentDao {
	
	/**
	 * 
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 下午3:34:23
	 * 方法的说明: 根据标题id获取 新闻内容和标题和文档  
	 * 	注意 新闻内容和标题是一对一关系 新闻内容和文档是一对多关系
	 *TODO
	 * @param titleId
	 * @return
	 *
	 */
	LaswNewsContent queryByTitleIdWithTitleWithAtts(int titleId);
	
	
	/**
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:18:58
	 * 方法的说明: 保存对象
	 *TODO
	 * @param content
	 * @return
	 */
	int insert(LaswNewsContent content);
	
	/**
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:19:37
	 * 方法的说明: 修改对象
	 *TODO
	 * @param content
	 * @return
	 *
	 */
	int update(LaswNewsContent content);
	
	/**
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:20:03
	 * 方法的说明: 删除对象
	 *TODO
	 * @param contentId
	 * @return
	 *
	 */
	int delete(int contentId);
	
	
	

}
