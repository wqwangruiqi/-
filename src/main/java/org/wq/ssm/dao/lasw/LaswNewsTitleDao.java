package org.wq.ssm.dao.lasw;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wq.ssm.entity.lasw.LaswNewsTitle;

/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月10日 上午10:14:05
 * 类的说明:新闻详细信息的dao
 *
 */
public interface LaswNewsTitleDao {
	/**
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:22:58
	 * 方法的说明: 根据菜单id获取新闻标题列表
	 *TODO
	 * @param menuId
	 * @return
	 *
	 */
	List<LaswNewsTitle> queryByMenuId(long menuId);
	
	/**
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:25:06
	 * 方法的说明: 保存对象
	 *TODO
	 * @param title
	 * @return
	 *
	 */
	int insert(LaswNewsTitle title);
	
	/**
	 * 
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:26:09
	 * 方法的说明: 修改对象
	 *TODO
	 * @param titile
	 * @return
	 *
	 */
	int update(LaswNewsTitle titile);
	
	/**
	 * 
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月13日 下午2:53:38
	 * 方法的说明: 修改新闻点击次数
	 *TODO
	 * @param titileId
	 * @return
	 *
	 */
	int updateClickNumber(int titleId);
	
	/**
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月10日 上午10:26:02
	 * 方法的说明: 删除对象
	 *TODO
	 * @param titleId
	 * @return
	 *
	 */
	int delete(int titleId);
	
	
	/**
	 * @author wangqiang
	 *联系邮箱:417297506@qq.com
	 * 2017年7月14日 上午10:02:52
	 * 方法的说明: 根据条件实现分页查询
	 *TODO
	 * @param menuIdF
	 * @param menuIdS
	 * @param newsTitleName
	 * @param beginTime
	 * @param endTime
	 * @return
	 *
	 */
	 List<LaswNewsTitle>queryPage(@Param("menuIdF")Long menuIdF,@Param("menuIdS")Long menuIdS,@Param("newsTitleName")String newsTitleName,@Param("beginTime")Date beginTime,@Param("endTime")Date endTime);

}
