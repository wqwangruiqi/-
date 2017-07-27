package org.wq.ssm.dao.lasw;

import java.util.List;

import org.wq.ssm.annotation.DataSourceAnnotatin;
import org.wq.ssm.entity.lasw.LaswMenu;

/**
 * menu 接口
 * 
 * @author wangqiang
 *
 */

@DataSourceAnnotatin(dataSource="master")
public interface LaswMenuDao{
	
	//获取全部
	List<LaswMenu>  queryAll();
	
	//根据id获取对象
	LaswMenu  queryById(long id);
	
	//获取第一层父类对象
	List<LaswMenu>  queryParentFirst();
	
	
	
	
}
